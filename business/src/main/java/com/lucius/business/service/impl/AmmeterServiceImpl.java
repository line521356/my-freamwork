package com.lucius.business.service.impl;

import com.lucius.business.dao.hardware.AmmeterRepository;
import com.lucius.business.model.hardware.Ammeter;
import com.lucius.business.service.AmmeterService;
import com.lucius.common.support.dao.reposiotry.kit.SimplePageBuilder;
import com.lucius.common.support.dao.reposiotry.kit.SimpleSortBuilder;
import com.lucius.common.support.dao.specification.SimpleSpecificationBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <br>
 *
 * @author Lucius
 * create by 2018/2/27
 * @Emial Lucius.li@ixiaoshuidi.com
 */
@Service
public class AmmeterServiceImpl implements AmmeterService{

    @Resource
    AmmeterRepository ammeterRepository;


    @Override
    public Page<Ammeter> getAmmeter(Ammeter ammeter) {
        SimpleSpecificationBuilder simpleSpecificationBuilder = new SimpleSpecificationBuilder();
        simpleSpecificationBuilder.add("id","=","1");
        Specification<Ammeter> specification = simpleSpecificationBuilder.generateSpecification();
        Page <Ammeter> page = ammeterRepository.findAll(specification
                ,SimplePageBuilder.generate(0,10
                        , SimpleSortBuilder.generateSort("id_d")));
        return page;
    }
}
