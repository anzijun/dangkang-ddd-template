package com.dangkang.client.example.api;

import com.dangkang.application.dto.response.Response;
import com.dangkang.client.example.dto.request.ExampleServiceRequestDTO;
import com.dangkang.client.example.dto.response.ExampleServiceResultDTO;

/**
 * 应用服务
 */
public interface ExampleAppService {
    String SERVICE_CODE ="T001";
    String SERVICE_NAME ="dangkang-ddd应用服务描述信息";

    Response<ExampleServiceResultDTO> execute(ExampleServiceRequestDTO exampleServiceRequestDTO);

}
