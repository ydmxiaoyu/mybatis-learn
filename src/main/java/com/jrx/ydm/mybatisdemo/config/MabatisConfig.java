package com.jrx.ydm.mybatisdemo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Mybatis 配置类
 * @author yudaoming
 */
@Configuration
public class MabatisConfig {

    /**
     * 应用上下文对象
     */
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 日志打印
     */
    public static final Logger logger = LoggerFactory.getLogger(MabatisConfig.class);

    /**
     * 配置 sqlSessionFactory 对象
     * @return SqlSessionFactoryBean 或者是 null
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(){
        try {
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            DataSource dataSource = applicationContext.getBean(DataSource.class);
            sqlSessionFactoryBean.setDataSource(dataSource);
            return sqlSessionFactoryBean.getObject();
        }catch (Exception e){
            logger.error("创建bean的sqlSessionFactory（）方法发生异常，异常信息：");
            logger.error(e.getMessage());
        }
        return null;
    }


    /**
     * 配置 SqlSessionTemplate 对象
     * @return SqlSessionTemplate
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(){
        return new SqlSessionTemplate(sqlSessionFactory());
    }

}
