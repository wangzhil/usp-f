package sinosoft.com.ribbon.clienta.dao1;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import sinosoft.com.ribbon.clienta.dto.vue1.TestDb1;

public interface Db1Spring {

	@Select("select * from testdb1 where riskcode = #{0}")
    TestDb1 getDB1(@RequestParam("riskCode") String riskCode);
	
	@Insert("insert into testdb1 (riskcode,riskname) values (#{0},#{1})")
	void insertDB1(@RequestParam("riskCode") String riskCode,@RequestParam("riskName") String riskName);
	
	@Delete("delete from testdb1 where riskcode = #{0}")
	void deleteDB1(@RequestParam("riskCode") String riskCode);
	
	@Update("update testdb1 set riskname = #{1} where riskcode = #{0}")
	TestDb1 updateDB1(@RequestParam("riskCode") String riskCode,@RequestParam("riskName") String riskName);
	
}
