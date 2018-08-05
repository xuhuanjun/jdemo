package com.jd.jdemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 默认数据源（主数据源）
 */
@Configuration
@MapperScan(basePackages = PrimaryDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "primarySqlSessionFactory")
public class PrimaryDataSourceConfig {
    static final String PACKAGE = "com.jd.jdemo.dao.mapper.primary";
    @Value("${mybatis.config-locations}")
    private String mybatisConfigLocations;
    @Value("${mybatis.mapper-locations}")
    private String mybatisMapperLocations;
    @Value("${mybatis.type-aliases-package}")
    private String typeAliasesPackage;

    @Bean(name = "primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource() {
        //指定使用DruidDataSource
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean(name = "primaryTransactionManager")
    @Primary
    public DataSourceTransactionManager primaryTransactionManager() {
        return new DataSourceTransactionManager(primaryDataSource());
    }

    @Bean(name = "primarySqlSessionFactory")
    @Primary
    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("primaryDataSource") DataSource primaryDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(primaryDataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setConfigLocation(resolver.getResource(mybatisConfigLocations));
        sessionFactory.setMapperLocations(resolver.getResources(mybatisMapperLocations));
        sessionFactory.setTypeAliasesPackage(typeAliasesPackage);
        return sessionFactory.getObject();
    }
}
