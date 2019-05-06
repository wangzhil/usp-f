package sinosoft.com.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import de.codecentric.boot.admin.config.EnableAdminServer;

@EnableDiscoveryClient
@SpringBootApplication
@EnableAdminServer
public class AdminSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminSpringApplication.class, args);
	}	
	
}
