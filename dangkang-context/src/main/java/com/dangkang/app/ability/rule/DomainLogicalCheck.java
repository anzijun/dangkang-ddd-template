package com.dangkang.app.ability.rule;

import com.dangkang.domain.example.model.DomainObject;
import com.dangkang.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * 业务领域规则对象:复杂业务规则的封装
 * @date 2022/12/23 13:53
 */
@Component
public class DomainLogicalCheck {

    private static final Logger logger = LoggerFactory.getLogger(DomainLogicalCheck.class);
    private static final String ERR_DOMAINLOGICRULE_CODE="V002";
    private static final String ERR_DOMAINLOGICRULE_MESSAGE="领域规则校验出错提示";

    /**
     *
     * 业务规则校验异常示例
     */
    public void check(DomainObject domainObject) {

        //todo 领域校验逻辑执行
        logger.info("领域校验逻辑执行");
        //业务规则校验示例 实际业务规则应是有关多个领域对象的属性或复杂规则验证
        if("domainrule@email.com".equals(domainObject.getEmail())){
            throw new ValidationException().setErrorCode(ERR_DOMAINLOGICRULE_CODE)
                                            .setPromptMessage(ERR_DOMAINLOGICRULE_MESSAGE);
        }

    }

}
