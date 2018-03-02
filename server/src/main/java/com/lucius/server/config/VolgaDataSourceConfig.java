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
        entityManagerFactoryRef="volgaEntityManagerFactory",
        transactionManagerRef="volgaTransactionManager",
        basePackages= { "com.lucius.business.dao.volga" },repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
public class VolgaDataSourceConfig {

    @Autowired
    private JpaProperties jpaProperties;


    @Autowired
    @Qualifier("volgaDataSource")
    private DataSource volgaDataSource;
    /**
     * 我们通过LocalContainerEntityManagerFactoryBean来获取EntityManagerFactory实例
     * @return
     */
    @Bean(name = "volgaEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean volgaEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(volgaDataSource)
                .properties(getVendorProperties(volgaDataSource))
                .packages("com.lucius.business.model.volga")
                .persistenceUnit("volgaPersistenceUnit")
                .build();
    }

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Bean(name = "volgaEntityManagerFactory")
    public EntityManagerFactory volgaEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return this.volgaEntityManagerFactoryBean(builder).getObject();
    }

    /**
     * 配置事物管理器
     * @return
     */
    @Bean(name = "volgaTransactionManager")
    public PlatformTransactionManager writeTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(volgaEntityManagerFactory(builder));
    }
}
