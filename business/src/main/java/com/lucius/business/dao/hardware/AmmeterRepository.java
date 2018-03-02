package com.lucius.business.dao.hardware;

import com.lucius.business.model.hardware.Ammeter;
import com.lucius.common.support.dao.reposiotry.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <br>
 *
 * @author Lucius
 * create by 2018/2/27
 * @Emial Lucius.li@ixiaoshuidi.com
 */
@Repository
public interface AmmeterRepository extends BaseRepository<Ammeter, Long>,JpaSpecificationExecutor<Ammeter> {


}
