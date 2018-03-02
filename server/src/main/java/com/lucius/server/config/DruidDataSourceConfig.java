package com.lucius.server.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * <br>
 *
 * @author Lucius
 * create by 2018/2/28
 * @Emial Lucius.li@ixiaoshuidi.com
 */
@Configuration
public class DruidDataSourceConfig {

    private static final Logger logger = LoggerFactory.getLogger(DruidDataSourceConfig.class);

    @Bean(name="hardwareDataSource")
    @Primary
    @Qualifier("hardwareDataSource")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource hardwareDataSource() {
        logger.info("-------------------- hardware init ---------------------");
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name="volgaDataSource")
    @Qualifier("volgaDataSource")
    @ConfigurationProperties(prefix="spring.datasource.volga-druid-datasource")
    public DataSource volgaDataSource() {
        logger.info("-------------------- volgaDataSource init ---------------------");
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name="caspainDataSource")
    @Qualifier("caspainDataSource")
    @ConfigurationProperties(prefix="spring.datasource.caspain-druid-datasource")
    public DataSource caspainDataSource() {
        logger.info("-------------------- caspainDataSource init ---------------------");
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public ServletRegistrationBean druidServlet() {
        logger.info("init Druid Servlet Configuration ");
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");
        Map<String, String> initParameters = new HashMap<String, String>();
        // 用户名
        initParameters.put("loginUsername", "admin");
        // 密码
        initParameters.put("loginPassword", "admin");
        // 禁用HTML页面上的“Reset All”功能
        initParameters.put("resetEnable", "false");
        // IP白名单 (没有配置或者为空，则允许所有访问)
        initParameters.put("allow", "");
        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

}
