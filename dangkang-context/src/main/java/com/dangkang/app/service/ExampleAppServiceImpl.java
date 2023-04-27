package com.dangkang.app.service;

import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;
import com.dangkang.app.ability.rule.DomainLogicalCheck;
import com.dangkang.app.ability.service.DomainService;
import com.dangkang.app.service.transaction.ExampleServiceTransaction;
import com.dangkang.application.annotation.ServiceDesc;
import com.dangkang.application.dto.response.Response;
import com.dangkang.client.example.api.ExampleAppService;
import com.dangkang.client.example.dto.request.ExampleServiceRequestDTO;
import com.dangkang.client.example.dto.response.ExampleServiceResultDTO;
import com.dangkang.domain.example.ability.facade.ExternalAccessFacade;
import com.dangkang.domain.example.model.DomainObject;
import com.dangkang.exception.annotation.ExceptionAndValid;
import com.dangkang.infrastructure.example.converter.DomainObjectConverter;
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
    private ExampleServiceTransaction exampleServiceTransaction;
    @Autowired
    private ExternalAccessFacade externalAccessFacade;

    @ExceptionAndValid
    @ServiceDesc(ServiceCode = "T001",ServiceName = "当康应用服务")
    public Response<ExampleServiceResultDTO> execute(@FluentValid(isFailFast=false) ExampleServiceRequestDTO exampleServiceRequestDTO) {

        Response<ExampleServiceResultDTO> response = new Response<>();
        ExampleServiceResultDTO exampleServiceResultDTO = new ExampleServiceResultDTO();
            //todo 业务逻辑编排
            // 1 使用@FluentValid注解进行输入参数校验 (应用Fluent-Validator + Hibernate-Validator )


            // 2.1 调用领域内提供的查询服务(ddd Repository)
            DomainObject domainObject = domainService.findAndCheckEmpty(exampleServiceRequestDTO.getPhoneNumber());
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
