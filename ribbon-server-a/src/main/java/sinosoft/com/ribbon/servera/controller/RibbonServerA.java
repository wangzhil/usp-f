package sinosoft.com.ribbon.servera.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonServerA {

	@RequestMapping(value = "/RibbonServerA",method = RequestMethod.POST)
	public String RibbonServerA(String param){
		System.err.println("RibbonServerA.....in....");
		return "param : "+param+";Ribbon A Service ..";
	}
}
