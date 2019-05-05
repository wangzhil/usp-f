package sinosoft.com.ribbon.serverb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

@EnableDiscoveryClient
@SpringBootApplication
@RibbonClients
public class RibbonServerBSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonServerBSpringApplication.class, args);
	}
}
