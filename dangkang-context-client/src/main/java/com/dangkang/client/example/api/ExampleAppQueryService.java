package com.dangkang.client.example.api;

import com.dangkang.application.dto.response.MultipleResponse;
import com.dangkang.client.example.dto.request.ExampleQueryRequestDTO;
import com.dangkang.client.example.dto.response.ExampleQueryResultDTO;

/**
 * @date 2023/1/10 18:02
 */
public interface ExampleAppQueryService {

    String SERVICE_CODE ="T002";
    String SERVICE_NAME ="dangkang-ddd应用查询类服务描述信息";

    MultipleResponse<ExampleQueryResultDTO> queryService(ExampleQueryRequestDTO exampleQueryRequestDTO);
}
