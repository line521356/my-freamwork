package com.lucius.business.service;

import com.lucius.business.model.Ammeter;
import org.springframework.data.domain.Page;

/**
 * <br>
 *
 * @author Lucius
 * create by 2018/2/27
 * @Emial Lucius.li@ixiaoshuidi.com
 */
public interface AmmeterService {

    Page<Ammeter> getAmmeter(Ammeter ammeter);
}
