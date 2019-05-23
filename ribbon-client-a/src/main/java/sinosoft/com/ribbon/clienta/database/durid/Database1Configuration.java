/**
 * @Copyright ®2015 guobao Co. Ltd. All rights reserved.
 * 项目名称 : 国宝人寿业务前置平台系统
 * 创建日期 : 2017-04-15
 * 修改历史 :
 * 1. [2017-04-15]创建文件 by bianzb
 */
package sinosoft.com.ribbon.clienta.database.durid;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;
import javax.annotation.Resource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;

/**
 * 【类或接口功能描述】
 * <p>Description:类或接口功能详细描述 </p>
 * @version 1.0
 * @date 2018-04-15 22:54
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"sinosoft.com.ribbon.clienta.dao1"}, sqlSessionTemplateRef  = "db1SqlSessionTemplate")
public class Database1Configuration {


    //注册dataSource
    @Bean(initMethod = "init", destroyMethod = "close",name = "db1DataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.db1.")
    public DruidDataSource dataSource() throws SQLException {
       
        return new DruidDataSource();
    }

    @Bean(name = "db1SqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory( @Qualifier("db1DataSource") DruidDataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        //mybatis分页
        PageHelper pageHelper = new PageHelper();
        Properties props = new Properties();
        props.setProperty("dialect", "mysql");
        props.setProperty("reasonable", "true");
        props.setProperty("supportMethodsArguments", "true");
        props.setProperty("returnPageInfo", "check");
        props.setProperty("params", "count=countSql");
        pageHelper.setProperties(props); //添加插件
        sqlSessionFactoryBean.setPlugins(new Interceptor[] { pageHelper });
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:mybatis/*/*Mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "db1TransactionManager")
    @Primary
    public PlatformTransactionManager transactionManager(@Qualifier("db1DataSource") DruidDataSource dataSource) throws SQLException {
        return new DataSourceTransactionManager(dataSource);
    }
    
    @Bean(name = "db1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate (@Qualifier("db1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
    	return new SqlSessionTemplate(sqlSessionFactory);
    }
    
}
