package com.fengzhuo.tudou.ms.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserScoreStatisticsLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserScoreStatisticsLogExample() {
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andIdNoIsNull() {
            addCriterion("id_no is null");
            return (Criteria) this;
        }

        public Criteria andIdNoIsNotNull() {
            addCriterion("id_no is not null");
            return (Criteria) this;
        }

        public Criteria andIdNoEqualTo(String value) {
            addCriterion("id_no =", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotEqualTo(String value) {
            addCriterion("id_no <>", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoGreaterThan(String value) {
            addCriterion("id_no >", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoGreaterThanOrEqualTo(String value) {
            addCriterion("id_no >=", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLessThan(String value) {
            addCriterion("id_no <", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLessThanOrEqualTo(String value) {
            addCriterion("id_no <=", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLike(String value) {
            addCriterion("id_no like", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotLike(String value) {
            addCriterion("id_no not like", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoIn(List<String> values) {
            addCriterion("id_no in", values, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotIn(List<String> values) {
            addCriterion("id_no not in", values, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoBetween(String value1, String value2) {
            addCriterion("id_no between", value1, value2, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotBetween(String value1, String value2) {
            addCriterion("id_no not between", value1, value2, "idNo");
            return (Criteria) this;
        }

        public Criteria andZhimaScoreIsNull() {
            addCriterion("zhima_score is null");
            return (Criteria) this;
        }

        public Criteria andZhimaScoreIsNotNull() {
            addCriterion("zhima_score is not null");
            return (Criteria) this;
        }

        public Criteria andZhimaScoreEqualTo(BigDecimal value) {
            addCriterion("zhima_score =", value, "zhimaScore");
            return (Criteria) this;
        }

        public Criteria andZhimaScoreNotEqualTo(BigDecimal value) {
            addCriterion("zhima_score <>", value, "zhimaScore");
            return (Criteria) this;
        }

        public Criteria andZhimaScoreGreaterThan(BigDecimal value) {
            addCriterion("zhima_score >", value, "zhimaScore");
            return (Criteria) this;
        }

        public Criteria andZhimaScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("zhima_score >=", value, "zhimaScore");
            return (Criteria) this;
        }

        public Criteria andZhimaScoreLessThan(BigDecimal value) {
            addCriterion("zhima_score <", value, "zhimaScore");
            return (Criteria) this;
        }

        public Criteria andZhimaScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("zhima_score <=", value, "zhimaScore");
            return (Criteria) this;
        }

        public Criteria andZhimaScoreIn(List<BigDecimal> values) {
            addCriterion("zhima_score in", values, "zhimaScore");
            return (Criteria) this;
        }

        public Criteria andZhimaScoreNotIn(List<BigDecimal> values) {
            addCriterion("zhima_score not in", values, "zhimaScore");
            return (Criteria) this;
        }

        public Criteria andZhimaScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("zhima_score between", value1, value2, "zhimaScore");
            return (Criteria) this;
        }

        public Criteria andZhimaScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("zhima_score not between", value1, value2, "zhimaScore");
            return (Criteria) this;
        }

        public Criteria andHuluScoreIsNull() {
            addCriterion("hulu_score is null");
            return (Criteria) this;
        }

        public Criteria andHuluScoreIsNotNull() {
            addCriterion("hulu_score is not null");
            return (Criteria) this;
        }

        public Criteria andHuluScoreEqualTo(BigDecimal value) {
            addCriterion("hulu_score =", value, "huluScore");
            return (Criteria) this;
        }

        public Criteria andHuluScoreNotEqualTo(BigDecimal value) {
            addCriterion("hulu_score <>", value, "huluScore");
            return (Criteria) this;
        }

        public Criteria andHuluScoreGreaterThan(BigDecimal value) {
            addCriterion("hulu_score >", value, "huluScore");
            return (Criteria) this;
        }

        public Criteria andHuluScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hulu_score >=", value, "huluScore");
            return (Criteria) this;
        }

        public Criteria andHuluScoreLessThan(BigDecimal value) {
            addCriterion("hulu_score <", value, "huluScore");
            return (Criteria) this;
        }

        public Criteria andHuluScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hulu_score <=", value, "huluScore");
            return (Criteria) this;
        }

        public Criteria andHuluScoreIn(List<BigDecimal> values) {
            addCriterion("hulu_score in", values, "huluScore");
            return (Criteria) this;
        }

        public Criteria andHuluScoreNotIn(List<BigDecimal> values) {
            addCriterion("hulu_score not in", values, "huluScore");
            return (Criteria) this;
        }

        public Criteria andHuluScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hulu_score between", value1, value2, "huluScore");
            return (Criteria) this;
        }

        public Criteria andHuluScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hulu_score not between", value1, value2, "huluScore");
            return (Criteria) this;
        }

        public Criteria andTongdunScoreIsNull() {
            addCriterion("tongdun_score is null");
            return (Criteria) this;
        }

        public Criteria andTongdunScoreIsNotNull() {
            addCriterion("tongdun_score is not null");
            return (Criteria) this;
        }

        public Criteria andTongdunScoreEqualTo(BigDecimal value) {
            addCriterion("tongdun_score =", value, "tongdunScore");
            return (Criteria) this;
        }

        public Criteria andTongdunScoreNotEqualTo(BigDecimal value) {
            addCriterion("tongdun_score <>", value, "tongdunScore");
            return (Criteria) this;
        }

        public Criteria andTongdunScoreGreaterThan(BigDecimal value) {
            addCriterion("tongdun_score >", value, "tongdunScore");
            return (Criteria) this;
        }

        public Criteria andTongdunScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tongdun_score >=", value, "tongdunScore");
            return (Criteria) this;
        }

        public Criteria andTongdunScoreLessThan(BigDecimal value) {
            addCriterion("tongdun_score <", value, "tongdunScore");
            return (Criteria) this;
        }

        public Criteria andTongdunScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tongdun_score <=", value, "tongdunScore");
            return (Criteria) this;
        }

        public Criteria andTongdunScoreIn(List<BigDecimal> values) {
            addCriterion("tongdun_score in", values, "tongdunScore");
            return (Criteria) this;
        }

        public Criteria andTongdunScoreNotIn(List<BigDecimal> values) {
            addCriterion("tongdun_score not in", values, "tongdunScore");
            return (Criteria) this;
        }

        public Criteria andTongdunScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tongdun_score between", value1, value2, "tongdunScore");
            return (Criteria) this;
        }

        public Criteria andTongdunScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tongdun_score not between", value1, value2, "tongdunScore");
            return (Criteria) this;
        }

        public Criteria andUdScoreIsNull() {
            addCriterion("ud_score is null");
            return (Criteria) this;
        }

        public Criteria andUdScoreIsNotNull() {
            addCriterion("ud_score is not null");
            return (Criteria) this;
        }

        public Criteria andUdScoreEqualTo(BigDecimal value) {
            addCriterion("ud_score =", value, "udScore");
            return (Criteria) this;
        }

        public Criteria andUdScoreNotEqualTo(BigDecimal value) {
            addCriterion("ud_score <>", value, "udScore");
            return (Criteria) this;
        }

        public Criteria andUdScoreGreaterThan(BigDecimal value) {
            addCriterion("ud_score >", value, "udScore");
            return (Criteria) this;
        }

        public Criteria andUdScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ud_score >=", value, "udScore");
            return (Criteria) this;
        }

        public Criteria andUdScoreLessThan(BigDecimal value) {
            addCriterion("ud_score <", value, "udScore");
            return (Criteria) this;
        }

        public Criteria andUdScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ud_score <=", value, "udScore");
            return (Criteria) this;
        }

        public Criteria andUdScoreIn(List<BigDecimal> values) {
            addCriterion("ud_score in", values, "udScore");
            return (Criteria) this;
        }

        public Criteria andUdScoreNotIn(List<BigDecimal> values) {
            addCriterion("ud_score not in", values, "udScore");
            return (Criteria) this;
        }

        public Criteria andUdScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ud_score between", value1, value2, "udScore");
            return (Criteria) this;
        }

        public Criteria andUdScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ud_score not between", value1, value2, "udScore");
            return (Criteria) this;
        }

        public Criteria andNewUdScoreIsNull() {
            addCriterion("new_ud_score is null");
            return (Criteria) this;
        }

        public Criteria andNewUdScoreIsNotNull() {
            addCriterion("new_ud_score is not null");
            return (Criteria) this;
        }

        public Criteria andNewUdScoreEqualTo(BigDecimal value) {
            addCriterion("new_ud_score =", value, "newUdScore");
            return (Criteria) this;
        }

        public Criteria andNewUdScoreNotEqualTo(BigDecimal value) {
            addCriterion("new_ud_score <>", value, "newUdScore");
            return (Criteria) this;
        }

        public Criteria andNewUdScoreGreaterThan(BigDecimal value) {
            addCriterion("new_ud_score >", value, "newUdScore");
            return (Criteria) this;
        }

        public Criteria andNewUdScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("new_ud_score >=", value, "newUdScore");
            return (Criteria) this;
        }

        public Criteria andNewUdScoreLessThan(BigDecimal value) {
            addCriterion("new_ud_score <", value, "newUdScore");
            return (Criteria) this;
        }

        public Criteria andNewUdScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("new_ud_score <=", value, "newUdScore");
            return (Criteria) this;
        }

        public Criteria andNewUdScoreIn(List<BigDecimal> values) {
            addCriterion("new_ud_score in", values, "newUdScore");
            return (Criteria) this;
        }

        public Criteria andNewUdScoreNotIn(List<BigDecimal> values) {
            addCriterion("new_ud_score not in", values, "newUdScore");
            return (Criteria) this;
        }

        public Criteria andNewUdScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("new_ud_score between", value1, value2, "newUdScore");
            return (Criteria) this;
        }

        public Criteria andNewUdScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("new_ud_score not between", value1, value2, "newUdScore");
            return (Criteria) this;
        }

        public Criteria andModelScoreIsNull() {
            addCriterion("model_score is null");
            return (Criteria) this;
        }

        public Criteria andModelScoreIsNotNull() {
            addCriterion("model_score is not null");
            return (Criteria) this;
        }

        public Criteria andModelScoreEqualTo(BigDecimal value) {
            addCriterion("model_score =", value, "modelScore");
            return (Criteria) this;
        }

        public Criteria andModelScoreNotEqualTo(BigDecimal value) {
            addCriterion("model_score <>", value, "modelScore");
            return (Criteria) this;
        }

        public Criteria andModelScoreGreaterThan(BigDecimal value) {
            addCriterion("model_score >", value, "modelScore");
            return (Criteria) this;
        }

        public Criteria andModelScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("model_score >=", value, "modelScore");
            return (Criteria) this;
        }

        public Criteria andModelScoreLessThan(BigDecimal value) {
            addCriterion("model_score <", value, "modelScore");
            return (Criteria) this;
        }

        public Criteria andModelScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("model_score <=", value, "modelScore");
            return (Criteria) this;
        }

        public Criteria andModelScoreIn(List<BigDecimal> values) {
            addCriterion("model_score in", values, "modelScore");
            return (Criteria) this;
        }

        public Criteria andModelScoreNotIn(List<BigDecimal> values) {
            addCriterion("model_score not in", values, "modelScore");
            return (Criteria) this;
        }

        public Criteria andModelScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("model_score between", value1, value2, "modelScore");
            return (Criteria) this;
        }

        public Criteria andModelScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("model_score not between", value1, value2, "modelScore");
            return (Criteria) this;
        }

        public Criteria andPpxScoreIsNull() {
            addCriterion("ppx_score is null");
            return (Criteria) this;
        }

        public Criteria andPpxScoreIsNotNull() {
            addCriterion("ppx_score is not null");
            return (Criteria) this;
        }

        public Criteria andPpxScoreEqualTo(BigDecimal value) {
            addCriterion("ppx_score =", value, "ppxScore");
            return (Criteria) this;
        }

        public Criteria andPpxScoreNotEqualTo(BigDecimal value) {
            addCriterion("ppx_score <>", value, "ppxScore");
            return (Criteria) this;
        }

        public Criteria andPpxScoreGreaterThan(BigDecimal value) {
            addCriterion("ppx_score >", value, "ppxScore");
            return (Criteria) this;
        }

        public Criteria andPpxScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ppx_score >=", value, "ppxScore");
            return (Criteria) this;
        }

        public Criteria andPpxScoreLessThan(BigDecimal value) {
            addCriterion("ppx_score <", value, "ppxScore");
            return (Criteria) this;
        }

        public Criteria andPpxScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ppx_score <=", value, "ppxScore");
            return (Criteria) this;
        }

        public Criteria andPpxScoreIn(List<BigDecimal> values) {
            addCriterion("ppx_score in", values, "ppxScore");
            return (Criteria) this;
        }

        public Criteria andPpxScoreNotIn(List<BigDecimal> values) {
            addCriterion("ppx_score not in", values, "ppxScore");
            return (Criteria) this;
        }

        public Criteria andPpxScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ppx_score between", value1, value2, "ppxScore");
            return (Criteria) this;
        }

        public Criteria andPpxScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ppx_score not between", value1, value2, "ppxScore");
            return (Criteria) this;
        }

        public Criteria andBorrowTimesScoreIsNull() {
            addCriterion("borrow_times_score is null");
            return (Criteria) this;
        }

        public Criteria andBorrowTimesScoreIsNotNull() {
            addCriterion("borrow_times_score is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowTimesScoreEqualTo(BigDecimal value) {
            addCriterion("borrow_times_score =", value, "borrowTimesScore");
            return (Criteria) this;
        }

        public Criteria andBorrowTimesScoreNotEqualTo(BigDecimal value) {
            addCriterion("borrow_times_score <>", value, "borrowTimesScore");
            return (Criteria) this;
        }

        public Criteria andBorrowTimesScoreGreaterThan(BigDecimal value) {
            addCriterion("borrow_times_score >", value, "borrowTimesScore");
            return (Criteria) this;
        }

        public Criteria andBorrowTimesScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("borrow_times_score >=", value, "borrowTimesScore");
            return (Criteria) this;
        }

        public Criteria andBorrowTimesScoreLessThan(BigDecimal value) {
            addCriterion("borrow_times_score <", value, "borrowTimesScore");
            return (Criteria) this;
        }

        public Criteria andBorrowTimesScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("borrow_times_score <=", value, "borrowTimesScore");
            return (Criteria) this;
        }

        public Criteria andBorrowTimesScoreIn(List<BigDecimal> values) {
            addCriterion("borrow_times_score in", values, "borrowTimesScore");
            return (Criteria) this;
        }

        public Criteria andBorrowTimesScoreNotIn(List<BigDecimal> values) {
            addCriterion("borrow_times_score not in", values, "borrowTimesScore");
            return (Criteria) this;
        }

        public Criteria andBorrowTimesScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("borrow_times_score between", value1, value2, "borrowTimesScore");
            return (Criteria) this;
        }

        public Criteria andBorrowTimesScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("borrow_times_score not between", value1, value2, "borrowTimesScore");
            return (Criteria) this;
        }

        public Criteria andMobileTypeIsNull() {
            addCriterion("mobile_type is null");
            return (Criteria) this;
        }

        public Criteria andMobileTypeIsNotNull() {
            addCriterion("mobile_type is not null");
            return (Criteria) this;
        }

        public Criteria andMobileTypeEqualTo(String value) {
            addCriterion("mobile_type =", value, "mobileType");
            return (Criteria) this;
        }

        public Criteria andMobileTypeNotEqualTo(String value) {
            addCriterion("mobile_type <>", value, "mobileType");
            return (Criteria) this;
        }

        public Criteria andMobileTypeGreaterThan(String value) {
            addCriterion("mobile_type >", value, "mobileType");
            return (Criteria) this;
        }

        public Criteria andMobileTypeGreaterThanOrEqualTo(String value) {
            addCriterion("mobile_type >=", value, "mobileType");
            return (Criteria) this;
        }

        public Criteria andMobileTypeLessThan(String value) {
            addCriterion("mobile_type <", value, "mobileType");
            return (Criteria) this;
        }

        public Criteria andMobileTypeLessThanOrEqualTo(String value) {
            addCriterion("mobile_type <=", value, "mobileType");
            return (Criteria) this;
        }

        public Criteria andMobileTypeLike(String value) {
            addCriterion("mobile_type like", value, "mobileType");
            return (Criteria) this;
        }

        public Criteria andMobileTypeNotLike(String value) {
            addCriterion("mobile_type not like", value, "mobileType");
            return (Criteria) this;
        }

        public Criteria andMobileTypeIn(List<String> values) {
            addCriterion("mobile_type in", values, "mobileType");
            return (Criteria) this;
        }

        public Criteria andMobileTypeNotIn(List<String> values) {
            addCriterion("mobile_type not in", values, "mobileType");
            return (Criteria) this;
        }

        public Criteria andMobileTypeBetween(String value1, String value2) {
            addCriterion("mobile_type between", value1, value2, "mobileType");
            return (Criteria) this;
        }

        public Criteria andMobileTypeNotBetween(String value1, String value2) {
            addCriterion("mobile_type not between", value1, value2, "mobileType");
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

        public Criteria andOverDayIsNull() {
            addCriterion("over_day is null");
            return (Criteria) this;
        }

        public Criteria andOverDayIsNotNull() {
            addCriterion("over_day is not null");
            return (Criteria) this;
        }

        public Criteria andOverDayEqualTo(Integer value) {
            addCriterion("over_day =", value, "overDay");
            return (Criteria) this;
        }

        public Criteria andOverDayNotEqualTo(Integer value) {
            addCriterion("over_day <>", value, "overDay");
            return (Criteria) this;
        }

        public Criteria andOverDayGreaterThan(Integer value) {
            addCriterion("over_day >", value, "overDay");
            return (Criteria) this;
        }

        public Criteria andOverDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("over_day >=", value, "overDay");
            return (Criteria) this;
        }

        public Criteria andOverDayLessThan(Integer value) {
            addCriterion("over_day <", value, "overDay");
            return (Criteria) this;
        }

        public Criteria andOverDayLessThanOrEqualTo(Integer value) {
            addCriterion("over_day <=", value, "overDay");
            return (Criteria) this;
        }

        public Criteria andOverDayIn(List<Integer> values) {
            addCriterion("over_day in", values, "overDay");
            return (Criteria) this;
        }

        public Criteria andOverDayNotIn(List<Integer> values) {
            addCriterion("over_day not in", values, "overDay");
            return (Criteria) this;
        }

        public Criteria andOverDayBetween(Integer value1, Integer value2) {
            addCriterion("over_day between", value1, value2, "overDay");
            return (Criteria) this;
        }

        public Criteria andOverDayNotBetween(Integer value1, Integer value2) {
            addCriterion("over_day not between", value1, value2, "overDay");
            return (Criteria) this;
        }

        public Criteria andTeamIdIsNull() {
            addCriterion("team_id is null");
            return (Criteria) this;
        }

        public Criteria andTeamIdIsNotNull() {
            addCriterion("team_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeamIdEqualTo(Long value) {
            addCriterion("team_id =", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotEqualTo(Long value) {
            addCriterion("team_id <>", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThan(Long value) {
            addCriterion("team_id >", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThanOrEqualTo(Long value) {
            addCriterion("team_id >=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThan(Long value) {
            addCriterion("team_id <", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThanOrEqualTo(Long value) {
            addCriterion("team_id <=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdIn(List<Long> values) {
            addCriterion("team_id in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotIn(List<Long> values) {
            addCriterion("team_id not in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdBetween(Long value1, Long value2) {
            addCriterion("team_id between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotBetween(Long value1, Long value2) {
            addCriterion("team_id not between", value1, value2, "teamId");
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