package sinosoft.com.ribbon.clienta.dao1;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import sinosoft.com.ribbon.clienta.dto.vue1.TestDb1;

public interface Db1Spring {

	@Select("select * from testdb1 where riskcode = #{riskCode}")
    TestDb1 getDB1(@Param("riskCode") String riskCode);
	
	@Insert("insert into testdb1 (riskcode,riskname) values (#{riskCode},#{riskName})")
	void insertDB1(@Param("riskCode") String riskCode,@Param("riskName") String riskName);
	
	@Delete("delete from testdb1 where riskcode = #{riskCode}")
	void deleteDB1(@Param("riskCode") String riskCode);
	
	@Update("update testdb1 set riskname = #{riskName} where riskcode = #{riskCode}")
	TestDb1 updateDB1(@Param("riskCode") String riskCode,@Param("riskName") String riskName);
	
}
