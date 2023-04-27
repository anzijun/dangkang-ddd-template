package com.dangkang.examplecontext.app.ability.service;

import com.dangkang.examplecontext.domain.model.DomainObject;
import com.dangkang.examplecontext.domain.repository.DomainObjectRepository;
import com.dangkang.exception.DangKangAppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 领域服务实现逻辑
 * @date 2022/12/23 11:29
 */
@Component
public class DomainService {

    private static final String ERR_DOMAIN_SERVICE_CODE="S001";
    private static final String ERR_DOMAIN_SERVICE_MESSAGE="领域服务出错提示";
    private static final Logger logger = LoggerFactory.getLogger(DomainService.class);

    @Autowired
    private DomainObjectRepository domainObjectRepository;

    public void doService(DomainObject domainObject) {
        //todo 封装多个聚合协作并具有一定重用性的功能，可能会在多个applicationService之间重用。
        domainObject.toDo();
        //领域服务抛出异常示例
        if("domainService@email.com".equals(domainObject.getEmail())){
            throw new DangKangAppException().setErrorCode(ERR_DOMAIN_SERVICE_CODE)
                                            .setPromptMessage(ERR_DOMAIN_SERVICE_MESSAGE);
        }
    }

    public DomainObject findAndCheckEmpty(String phoneNumber) {
        return domainObjectRepository.findAndCheckEmpty(phoneNumber);
    }
}
