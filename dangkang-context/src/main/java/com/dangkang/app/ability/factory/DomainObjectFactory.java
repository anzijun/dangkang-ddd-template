package com.dangkang.app.ability.factory;

import com.dangkang.domain.example.model.DomainObject;
import org.springframework.stereotype.Component;

@Component
public class DomainObjectFactory {

    public DomainObject initDomainObject(String email, String phoneNumber) {

        DomainObject domainObject = new DomainObject(email,phoneNumber);
        return domainObject;
    }
}
