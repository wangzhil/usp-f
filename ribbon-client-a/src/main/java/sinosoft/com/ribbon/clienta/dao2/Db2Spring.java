package sinosoft.com.ribbon.clienta.dao2;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import sinosoft.com.ribbon.clienta.dto.vue2.TestDb2;

public interface Db2Spring {

	@Select("select * from testdb2 where riskcode = #{0}")
    TestDb2 getDB2(@RequestParam("riskCode") String riskCode);
	
	@Insert("insert into testdb2 (riskcode,riskname) values (#{0},#{1})")
	void insertDB2(@RequestParam("riskCode") String riskCode,@RequestParam("riskName") String riskName);
	
	@Delete("delete from testdb2 where riskcode = #{0}")
	void deleteDB2(@RequestParam("riskCode") String riskCode);
	
	@Update("update testdb2 set riskname = #{1} where riskcode = #{0}")
	TestDb2 updateDB2(@RequestParam("riskCode") String riskCode,@RequestParam("riskName") String riskName);
}
