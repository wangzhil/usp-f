package org.usp.redis.a.day01;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import sinosoft.com.redis.a.RedisAApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisAApplication.class)
public class RedisSubcribeTest {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;


	
	@Test
	public void test() {
		/*redisTemplate.opsForSet().add("2222", "222222");
		redisTemplate.opsForSet().add("2222", "333333");
		redisTemplate.opsForSet().add("2222", "444444");
		redisTemplate.opsForSet().add("2222", "222222");*/
		/*System.err.println(redisTemplate.opsForSet().members("2222"));
		redisTemplate.opsForList().leftPush("left", "1");
		redisTemplate.opsForList().leftPush("left", "2");
		redisTemplate.opsForList().leftPush("left", "3");
		redisTemplate.opsForList().leftPush("left", "4");
		redisTemplate.opsForList().leftPush("left", "3");
		redisTemplate.opsForList().range("left", 0, -1).forEach((name) -> System.out.println(name));*/
		// List类型的添加和获取
		/*ArrayList<String> arr = new ArrayList<String>();
		arr.add("1");
		arr.add("2");
		arr.add("3");
		arr.add("4");
		arr.add("5");
		arr.add("6");
		arr.forEach((value) -> redisTemplate.opsForList().rightPush("right", value));
		redisTemplate.opsForList().range("right", 0, -1).forEach((value) -> System.out.println(value));*/
		// String
		/*redisTemplate.opsForValue().set("String", "test");
		redisTemplate.opsForValue().set("String", "test1");
		redisTemplate.opsForValue().get("String");
		// 跟字符串拼接
		redisTemplate.opsForValue().append("String", "233");*/
		
		// bounds
		/*ArrayList<String> arr = new ArrayList<String>();
		arr.add("1");
		arr.add("2");
		arr.add("3");
		arr.add("4");
		redisTemplate.boundValueOps("name").set("boundString1");
		redisTemplate.boundSetOps("bSet").add("333333", "22222");
		redisTemplate.boundListOps("bList").rightPush("1");
		redisTemplate.boundListOps("bList").rightPush("2");*/
//		redisTemplate.keys("*").forEach((name) -> System.out.println(name));
		
		redisTemplate.convertAndSend("channel1", "消息一11111111111");
		redisTemplate.convertAndSend("channel2", "消息一2222222222");
		
	}
}
