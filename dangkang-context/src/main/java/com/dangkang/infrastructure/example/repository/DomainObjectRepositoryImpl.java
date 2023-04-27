package com.dangkang.infrastructure.example.repository;

import com.dangkang.client.example.dto.response.ExampleQueryResultDTO;
import com.dangkang.domain.example.model.DomainObject;
import com.dangkang.domain.example.repository.DomainObjectRepository;
import com.dangkang.exception.DangKangAppException;
import com.dangkang.exception.DataBaseException;
import com.dangkang.exception.database.DataBaseErrorManager;
import com.dangkang.infrastructure.example.converter.DomainObjectConverter;
import com.dangkang.infrastructure.example.repository.dataobject.DomainObjectDO;
import com.dangkang.infrastructure.example.repository.mapper.DomainObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DomainObjectRepositoryImpl implements DomainObjectRepository {

    @Autowired
    private DomainObjectMapper domainObjectMapper;


    @Override
    public DomainObject findAndCheckEmpty(String phoneNumber) {

       DomainObjectDO domainObjectDO = domainObjectMapper.select(phoneNumber);
       if(domainObjectDO==null){
           throw new DangKangAppException().setErrorCode(ERR_DOMAINOBJECT_NOT_FOUND_CODE)
                                            .setPromptMessage(ERR_DOMAINOBJECT_NOT_FOUND_MESSAGE);
       }
       return DomainObjectConverter.INSTANCE.toDomainObject(domainObjectDO);
       
    }

    @Override
    public void save(DomainObject domainObject) {
    }

    @Override
    public void update(DomainObject domainObject) {

        DomainObjectDO domainObjectDO = DomainObjectConverter.INSTANCE.toDomainObjectDO(domainObject);

        try {
            domainObjectMapper.update(domainObjectDO);
        } catch (Exception e) {
            throw new DataBaseException().setPromptMessage(DataBaseErrorManager.ERR_DATABASE_MESSAGE)
                                         .setCause(e);
        }
    }

    @Override
    public Map<String,Object> findPage(int index, int size, String email) {
        PageHelper.startPage(index,size);

        List<DomainObject> domainObjects = DomainObjectConverter.INSTANCE.toDomainObjectList(domainObjectMapper.findList(index,size,email));
        List<ExampleQueryResultDTO> exampleQueryResultDtoList = DomainObjectConverter.INSTANCE.toQueryResultDataDtoList(domainObjects);

        PageInfo<ExampleQueryResultDTO> pageInfo = new PageInfo<>(exampleQueryResultDtoList);
        Map<String,Object> pageMap = new HashMap<>();
        pageMap.put("totalPages",pageInfo.getPages());
        pageMap.put("totalSize",pageInfo.getSize());
        pageMap.put("currentIndex",pageInfo.getPageNum());
        pageMap.put("pageSize",pageInfo.getPageSize());
        pageMap.put("dataList",pageInfo.getList());

        return pageMap ;
    }
}
