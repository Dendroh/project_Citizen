package com.app.citizen.config;

import com.app.citizen.Base;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackageClasses = Base.class,
        excludeFilters = @ComponentScan.Filter(Controller.class))
public class RootConfig {
  @Bean
  public DataSource dataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://133.186.144.236:3306/nhn_academy_53");
    dataSource.setUsername("nhn_academy_53");
    dataSource.setPassword("mwp575m]KcVFT6tS");

    dataSource.setInitialSize(10);
    dataSource.setMaxTotal(10);
    dataSource.setMinIdle(10);
    dataSource.setMaxIdle(10);

    dataSource.setMaxWaitMillis(1000);

    dataSource.setTestOnBorrow(true);
    dataSource.setTestOnReturn(true);

    return dataSource;
  }

  @Bean
  public MessageSource messageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setDefaultEncoding("UTF-8");
    messageSource.setBasename("messages");

    return messageSource;
  }
}
