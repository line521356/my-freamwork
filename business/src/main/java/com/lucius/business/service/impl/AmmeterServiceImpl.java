package com.lucius.business.service.impl;

import com.lucius.business.dao.AmmeterRepository;
import com.lucius.business.model.Ammeter;
import com.lucius.business.service.AmmeterService;
import com.lucius.common.support.dao.reposiotry.kit.SimplePageBuilder;
import com.lucius.common.support.dao.reposiotry.kit.SimpleSortBuilder;
import org.springframework.data.domain.Page;
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
        return ammeterRepository.findAll(SimplePageBuilder.generate(0,10
                , SimpleSortBuilder.generateSort("id_d")));
    }
}
