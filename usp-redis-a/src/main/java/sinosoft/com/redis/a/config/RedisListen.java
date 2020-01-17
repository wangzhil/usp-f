package sinosoft.com.redis.a.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import sinosoft.com.redis.a.sub.MessageReciver;

@Configuration
public class RedisListen {

	@Bean(name = "listenerContainer")
    RedisMessageListenerContainer listenerContainer(RedisConnectionFactory connectionFactory,
                                                    @Qualifier("channel1ListenerAdapter") MessageListenerAdapter listenerAdapter,
                                                    @Qualifier("channel2ListenerAdapter") MessageListenerAdapter listenerAdapter2) {
 
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        //监听容器可添加多个适配器，监听多个频道
        container.addMessageListener(listenerAdapter, new PatternTopic("channel1"));
        container.addMessageListener(listenerAdapter2, new PatternTopic("channel2"));
        return container;
    }
 
    /**
     * 消息监听适配器，绑定消息接收器
     * @param receiver 消息接收器
     * @return
     */
    @Bean(name = "channel1ListenerAdapter")
    MessageListenerAdapter channel1ListenerAdapter(MessageReciver receiver) {
        //利用反射技术，调用消息处理方法
        return new MessageListenerAdapter(receiver, "onMessage");
    }
    @Bean(name = "channel2ListenerAdapter")
    MessageListenerAdapter channel2ListenerAdapter(MessageReciver receiver) {
        //利用反射技术，调用消息处理方法
        return new MessageListenerAdapter(receiver, "onMessage");
    }


}
