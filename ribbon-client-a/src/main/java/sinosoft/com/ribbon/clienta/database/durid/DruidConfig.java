/**
 * @Copyright ®2015 guobao Co. Ltd. All rights reserved.
 * 项目名称 : 国宝人寿业务前置平台系统
 * 创建日期 : 2017-04-15
 * 修改历史 :
 * 1. [2017-04-15]创建文件 by bianzb
 */
package sinosoft.com.ribbon.clienta.database.durid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 【类或接口功能描述】
 * <p>Description:类或接口功能详细描述 </p>
 *
 * @version 1.0
 * @date 2018-04-15 23:00
 */
@Configuration
public class DruidConfig {
	//1、配置一个管理后台的Servlet
	@Bean
    public ServletRegistrationBean druidServlet() {// 主要实现web监控的配置处理
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(
                new StatViewServlet(), "/druid/*");//表示进行druid监控的配置处理操作
        //servletRegistrationBean.addInitParameter("allow", "127.0.0.1,192.168.202.233");//白名单
        //servletRegistrationBean.addInitParameter("deny", "192.168.202.234");//黑名单
        servletRegistrationBean.addInitParameter("loginUsername", "root");//用户名
        servletRegistrationBean.addInitParameter("loginPassword", "root");//密码
        servletRegistrationBean.addInitParameter("resetEnable", "false");//是否可以重置数据源
        return servletRegistrationBean;
 
    }
 
    @Bean    //监控
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");//所有请求进行监控处理
        filterRegistrationBean.addInitParameter("exclusions", "/static/*,*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");//排除
        return filterRegistrationBean;
    }

o

}
