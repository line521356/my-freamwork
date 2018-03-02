package com.lucius.server.config;

import com.lucius.common.support.dao.reposiotry.base.BaseRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        entityManagerFactoryRef="hardwareEntityManagerFactory",
        transactionManagerRef="hardwareTransactionManager",
        basePackages= { "com.lucius.business.dao.hardware" },repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
public class HardwareDataSourceConfig {

    @Autowired
    private JpaProperties jpaProperties;


    @Autowired
    @Qualifier("hardwareDataSource")
    private DataSource hardwareDataSource;

    @Bean(name = "hardwareEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean hardwareEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(hardwareDataSource)
                .properties(getVendorProperties(hardwareDataSource))
                .packages("com.lucius.business.model.hardware")
                .persistenceUnit("hardwarePersistenceUnit")
                .build();
    }

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Bean(name = "hardwareEntityManagerFactory")
    @Primary
    public EntityManagerFactory hardwareEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return this.hardwareEntityManagerFactoryBean(builder).getObject();
    }

    @Bean(name = "hardwareTransactionManager")
    @Primary
    public PlatformTransactionManager writeTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(hardwareEntityManagerFactory(builder));
    }

}
