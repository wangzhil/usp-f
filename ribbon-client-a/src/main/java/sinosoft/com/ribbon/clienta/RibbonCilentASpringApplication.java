package sinosoft.com.ribbon.clienta;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class RibbonCilentASpringApplication/* implements CommandLineRunner */{

	public static void main(String[] args) {
		SpringApplication.run(RibbonCilentASpringApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	/*@Override
	public void run(String... args) throws Exception {
		Logger logger = LoggerFactory.getLogger(RibbonCilentASpringApplication.class);
        logger.info("测试log");

        for (int i = 0; i < 10; i++) {
            logger.error("something wrong. id={}; name=Ryan-{};", i, i);
        }
		
	}*/
	
//	@Bean
//	public IRule MyRule(){
//		return new RoundRobinRule ();
//	}
}
