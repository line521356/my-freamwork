package com.lucius.business.service.impl;

import com.lucius.business.dao.HouseRepository;
import com.lucius.business.model.House;
import com.lucius.business.service.HouseService;
import com.lucius.common.support.dao.reposiotry.kit.SimplePageBuilder;
import com.lucius.common.support.dao.reposiotry.kit.SimpleSortBuilder;
import com.lucius.common.support.dao.specification.SimpleSpecification;
import com.lucius.common.support.dao.specification.SimpleSpecificationBuilder;
import com.lucius.common.support.dao.specification.SpecificationOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.plugin.core.SimplePluginRegistry;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public Page<House> findByModel(House model) {
        Specification <House> specification = new SimpleSpecificationBuilder()
                .add("roomNo",":","x")
                .generateSpecification();
        Page <House> page = houseRepository.findAll(specification
                ,SimplePageBuilder.generate(0,10
                        , SimpleSortBuilder.generateSort("id")));
        return page;
    }


}
