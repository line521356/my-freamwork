package com.lucius.server.config;

import com.lucius.common.support.dao.reposiotry.base.BaseRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Map;

/**
 * <br>
 *
 * @author Lucius
 * create by 2018/2/28
 * @Emial Lucius.li@ixiaoshuidi.com
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="caspainaEntityManagerFactory",
        transactionManagerRef="caspainTransactionManager",
        basePackages= { "com.lucius.business.dao.caspain" },repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
public class CaspainDataSourceConfig {

    @Autowired
    private JpaProperties jpaProperties;


    @Autowired
    @Qualifier("caspainDataSource")
    private DataSource caspainDataSource;

    @Bean(name = "caspainEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean caspainEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(caspainDataSource)
                .properties(getVendorProperties(caspainDataSource))
                .packages("com.lucius.business.model.caspain")
                .persistenceUnit("caspainPersistenceUnit")
                .build();
    }

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Bean(name = "caspainEntityManagerFactory")
    public EntityManagerFactory caspainEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return this.caspainEntityManagerFactoryBean(builder).getObject();
    }

    /**
     * 配置事物管理器
     * @return
     */
    @Bean(name = "caspainTransactionManager")
    public PlatformTransactionManager writeTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(caspainEntityManagerFactory(builder));
    }
}
