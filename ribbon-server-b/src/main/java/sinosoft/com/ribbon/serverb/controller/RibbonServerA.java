package sinosoft.com.ribbon.serverb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonServerA {

	@RequestMapping(value = "/RibbonServerA",method = RequestMethod.POST)
	public String RibbonServerA(String param){
		System.err.println("RibbonServerB.....in....");
		return "param : "+param+";Ribbon B Service ..";
	}
}
