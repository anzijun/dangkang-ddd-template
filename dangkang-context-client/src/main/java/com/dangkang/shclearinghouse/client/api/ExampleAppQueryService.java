package com.dangkang.shclearinghouse.client.api;

import com.dangkang.application.dto.response.MultipleResponse;
import com.dangkang.shclearinghouse.client.dto.request.ExampleQueryRequestDTO;
import com.dangkang.shclearinghouse.client.dto.response.ExampleQueryResultDTO;

/**
 * @date 2023/1/10 18:02
 */
public interface ExampleAppQueryService {

    String SERVICE_CODE ="T002";
    String SERVICE_NAME ="dangkang-ddd应用查询";

    MultipleResponse<ExampleQueryResultDTO> queryService(ExampleQueryRequestDTO exampleQueryRequestDTO);
}
