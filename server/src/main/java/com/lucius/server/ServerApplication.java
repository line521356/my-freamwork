package com.lucius.server;

import com.lucius.common.support.dao.reposiotry.base.BaseRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author Lucius
 * create by 2017/10/30
 * @Emial lucius_521356@163.com
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.lucius"})
//@EnableJpaRepositories(basePackages = {"com.lucius"},repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
//@EntityScan(basePackages = {"com.lucius.business.model"})
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
}
