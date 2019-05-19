package sinosoft.com.ribbon.clienta.mapper1;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import sinosoft.com.ribbon.clienta.dto.vue1.TestDb1;
import sinosoft.com.ribbon.clienta.dto.vue1.TestDb1Example;

public interface TestDb1Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    int countByExample(TestDb1Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    int deleteByExample(TestDb1Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    int deleteByPrimaryKey(String riskcode);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    int insert(TestDb1 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    int insertSelective(TestDb1 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    List<TestDb1> selectByExample(TestDb1Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    TestDb1 selectByPrimaryKey(String riskcode);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    int updateByExampleSelective(@Param("record") TestDb1 record, @Param("example") TestDb1Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    int updateByExample(@Param("record") TestDb1 record, @Param("example") TestDb1Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    int updateByPrimaryKeySelective(TestDb1 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    int updateByPrimaryKey(TestDb1 record);
}