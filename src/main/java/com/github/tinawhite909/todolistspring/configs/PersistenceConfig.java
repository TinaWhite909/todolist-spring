package com.github.tinawhite909.todolistspring.configs;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionManager;
import org.h2.jdbcx.JdbcDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.MyBatisJdbcConfiguration;

import javax.sql.DataSource;

@Configuration
@Import(MyBatisJdbcConfiguration.class)
@MapperScan("com.github.tinawhite909.todolistspring.mybatis")
public class PersistenceConfig {

    @Autowired
    private DBProperties dbProperties;

    @Bean
    public DataSource dataSource() {
        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL(dbProperties.getUrl());
        ds.setUser(dbProperties.getUser());
        ds.setPassword(dbProperties.getPassword());
        return ds;
    }
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        return factoryBean;
    }

    @Bean
    public SqlSession sqlSession() throws Exception {
        return SqlSessionManager.newInstance(sqlSessionFactory().getObject());
    }
}