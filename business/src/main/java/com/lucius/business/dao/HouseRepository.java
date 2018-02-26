package com.lucius.business.dao;

import com.lucius.business.model.House;
import com.lucius.common.support.dao.reposiotry.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <br>
 *
 * @author Lucius
 * create by 2018/2/26
 * @Emial Lucius.li@ixiaoshuidi.com
 */
@Repository
public interface HouseRepository extends BaseRepository<House, Long>,JpaSpecificationExecutor<House> {

}
