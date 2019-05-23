package sinosoft.com.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ZuulASpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulASpringApplication.class, args);
	}

}
