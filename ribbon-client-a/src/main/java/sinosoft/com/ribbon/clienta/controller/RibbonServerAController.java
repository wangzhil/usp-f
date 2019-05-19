package sinosoft.com.ribbon.clienta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sinosoft.com.ribbon.clienta.dao1.Db1Spring;
import sinosoft.com.ribbon.clienta.dao2.Db2Spring;
import sinosoft.com.ribbon.clienta.dto.vue1.TestDb1;
import sinosoft.com.ribbon.clienta.dto.vue2.TestDb2;
import sinosoft.com.ribbon.clienta.rpc.RibbonServerAI;

@RestController
public class RibbonServerAController {

	@Autowired
	private Db1Spring Db1Spring;
	@Autowired
	private Db2Spring Db2Spring;
	
	@Autowired
	private RibbonServerAI ribbonServerAI;
	
	@RequestMapping(value = "/RibbonT",method = RequestMethod.POST)
	public String testRibbon(String param){
		System.err.println("Server A start...."+param);
		return ribbonServerAI.testRibbonA(param);
		
	}
	
	@RequestMapping(value = "/selectDb1",method = RequestMethod.POST)
	public TestDb1 testdb1(@RequestParam("riskCode")String riskCode){
		TestDb1 db1 = Db1Spring.getDB1(riskCode);
		return db1;
	}
	
	@RequestMapping(value = "/db1Insert",method = RequestMethod.POST)
	public void insertDb1(@RequestParam("riskCode")String riskCode,@RequestParam("riskName")String riskName){
		
		Db1Spring.insertDB1(riskCode,riskName);
	}
	
	@RequestMapping(value = "/selectDb2",method = RequestMethod.POST)
	public TestDb2 testdb2(@RequestParam("riskCode")String riskCode){
		TestDb2 db2 = Db2Spring.getDB2(riskCode);
		return db2;
	}
	
	@RequestMapping(value = "/db2Insert",method = RequestMethod.POST)
	public void insertDb2(@RequestParam("riskCode")String riskCode,@RequestParam("riskName")String riskName){
		
		Db2Spring.insertDB2(riskCode,riskName);
	}
}
