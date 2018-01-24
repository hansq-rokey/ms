package com.fengzhuo.tudou.ms.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrgTeamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrgTeamExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTeamNameIsNull() {
            addCriterion("team_name is null");
            return (Criteria) this;
        }

        public Criteria andTeamNameIsNotNull() {
            addCriterion("team_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeamNameEqualTo(String value) {
            addCriterion("team_name =", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotEqualTo(String value) {
            addCriterion("team_name <>", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameGreaterThan(String value) {
            addCriterion("team_name >", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameGreaterThanOrEqualTo(String value) {
            addCriterion("team_name >=", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLessThan(String value) {
            addCriterion("team_name <", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLessThanOrEqualTo(String value) {
            addCriterion("team_name <=", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLike(String value) {
            addCriterion("team_name like", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotLike(String value) {
            addCriterion("team_name not like", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameIn(List<String> values) {
            addCriterion("team_name in", values, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotIn(List<String> values) {
            addCriterion("team_name not in", values, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameBetween(String value1, String value2) {
            addCriterion("team_name between", value1, value2, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotBetween(String value1, String value2) {
            addCriterion("team_name not between", value1, value2, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNoIsNull() {
            addCriterion("team_no is null");
            return (Criteria) this;
        }

        public Criteria andTeamNoIsNotNull() {
            addCriterion("team_no is not null");
            return (Criteria) this;
        }

        public Criteria andTeamNoEqualTo(String value) {
            addCriterion("team_no =", value, "teamNo");
            return (Criteria) this;
        }

        public Criteria andTeamNoNotEqualTo(String value) {
            addCriterion("team_no <>", value, "teamNo");
            return (Criteria) this;
        }

        public Criteria andTeamNoGreaterThan(String value) {
            addCriterion("team_no >", value, "teamNo");
            return (Criteria) this;
        }

        public Criteria andTeamNoGreaterThanOrEqualTo(String value) {
            addCriterion("team_no >=", value, "teamNo");
            return (Criteria) this;
        }

        public Criteria andTeamNoLessThan(String value) {
            addCriterion("team_no <", value, "teamNo");
            return (Criteria) this;
        }

        public Criteria andTeamNoLessThanOrEqualTo(String value) {
            addCriterion("team_no <=", value, "teamNo");
            return (Criteria) this;
        }

        public Criteria andTeamNoLike(String value) {
            addCriterion("team_no like", value, "teamNo");
            return (Criteria) this;
        }

        public Criteria andTeamNoNotLike(String value) {
            addCriterion("team_no not like", value, "teamNo");
            return (Criteria) this;
        }

        public Criteria andTeamNoIn(List<String> values) {
            addCriterion("team_no in", values, "teamNo");
            return (Criteria) this;
        }

        public Criteria andTeamNoNotIn(List<String> values) {
            addCriterion("team_no not in", values, "teamNo");
            return (Criteria) this;
        }

        public Criteria andTeamNoBetween(String value1, String value2) {
            addCriterion("team_no between", value1, value2, "teamNo");
            return (Criteria) this;
        }

        public Criteria andTeamNoNotBetween(String value1, String value2) {
            addCriterion("team_no not between", value1, value2, "teamNo");
            return (Criteria) this;
        }

        public Criteria andTeamKeyIsNull() {
            addCriterion("team_key is null");
            return (Criteria) this;
        }

        public Criteria andTeamKeyIsNotNull() {
            addCriterion("team_key is not null");
            return (Criteria) this;
        }

        public Criteria andTeamKeyEqualTo(String value) {
            addCriterion("team_key =", value, "teamKey");
            return (Criteria) this;
        }

        public Criteria andTeamKeyNotEqualTo(String value) {
            addCriterion("team_key <>", value, "teamKey");
            return (Criteria) this;
        }

        public Criteria andTeamKeyGreaterThan(String value) {
            addCriterion("team_key >", value, "teamKey");
            return (Criteria) this;
        }

        public Criteria andTeamKeyGreaterThanOrEqualTo(String value) {
            addCriterion("team_key >=", value, "teamKey");
            return (Criteria) this;
        }

        public Criteria andTeamKeyLessThan(String value) {
            addCriterion("team_key <", value, "teamKey");
            return (Criteria) this;
        }

        public Criteria andTeamKeyLessThanOrEqualTo(String value) {
            addCriterion("team_key <=", value, "teamKey");
            return (Criteria) this;
        }

        public Criteria andTeamKeyLike(String value) {
            addCriterion("team_key like", value, "teamKey");
            return (Criteria) this;
        }

        public Criteria andTeamKeyNotLike(String value) {
            addCriterion("team_key not like", value, "teamKey");
            return (Criteria) this;
        }

        public Criteria andTeamKeyIn(List<String> values) {
            addCriterion("team_key in", values, "teamKey");
            return (Criteria) this;
        }

        public Criteria andTeamKeyNotIn(List<String> values) {
            addCriterion("team_key not in", values, "teamKey");
            return (Criteria) this;
        }

        public Criteria andTeamKeyBetween(String value1, String value2) {
            addCriterion("team_key between", value1, value2, "teamKey");
            return (Criteria) this;
        }

        public Criteria andTeamKeyNotBetween(String value1, String value2) {
            addCriterion("team_key not between", value1, value2, "teamKey");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andIpsIsNull() {
            addCriterion("ips is null");
            return (Criteria) this;
        }

        public Criteria andIpsIsNotNull() {
            addCriterion("ips is not null");
            return (Criteria) this;
        }

        public Criteria andIpsEqualTo(String value) {
            addCriterion("ips =", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsNotEqualTo(String value) {
            addCriterion("ips <>", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsGreaterThan(String value) {
            addCriterion("ips >", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsGreaterThanOrEqualTo(String value) {
            addCriterion("ips >=", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsLessThan(String value) {
            addCriterion("ips <", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsLessThanOrEqualTo(String value) {
            addCriterion("ips <=", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsLike(String value) {
            addCriterion("ips like", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsNotLike(String value) {
            addCriterion("ips not like", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsIn(List<String> values) {
            addCriterion("ips in", values, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsNotIn(List<String> values) {
            addCriterion("ips not in", values, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsBetween(String value1, String value2) {
            addCriterion("ips between", value1, value2, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsNotBetween(String value1, String value2) {
            addCriterion("ips not between", value1, value2, "ips");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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