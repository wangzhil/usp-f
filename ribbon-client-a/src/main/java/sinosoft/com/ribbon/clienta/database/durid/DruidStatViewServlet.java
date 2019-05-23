package sinosoft.com.ribbon.clienta.database.durid;

import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties.StatViewServlet;

/**
 * druid数据源状态监控.
 * @author syrain
 */
@WebServlet(urlPatterns="/druid/*",
        initParams={
                @WebInitParam(name="allow",value=""),// IP白名单(没有配置或者为空，则允许所有访问)
                @WebInitParam(name="deny",value=""),// IP黑名单 (存在共同时，deny优先于allow)
                @WebInitParam(name="loginUsername",value="admin"),// 用户名
                @WebInitParam(name="loginPassword",value="admin"),// 密码
                @WebInitParam(name="resetEnable",value="true")// 禁用HTML页面上的“Reset All”功能
        }
)
public class DruidStatViewServlet  extends StatViewServlet {
    private static final long serialVersionUID = 1L;
}
