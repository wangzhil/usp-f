package sinosoft.com.ribbon.clienta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sinosoft.com.ribbon.clienta.rpc.RibbonServerAI;

@RestController
public class RibbonServerAController {

	@Autowired
	private RibbonServerAI ribbonServerAI;
	
	@RequestMapping("/RibbonT")
	public String testRibbon(String param){
		System.err.println("Server A start...."+param);
		return ribbonServerAI.testRibbonA(param);
		
	}
}
