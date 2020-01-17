package sinosoft.com.redis.a.sub;


import org.springframework.stereotype.Service;

@Service
public class MessageReciver {

	public void onMessage(String message) {
		System.err.println(message + ":" + System.currentTimeMillis());
	}
}
