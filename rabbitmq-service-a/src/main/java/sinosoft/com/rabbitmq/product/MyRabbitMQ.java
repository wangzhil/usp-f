package sinosoft.com.rabbitmq.product;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRabbitMQ {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@RequestMapping("/send")
	public void sendMessage(){
		String message = "hello"+new Date();
		System.err.println("hello  消息队列发送message:"+message+" 开始....");
		amqpTemplate.convertAndSend("hello",message);
		System.err.println("hello  消息队列发送结束....");
	}
	
}
