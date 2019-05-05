package sinosoft.com.ribbon.clienta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class RibbonCilentASpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonCilentASpringApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@Bean
	public IRule MyRule(){
		return new RoundRobinRule ();
	}
}
