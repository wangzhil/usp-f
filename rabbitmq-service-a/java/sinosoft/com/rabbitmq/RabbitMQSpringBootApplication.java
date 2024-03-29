package sinosoft.com.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
public class RabbitMQSpringBootApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RabbitMQSpringBootApplication.class, args);
	}
}
