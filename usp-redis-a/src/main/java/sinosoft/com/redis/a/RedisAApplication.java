package sinosoft.com.redis.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RedisAApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisAApplication.class, args);
	}
}
