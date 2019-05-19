package sinosoft.com.ribbon.clienta.dto.vue1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestDb1Example {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    public TestDb1Example() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andRiskcodeIsNull() {
            addCriterion("RiskCode is null");
            return (Criteria) this;
        }

        public Criteria andRiskcodeIsNotNull() {
            addCriterion("RiskCode is not null");
            return (Criteria) this;
        }

        public Criteria andRiskcodeEqualTo(String value) {
            addCriterion("RiskCode =", value, "riskcode");
            return (Criteria) this;
        }

        public Criteria andRiskcodeNotEqualTo(String value) {
            addCriterion("RiskCode <>", value, "riskcode");
            return (Criteria) this;
        }

        public Criteria andRiskcodeGreaterThan(String value) {
            addCriterion("RiskCode >", value, "riskcode");
            return (Criteria) this;
        }

        public Criteria andRiskcodeGreaterThanOrEqualTo(String value) {
            addCriterion("RiskCode >=", value, "riskcode");
            return (Criteria) this;
        }

        public Criteria andRiskcodeLessThan(String value) {
            addCriterion("RiskCode <", value, "riskcode");
            return (Criteria) this;
        }

        public Criteria andRiskcodeLessThanOrEqualTo(String value) {
            addCriterion("RiskCode <=", value, "riskcode");
            return (Criteria) this;
        }

        public Criteria andRiskcodeLike(String value) {
            addCriterion("RiskCode like", value, "riskcode");
            return (Criteria) this;
        }

        public Criteria andRiskcodeNotLike(String value) {
            addCriterion("RiskCode not like", value, "riskcode");
            return (Criteria) this;
        }

        public Criteria andRiskcodeIn(List<String> values) {
            addCriterion("RiskCode in", values, "riskcode");
            return (Criteria) this;
        }

        public Criteria andRiskcodeNotIn(List<String> values) {
            addCriterion("RiskCode not in", values, "riskcode");
            return (Criteria) this;
        }

        public Criteria andRiskcodeBetween(String value1, String value2) {
            addCriterion("RiskCode between", value1, value2, "riskcode");
            return (Criteria) this;
        }

        public Criteria andRiskcodeNotBetween(String value1, String value2) {
            addCriterion("RiskCode not between", value1, value2, "riskcode");
            return (Criteria) this;
        }

        public Criteria andRisknameIsNull() {
            addCriterion("RiskName is null");
            return (Criteria) this;
        }

        public Criteria andRisknameIsNotNull() {
            addCriterion("RiskName is not null");
            return (Criteria) this;
        }

        public Criteria andRisknameEqualTo(String value) {
            addCriterion("RiskName =", value, "riskname");
            return (Criteria) this;
        }

        public Criteria andRisknameNotEqualTo(String value) {
            addCriterion("RiskName <>", value, "riskname");
            return (Criteria) this;
        }

        public Criteria andRisknameGreaterThan(String value) {
            addCriterion("RiskName >", value, "riskname");
            return (Criteria) this;
        }

        public Criteria andRisknameGreaterThanOrEqualTo(String value) {
            addCriterion("RiskName >=", value, "riskname");
            return (Criteria) this;
        }

        public Criteria andRisknameLessThan(String value) {
            addCriterion("RiskName <", value, "riskname");
            return (Criteria) this;
        }

        public Criteria andRisknameLessThanOrEqualTo(String value) {
            addCriterion("RiskName <=", value, "riskname");
            return (Criteria) this;
        }

        public Criteria andRisknameLike(String value) {
            addCriterion("RiskName like", value, "riskname");
            return (Criteria) this;
        }

        public Criteria andRisknameNotLike(String value) {
            addCriterion("RiskName not like", value, "riskname");
            return (Criteria) this;
        }

        public Criteria andRisknameIn(List<String> values) {
            addCriterion("RiskName in", values, "riskname");
            return (Criteria) this;
        }

        public Criteria andRisknameNotIn(List<String> values) {
            addCriterion("RiskName not in", values, "riskname");
            return (Criteria) this;
        }

        public Criteria andRisknameBetween(String value1, String value2) {
            addCriterion("RiskName between", value1, value2, "riskname");
            return (Criteria) this;
        }

        public Criteria andRisknameNotBetween(String value1, String value2) {
            addCriterion("RiskName not between", value1, value2, "riskname");
            return (Criteria) this;
        }

        public Criteria andDbcodeIsNull() {
            addCriterion("DbCode is null");
            return (Criteria) this;
        }

        public Criteria andDbcodeIsNotNull() {
            addCriterion("DbCode is not null");
            return (Criteria) this;
        }

        public Criteria andDbcodeEqualTo(Integer value) {
            addCriterion("DbCode =", value, "dbcode");
            return (Criteria) this;
        }

        public Criteria andDbcodeNotEqualTo(Integer value) {
            addCriterion("DbCode <>", value, "dbcode");
            return (Criteria) this;
        }

        public Criteria andDbcodeGreaterThan(Integer value) {
            addCriterion("DbCode >", value, "dbcode");
            return (Criteria) this;
        }

        public Criteria andDbcodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("DbCode >=", value, "dbcode");
            return (Criteria) this;
        }

        public Criteria andDbcodeLessThan(Integer value) {
            addCriterion("DbCode <", value, "dbcode");
            return (Criteria) this;
        }

        public Criteria andDbcodeLessThanOrEqualTo(Integer value) {
            addCriterion("DbCode <=", value, "dbcode");
            return (Criteria) this;
        }

        public Criteria andDbcodeIn(List<Integer> values) {
            addCriterion("DbCode in", values, "dbcode");
            return (Criteria) this;
        }

        public Criteria andDbcodeNotIn(List<Integer> values) {
            addCriterion("DbCode not in", values, "dbcode");
            return (Criteria) this;
        }

        public Criteria andDbcodeBetween(Integer value1, Integer value2) {
            addCriterion("DbCode between", value1, value2, "dbcode");
            return (Criteria) this;
        }

        public Criteria andDbcodeNotBetween(Integer value1, Integer value2) {
            addCriterion("DbCode not between", value1, value2, "dbcode");
            return (Criteria) this;
        }

        public Criteria andMaketimeIsNull() {
            addCriterion("MakeTime is null");
            return (Criteria) this;
        }

        public Criteria andMaketimeIsNotNull() {
            addCriterion("MakeTime is not null");
            return (Criteria) this;
        }

        public Criteria andMaketimeEqualTo(Date value) {
            addCriterion("MakeTime =", value, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeNotEqualTo(Date value) {
            addCriterion("MakeTime <>", value, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeGreaterThan(Date value) {
            addCriterion("MakeTime >", value, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MakeTime >=", value, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeLessThan(Date value) {
            addCriterion("MakeTime <", value, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeLessThanOrEqualTo(Date value) {
            addCriterion("MakeTime <=", value, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeIn(List<Date> values) {
            addCriterion("MakeTime in", values, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeNotIn(List<Date> values) {
            addCriterion("MakeTime not in", values, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeBetween(Date value1, Date value2) {
            addCriterion("MakeTime between", value1, value2, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeNotBetween(Date value1, Date value2) {
            addCriterion("MakeTime not between", value1, value2, "maketime");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNull() {
            addCriterion("ModifyTime is null");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNotNull() {
            addCriterion("ModifyTime is not null");
            return (Criteria) this;
        }

        public Criteria andModifytimeEqualTo(Date value) {
            addCriterion("ModifyTime =", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotEqualTo(Date value) {
            addCriterion("ModifyTime <>", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThan(Date value) {
            addCriterion("ModifyTime >", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ModifyTime >=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThan(Date value) {
            addCriterion("ModifyTime <", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThanOrEqualTo(Date value) {
            addCriterion("ModifyTime <=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeIn(List<Date> values) {
            addCriterion("ModifyTime in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotIn(List<Date> values) {
            addCriterion("ModifyTime not in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeBetween(Date value1, Date value2) {
            addCriterion("ModifyTime between", value1, value2, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotBetween(Date value1, Date value2) {
            addCriterion("ModifyTime not between", value1, value2, "modifytime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table testdb1
     *
     * @mbggenerated do_not_delete_during_merge Sun May 19 21:54:40 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table testdb1
     *
     * @mbggenerated Sun May 19 21:54:40 CST 2019
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}