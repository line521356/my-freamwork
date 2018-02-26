package com.lucius.common.support.dao.reposiotry.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * <br>
 *
 * @author Lucius
 * create by 2018/2/17
 * @Emial Lucius.li@ixiaoshuidi.com
 */
@NoRepositoryBean
@Transactional(readOnly=true)
public interface BaseRepository<T,ID extends Serializable> extends JpaRepository<T,ID> {

    boolean support(String modelType);

}
