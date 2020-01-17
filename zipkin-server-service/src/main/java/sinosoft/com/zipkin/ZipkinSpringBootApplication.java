package sinosoft.com.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin2.server.internal.EnableZipkinServer;


@EnableDiscoveryClient
@SpringBootApplication
@EnableZipkinServer
public class ZipkinSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinSpringBootApplication.class, args);
	}
}
