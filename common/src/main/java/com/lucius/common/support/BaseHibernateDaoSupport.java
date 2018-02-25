package com.lucius.common.support;


import com.lucius.common.support.model.Order;
import com.lucius.common.support.model.Pager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017\8\19 0019.
 */
@NoRepositoryBean
public interface BaseHibernateDaoSupport<Model,Id extends Serializable> extends JpaRepository<Model, Id>,
        JpaSpecificationExecutor<Model> {

    List<Model> findByModel(Model model, Order order, Pager pager);
}
