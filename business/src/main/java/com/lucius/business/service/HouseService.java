package com.lucius.business.service;


import com.lucius.business.condition.HouseCondition;
import com.lucius.business.model.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * <br>
 *
 * @author Lucius
 * create by 2018/2/26
 * @Emial Lucius.li@ixiaoshuidi.com
 */
public interface HouseService {

    void addHouse(House house);

    Page <House> findByModel(HouseCondition houseCondition,Pageable pageable);

    House findById(Long id);
}
