package com.dangkang.examplecontext.app.service;

import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;
import com.dangkang.examplecontext.app.ability.factory.DomainObjectFactory;
import com.dangkang.examplecontext.app.ability.rule.DomainLogicalCheck;
import com.dangkang.examplecontext.app.ability.service.DomainService;
import com.dangkang.examplecontext.app.service.transaction.ExampleServiceTransaction;
import com.dangkang.application.annotation.ServiceDesc;
import com.dangkang.application.dto.response.Response;
import com.dangkang.examplecontext.client.api.ExampleAppService;
import com.dangkang.examplecontext.client.dto.request.ExampleServiceRequestDTO;
import com.dangkang.examplecontext.client.dto.response.ExampleServiceResultDTO;
import com.dangkang.examplecontext.domain.facade.ExternalAccessFacade;
import com.dangkang.examplecontext.domain.model.DomainObject;
import com.dangkang.exception.annotation.ExceptionAndValid;
import com.dangkang.examplecontext.infrastructure.converter.DomainObjectConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 应用服务层:1、逻辑错误异常等统一处理  2、业务主逻辑步骤
 */
@Service
public class ExampleAppServiceImpl implements ExampleAppService {

    private static final Logger logger = LoggerFactory.getLogger(ExampleAppServiceImpl.class);

    @Autowired
    private DomainService domainService;
    @Autowired
    private DomainLogicalCheck domainLogicalCheck;
    @Autowired
    private DomainObjectFactory domanObjectFactory;
    @Autowired
    private ExampleServiceTransaction exampleServiceTransaction;
    @Autowired
    private ExternalAccessFacade externalAccessFacade;

    // 1 使用@ExceptionAndValid和@FluentValid注解进行异常统一处理和输入参数校验
    @ExceptionAndValid
    @ServiceDesc(ServiceCode = "T001",ServiceName = "DDD应用服务")
    public Response<ExampleServiceResultDTO> execute(@FluentValid(isFailFast=false) ExampleServiceRequestDTO exampleServiceRequestDTO) {
        Response<ExampleServiceResultDTO> response = new Response<>();
        ExampleServiceResultDTO exampleServiceResultDTO = new ExampleServiceResultDTO();
            //todo 业务逻辑编排

            // 2.1 调用领域内提供的查询服务(ddd Repository)
            DomainObject domainObject = domanObjectFactory.initDomainObject(exampleServiceRequestDTO);
            // 2.2 业务规则验证逻辑(ddd 业务规则封装)
            domainLogicalCheck.check(domainObject);
            logger.info("DomainLogicalRule.check领域逻辑规则校验成功,客户号是[{}]",exampleServiceRequestDTO.getEmail());

            // 3.1 领域服务执行(ddd领域服务对象)
            domainService.doService(domainObject);
            logger.info("DomainService.doService领域服务执行成功,客户号是[{}]",exampleServiceRequestDTO.getEmail());

            // 3.2 带事务的领域服务执行
            exampleServiceTransaction.transaction(domainObject);
            logger.info("ExampleServiceTransaction.transaction事务服务执行成功,客户号是[{}]",exampleServiceRequestDTO.getEmail());
            // 3.3 调用第三方接口
            externalAccessFacade.call(DomainObjectConverter.INSTANCE.toCallRequestDto(domainObject));
            logger.info("externalAccessFacade.call执行成功,客户号是[{}]",exampleServiceRequestDTO.getEmail());
            // 4 构建成功返回
            response.buildSuccess(SERVICE_CODE, SERVICE_NAME);
            response.setData(exampleServiceResultDTO);
            logger.info("exampleAppService.execute执行成功,客户号是[{}]",exampleServiceRequestDTO.getEmail());
        return response;
    }
}
