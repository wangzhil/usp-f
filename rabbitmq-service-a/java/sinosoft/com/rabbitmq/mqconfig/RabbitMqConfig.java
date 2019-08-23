package sinosoft.com.rabbitmq.mqconfig;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfig {

	@Bean
	public Queue queueConfig(){
		return new Queue("hello");
	}
}
