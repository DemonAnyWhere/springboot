package com.lirui.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.lirui.constan.DataSourceType;
import com.lirui.multids.DynamicDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.remote")
    public DataSource remoteDataSource() {
        //return DataSourceBuilder.create().build();
        // 数据源选择druidDataSource
        //return new DruidDataSource();
        return DataSourceBuilder.create().type(DruidDataSource.class).build();

    }

    @Bean
    @ConfigurationProperties("spring.datasource.local")
    //@ConditionalOnProperty(prefix = "spring.datasource.local", name = "enabled", havingValue = "true")
    public DataSource localDataSource() {
        //return DataSourceBuilder.create().build();
        //return new DruidDataSource();
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }
    
    @Bean(name = "dynamicDataSource")
    @Primary
    public DynamicDataSource dataSource(DataSource remoteDataSource, DataSource localDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceType.REMOTE.name(), remoteDataSource);
        targetDataSources.put(DataSourceType.LOCAL.name(), localDataSource);
        return new DynamicDataSource(remoteDataSource, targetDataSources);
    }

}