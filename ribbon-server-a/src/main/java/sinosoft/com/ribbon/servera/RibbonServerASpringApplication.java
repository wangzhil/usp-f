package sinosoft.com.ribbon.servera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class RibbonServerASpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonServerASpringApplication.class, args);
	}
}
