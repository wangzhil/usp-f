package sinosoft.com.ribbon.clienta.mapper2;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sinosoft.com.ribbon.clienta.dto.vue2.TestDb2;
import sinosoft.com.ribbon.clienta.dto.vue2.TestDb2Example;

public interface TestDb2Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb2
     *
     * @mbggenerated Sun May 19 21:56:36 CST 2019
     */
    int countByExample(TestDb2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb2
     *
     * @mbggenerated Sun May 19 21:56:36 CST 2019
     */
    int deleteByExample(TestDb2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb2
     *
     * @mbggenerated Sun May 19 21:56:36 CST 2019
     */
    int deleteByPrimaryKey(String riskcode);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb2
     *
     * @mbggenerated Sun May 19 21:56:36 CST 2019
     */
    int insert(TestDb2 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb2
     *
     * @mbggenerated Sun May 19 21:56:36 CST 2019
     */
    int insertSelective(TestDb2 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb2
     *
     * @mbggenerated Sun May 19 21:56:36 CST 2019
     */
    List<TestDb2> selectByExample(TestDb2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb2
     *
     * @mbggenerated Sun May 19 21:56:36 CST 2019
     */
    TestDb2 selectByPrimaryKey(String riskcode);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb2
     *
     * @mbggenerated Sun May 19 21:56:36 CST 2019
     */
    int updateByExampleSelective(@Param("record") TestDb2 record, @Param("example") TestDb2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb2
     *
     * @mbggenerated Sun May 19 21:56:36 CST 2019
     */
    int updateByExample(@Param("record") TestDb2 record, @Param("example") TestDb2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb2
     *
     * @mbggenerated Sun May 19 21:56:36 CST 2019
     */
    int updateByPrimaryKeySelective(TestDb2 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb2
     *
     * @mbggenerated Sun May 19 21:56:36 CST 2019
     */
    int updateByPrimaryKey(TestDb2 record);
}