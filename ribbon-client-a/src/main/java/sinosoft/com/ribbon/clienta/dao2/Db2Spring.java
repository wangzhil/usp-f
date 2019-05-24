package sinosoft.com.ribbon.clienta.dao2;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import sinosoft.com.ribbon.clienta.dto.vue2.TestDb2;

public interface Db2Spring {

	@Select("select * from testdb2 where riskcode = #{riskCode}")
    TestDb2 getDB2(@Param("riskCode") String riskCode);
	
	@Insert("insert into testdb2 (riskcode,riskname) values (#{riskCode},#{riskName})")
	void insertDB2(@Param("riskCode") String riskCode,@Param("riskName") String riskName);
	
	@Delete("delete from testdb2 where riskcode = #{riskCode}")
	void deleteDB2(@Param("riskCode") String riskCode);
	
	@Update("update testdb2 set riskname = #{riskName} where riskcode = #{riskCode}")
	TestDb2 updateDB2(@Param("riskCode") String riskCode,@Param("riskName") String riskName);
}
