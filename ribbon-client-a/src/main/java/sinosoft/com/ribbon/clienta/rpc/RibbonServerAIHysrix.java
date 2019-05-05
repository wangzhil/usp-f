package sinosoft.com.ribbon.clienta.rpc;

import org.springframework.stereotype.Component;

@Component
public class RibbonServerAIHysrix implements RibbonServerAI{

	@Override
	public String testRibbonA(String param) {
		System.out.println("1111111");
		return null;
	}

}
