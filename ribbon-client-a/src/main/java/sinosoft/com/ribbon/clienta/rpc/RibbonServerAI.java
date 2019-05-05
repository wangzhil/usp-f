package sinosoft.com.ribbon.clienta.rpc;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "ribbon-server-c",fallback = RibbonServerAIHysrix.class)
public interface RibbonServerAI {

	@RequestMapping(value = "/RibbonServerA",method = RequestMethod.POST)
	public String testRibbonA(@RequestParam("param") String param);
}
