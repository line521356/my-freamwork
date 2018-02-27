package com.lucius.business.service.impl;

import com.lucius.business.condition.HouseCondition;
import com.lucius.business.dao.HouseRepository;
import com.lucius.business.model.House;
import com.lucius.business.service.HouseService;
import com.lucius.common.support.dao.reposiotry.kit.SimplePageBuilder;
import com.lucius.common.support.dao.reposiotry.kit.SimpleSortBuilder;
import com.lucius.common.support.dao.specification.SimpleSpecificationBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <br>
 *
 * @author Lucius
 * create by 2018/2/26
 * @Emial Lucius.li@ixiaoshuidi.com
 */
@Service
public class HosueServiceImpl implements HouseService{
    @Resource
    HouseRepository houseRepository;
    @Override
    public void addHouse(House house) {
        houseRepository.save(house);
    }

    @Override
    public Page<House> findByModel(HouseCondition houseCondition,Pageable pageable) {
        SimpleSpecificationBuilder simpleSpecificationBuilder = new SimpleSpecificationBuilder();
        if (houseCondition.getId() != null) {
            simpleSpecificationBuilder.add("id", "=", houseCondition.getId());
        }
        if(StringUtils.isNotBlank(houseCondition.getDoor())){
            simpleSpecificationBuilder.add("door", ":", houseCondition.getDoor());
        }
        if(StringUtils.isNotBlank(houseCondition.getRemark())){
            simpleSpecificationBuilder.add("remark", ":", houseCondition.getRemark());
        }
        Specification <House> specification = simpleSpecificationBuilder.generateSpecification();
        Page <House> page = houseRepository.findAll(specification
                ,SimplePageBuilder.generate(pageable.getPageNumber(),pageable.getPageSize()
                        , SimpleSortBuilder.generateSort("id_d")));
        return page;

    }

    @Override
    public House findById(Long id) {
        return houseRepository.getOne(id);
    }


}
