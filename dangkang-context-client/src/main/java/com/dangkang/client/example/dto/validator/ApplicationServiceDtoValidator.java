package com.dangkang.client.example.dto.validator;

import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import com.dangkang.client.example.dto.request.ExampleServiceRequestDTO;

/**
 * 入参校验器示例
 */
public class ApplicationServiceDtoValidator extends ValidatorHandler<ExampleServiceRequestDTO> implements Validator<ExampleServiceRequestDTO> {

    @Override
    public boolean validate(ValidatorContext context, ExampleServiceRequestDTO exampleServiceRequestDTO) {
        if(exampleServiceRequestDTO.getEmail() == null){
            context.addErrorMsg("不能为空");
            return false;
        }
        return true;
    }
}
