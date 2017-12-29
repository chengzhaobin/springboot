package com.ande.conf;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.github.pagehelper.PageHelper;

@Configuration
public class PageHelperConfiguration{
    //DataSource配置
    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() {
        return new com.alibaba.druid.pool.DruidDataSource();
    }
 
    //提供SqlSeesion
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
 
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/com/ande/dao/*.xml"));
        
      //分页插件  
        PageHelper pageHelper = new PageHelper();  
        Properties props = new Properties();  
        props.setProperty("reasonable", "true");  
        props.setProperty("supportMethodsArguments", "true");  
        props.setProperty("returnPageInfo", "check");  
        props.setProperty("params", "count=countSql");  
        //通过设置pageSize=0或者RowBounds.limit = 0就会查询出全部的结果。
        props.setProperty("pageSizeZero", "true");
        pageHelper.setProperties(props);  
        //添加插件  
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});  
 
        return sqlSessionFactoryBean.getObject();
    }
 
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}

