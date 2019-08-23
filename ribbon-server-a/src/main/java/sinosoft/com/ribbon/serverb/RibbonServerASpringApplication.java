package sinosoft.com.ribbon.serverb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class RibbonServerASpringApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(RibbonServerASpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Logger logger = LoggerFactory.getLogger(RibbonServerASpringApplication.class);
        
        for (int i = 0; i < 10; i++) {
        	logger.info(i+":测试log");
        }
        for (int i = 0; i < 100; i++) {
            logger.error("something wrong. id={}; name=Ryan-{};", i, i);
        }
		
	}
}
