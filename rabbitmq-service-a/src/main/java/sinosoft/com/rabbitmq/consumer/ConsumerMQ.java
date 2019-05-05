package sinosoft.com.rabbitmq.consumer;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class ConsumerMQ {

	@RabbitHandler
	public void conSumerMq(String hello){
		try {
			TimeUnit.MINUTES.sleep(1);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.err.println("消费消息队列hello:"+hello);
	}
}
