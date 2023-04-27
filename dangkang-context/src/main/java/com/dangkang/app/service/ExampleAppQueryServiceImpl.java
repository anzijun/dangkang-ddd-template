package com.dangkang.app.service;

import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;
import com.dangkang.application.annotation.ServiceDesc;
import com.dangkang.application.dto.response.MultipleResponse;
import com.dangkang.client.example.api.ExampleAppQueryService;
import com.dangkang.client.example.dto.request.ExampleQueryRequestDTO;
import com.dangkang.client.example.dto.response.ExampleQueryResultDTO;
import com.dangkang.domain.example.repository.DomainObjectRepository;
import com.dangkang.exception.annotation.ExceptionAndValid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @date 2023/1/11 10:51
 */
@Service
public class ExampleAppQueryServiceImpl implements ExampleAppQueryService {
    private static final Logger logger = LoggerFactory.getLogger(ExampleAppQueryServiceImpl.class);

    @Autowired
    private DomainObjectRepository domainObjectRepository;

    @Override
    @ExceptionAndValid
    @ServiceDesc(ServiceCode = "T002",ServiceName = "当康应用查询服务")
    public MultipleResponse<ExampleQueryResultDTO> queryService(@FluentValid(isFailFast = false) ExampleQueryRequestDTO exampleQueryRequestDTO) {

        MultipleResponse<ExampleQueryResultDTO> response = new MultipleResponse<>();
        int index = exampleQueryRequestDTO.getIndex();
        int size = exampleQueryRequestDTO.getSize();
        String email = exampleQueryRequestDTO.getEmail();
        //1 查询参数校验(@FluentValid注解验证)
        //2 从数据库获取数据并分页处理
         Map<String,Object> pages = domainObjectRepository.findPage(index,size,email);
         //3 构建成功返回结果
        response.buildPage( pages);
        response.buildSuccess(SERVICE_CODE, SERVICE_NAME);
        return response;

    }

}
