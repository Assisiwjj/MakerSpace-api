package com.makerspace.demo.work.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public WorkExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
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

        public Criteria andPkIdIsNull() {
            addCriterion("pk_id is null");
            return (Criteria) this;
        }

        public Criteria andPkIdIsNotNull() {
            addCriterion("pk_id is not null");
            return (Criteria) this;
        }

        public Criteria andPkIdEqualTo(Long value) {
            addCriterion("pk_id =", value, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdNotEqualTo(Long value) {
            addCriterion("pk_id <>", value, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdGreaterThan(Long value) {
            addCriterion("pk_id >", value, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pk_id >=", value, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdLessThan(Long value) {
            addCriterion("pk_id <", value, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdLessThanOrEqualTo(Long value) {
            addCriterion("pk_id <=", value, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdIn(List<Long> values) {
            addCriterion("pk_id in", values, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdNotIn(List<Long> values) {
            addCriterion("pk_id not in", values, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdBetween(Long value1, Long value2) {
            addCriterion("pk_id between", value1, value2, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdNotBetween(Long value1, Long value2) {
            addCriterion("pk_id not between", value1, value2, "pkId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTypeTechnologyIsNull() {
            addCriterion("type_technology is null");
            return (Criteria) this;
        }

        public Criteria andTypeTechnologyIsNotNull() {
            addCriterion("type_technology is not null");
            return (Criteria) this;
        }

        public Criteria andTypeTechnologyEqualTo(String value) {
            addCriterion("type_technology =", value, "typeTechnology");
            return (Criteria) this;
        }

        public Criteria andTypeTechnologyNotEqualTo(String value) {
            addCriterion("type_technology <>", value, "typeTechnology");
            return (Criteria) this;
        }

        public Criteria andTypeTechnologyGreaterThan(String value) {
            addCriterion("type_technology >", value, "typeTechnology");
            return (Criteria) this;
        }

        public Criteria andTypeTechnologyGreaterThanOrEqualTo(String value) {
            addCriterion("type_technology >=", value, "typeTechnology");
            return (Criteria) this;
        }

        public Criteria andTypeTechnologyLessThan(String value) {
            addCriterion("type_technology <", value, "typeTechnology");
            return (Criteria) this;
        }

        public Criteria andTypeTechnologyLessThanOrEqualTo(String value) {
            addCriterion("type_technology <=", value, "typeTechnology");
            return (Criteria) this;
        }

        public Criteria andTypeTechnologyLike(String value) {
            addCriterion("type_technology like", value, "typeTechnology");
            return (Criteria) this;
        }

        public Criteria andTypeTechnologyNotLike(String value) {
            addCriterion("type_technology not like", value, "typeTechnology");
            return (Criteria) this;
        }

        public Criteria andTypeTechnologyIn(List<String> values) {
            addCriterion("type_technology in", values, "typeTechnology");
            return (Criteria) this;
        }

        public Criteria andTypeTechnologyNotIn(List<String> values) {
            addCriterion("type_technology not in", values, "typeTechnology");
            return (Criteria) this;
        }

        public Criteria andTypeTechnologyBetween(String value1, String value2) {
            addCriterion("type_technology between", value1, value2, "typeTechnology");
            return (Criteria) this;
        }

        public Criteria andTypeTechnologyNotBetween(String value1, String value2) {
            addCriterion("type_technology not between", value1, value2, "typeTechnology");
            return (Criteria) this;
        }

        public Criteria andTypeIndustryIsNull() {
            addCriterion("type_industry is null");
            return (Criteria) this;
        }

        public Criteria andTypeIndustryIsNotNull() {
            addCriterion("type_industry is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIndustryEqualTo(String value) {
            addCriterion("type_industry =", value, "typeIndustry");
            return (Criteria) this;
        }

        public Criteria andTypeIndustryNotEqualTo(String value) {
            addCriterion("type_industry <>", value, "typeIndustry");
            return (Criteria) this;
        }

        public Criteria andTypeIndustryGreaterThan(String value) {
            addCriterion("type_industry >", value, "typeIndustry");
            return (Criteria) this;
        }

        public Criteria andTypeIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("type_industry >=", value, "typeIndustry");
            return (Criteria) this;
        }

        public Criteria andTypeIndustryLessThan(String value) {
            addCriterion("type_industry <", value, "typeIndustry");
            return (Criteria) this;
        }

        public Criteria andTypeIndustryLessThanOrEqualTo(String value) {
            addCriterion("type_industry <=", value, "typeIndustry");
            return (Criteria) this;
        }

        public Criteria andTypeIndustryLike(String value) {
            addCriterion("type_industry like", value, "typeIndustry");
            return (Criteria) this;
        }

        public Criteria andTypeIndustryNotLike(String value) {
            addCriterion("type_industry not like", value, "typeIndustry");
            return (Criteria) this;
        }

        public Criteria andTypeIndustryIn(List<String> values) {
            addCriterion("type_industry in", values, "typeIndustry");
            return (Criteria) this;
        }

        public Criteria andTypeIndustryNotIn(List<String> values) {
            addCriterion("type_industry not in", values, "typeIndustry");
            return (Criteria) this;
        }

        public Criteria andTypeIndustryBetween(String value1, String value2) {
            addCriterion("type_industry between", value1, value2, "typeIndustry");
            return (Criteria) this;
        }

        public Criteria andTypeIndustryNotBetween(String value1, String value2) {
            addCriterion("type_industry not between", value1, value2, "typeIndustry");
            return (Criteria) this;
        }

        public Criteria andAffiliateTeamIsNull() {
            addCriterion("affiliate_team is null");
            return (Criteria) this;
        }

        public Criteria andAffiliateTeamIsNotNull() {
            addCriterion("affiliate_team is not null");
            return (Criteria) this;
        }

        public Criteria andAffiliateTeamEqualTo(Long value) {
            addCriterion("affiliate_team =", value, "affiliateTeam");
            return (Criteria) this;
        }

        public Criteria andAffiliateTeamNotEqualTo(Long value) {
            addCriterion("affiliate_team <>", value, "affiliateTeam");
            return (Criteria) this;
        }

        public Criteria andAffiliateTeamGreaterThan(Long value) {
            addCriterion("affiliate_team >", value, "affiliateTeam");
            return (Criteria) this;
        }

        public Criteria andAffiliateTeamGreaterThanOrEqualTo(Long value) {
            addCriterion("affiliate_team >=", value, "affiliateTeam");
            return (Criteria) this;
        }

        public Criteria andAffiliateTeamLessThan(Long value) {
            addCriterion("affiliate_team <", value, "affiliateTeam");
            return (Criteria) this;
        }

        public Criteria andAffiliateTeamLessThanOrEqualTo(Long value) {
            addCriterion("affiliate_team <=", value, "affiliateTeam");
            return (Criteria) this;
        }

        public Criteria andAffiliateTeamIn(List<Long> values) {
            addCriterion("affiliate_team in", values, "affiliateTeam");
            return (Criteria) this;
        }

        public Criteria andAffiliateTeamNotIn(List<Long> values) {
            addCriterion("affiliate_team not in", values, "affiliateTeam");
            return (Criteria) this;
        }

        public Criteria andAffiliateTeamBetween(Long value1, Long value2) {
            addCriterion("affiliate_team between", value1, value2, "affiliateTeam");
            return (Criteria) this;
        }

        public Criteria andAffiliateTeamNotBetween(Long value1, Long value2) {
            addCriterion("affiliate_team not between", value1, value2, "affiliateTeam");
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

        public Criteria andEnvironmentIsNull() {
            addCriterion("environment is null");
            return (Criteria) this;
        }

        public Criteria andEnvironmentIsNotNull() {
            addCriterion("environment is not null");
            return (Criteria) this;
        }

        public Criteria andEnvironmentEqualTo(String value) {
            addCriterion("environment =", value, "environment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentNotEqualTo(String value) {
            addCriterion("environment <>", value, "environment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentGreaterThan(String value) {
            addCriterion("environment >", value, "environment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentGreaterThanOrEqualTo(String value) {
            addCriterion("environment >=", value, "environment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentLessThan(String value) {
            addCriterion("environment <", value, "environment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentLessThanOrEqualTo(String value) {
            addCriterion("environment <=", value, "environment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentLike(String value) {
            addCriterion("environment like", value, "environment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentNotLike(String value) {
            addCriterion("environment not like", value, "environment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentIn(List<String> values) {
            addCriterion("environment in", values, "environment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentNotIn(List<String> values) {
            addCriterion("environment not in", values, "environment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentBetween(String value1, String value2) {
            addCriterion("environment between", value1, value2, "environment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentNotBetween(String value1, String value2) {
            addCriterion("environment not between", value1, value2, "environment");
            return (Criteria) this;
        }

        public Criteria andShowPicIsNull() {
            addCriterion("show_pic is null");
            return (Criteria) this;
        }

        public Criteria andShowPicIsNotNull() {
            addCriterion("show_pic is not null");
            return (Criteria) this;
        }

        public Criteria andShowPicEqualTo(String value) {
            addCriterion("show_pic =", value, "showPic");
            return (Criteria) this;
        }

        public Criteria andShowPicNotEqualTo(String value) {
            addCriterion("show_pic <>", value, "showPic");
            return (Criteria) this;
        }

        public Criteria andShowPicGreaterThan(String value) {
            addCriterion("show_pic >", value, "showPic");
            return (Criteria) this;
        }

        public Criteria andShowPicGreaterThanOrEqualTo(String value) {
            addCriterion("show_pic >=", value, "showPic");
            return (Criteria) this;
        }

        public Criteria andShowPicLessThan(String value) {
            addCriterion("show_pic <", value, "showPic");
            return (Criteria) this;
        }

        public Criteria andShowPicLessThanOrEqualTo(String value) {
            addCriterion("show_pic <=", value, "showPic");
            return (Criteria) this;
        }

        public Criteria andShowPicLike(String value) {
            addCriterion("show_pic like", value, "showPic");
            return (Criteria) this;
        }

        public Criteria andShowPicNotLike(String value) {
            addCriterion("show_pic not like", value, "showPic");
            return (Criteria) this;
        }

        public Criteria andShowPicIn(List<String> values) {
            addCriterion("show_pic in", values, "showPic");
            return (Criteria) this;
        }

        public Criteria andShowPicNotIn(List<String> values) {
            addCriterion("show_pic not in", values, "showPic");
            return (Criteria) this;
        }

        public Criteria andShowPicBetween(String value1, String value2) {
            addCriterion("show_pic between", value1, value2, "showPic");
            return (Criteria) this;
        }

        public Criteria andShowPicNotBetween(String value1, String value2) {
            addCriterion("show_pic not between", value1, value2, "showPic");
            return (Criteria) this;
        }

        public Criteria andProfileIsNull() {
            addCriterion("profile is null");
            return (Criteria) this;
        }

        public Criteria andProfileIsNotNull() {
            addCriterion("profile is not null");
            return (Criteria) this;
        }

        public Criteria andProfileEqualTo(String value) {
            addCriterion("profile =", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileNotEqualTo(String value) {
            addCriterion("profile <>", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileGreaterThan(String value) {
            addCriterion("profile >", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileGreaterThanOrEqualTo(String value) {
            addCriterion("profile >=", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileLessThan(String value) {
            addCriterion("profile <", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileLessThanOrEqualTo(String value) {
            addCriterion("profile <=", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileLike(String value) {
            addCriterion("profile like", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileNotLike(String value) {
            addCriterion("profile not like", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileIn(List<String> values) {
            addCriterion("profile in", values, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileNotIn(List<String> values) {
            addCriterion("profile not in", values, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileBetween(String value1, String value2) {
            addCriterion("profile between", value1, value2, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileNotBetween(String value1, String value2) {
            addCriterion("profile not between", value1, value2, "profile");
            return (Criteria) this;
        }

        public Criteria andHitsIsNull() {
            addCriterion("hits is null");
            return (Criteria) this;
        }

        public Criteria andHitsIsNotNull() {
            addCriterion("hits is not null");
            return (Criteria) this;
        }

        public Criteria andHitsEqualTo(Long value) {
            addCriterion("hits =", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsNotEqualTo(Long value) {
            addCriterion("hits <>", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsGreaterThan(Long value) {
            addCriterion("hits >", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsGreaterThanOrEqualTo(Long value) {
            addCriterion("hits >=", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsLessThan(Long value) {
            addCriterion("hits <", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsLessThanOrEqualTo(Long value) {
            addCriterion("hits <=", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsIn(List<Long> values) {
            addCriterion("hits in", values, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsNotIn(List<Long> values) {
            addCriterion("hits not in", values, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsBetween(Long value1, Long value2) {
            addCriterion("hits between", value1, value2, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsNotBetween(Long value1, Long value2) {
            addCriterion("hits not between", value1, value2, "hits");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Boolean value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Boolean value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Boolean value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Boolean value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Boolean> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Boolean> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsCheckIsNull() {
            addCriterion("is_check is null");
            return (Criteria) this;
        }

        public Criteria andIsCheckIsNotNull() {
            addCriterion("is_check is not null");
            return (Criteria) this;
        }

        public Criteria andIsCheckEqualTo(Boolean value) {
            addCriterion("is_check =", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckNotEqualTo(Boolean value) {
            addCriterion("is_check <>", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckGreaterThan(Boolean value) {
            addCriterion("is_check >", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_check >=", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckLessThan(Boolean value) {
            addCriterion("is_check <", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckLessThanOrEqualTo(Boolean value) {
            addCriterion("is_check <=", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckIn(List<Boolean> values) {
            addCriterion("is_check in", values, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckNotIn(List<Boolean> values) {
            addCriterion("is_check not in", values, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckBetween(Boolean value1, Boolean value2) {
            addCriterion("is_check between", value1, value2, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_check not between", value1, value2, "isCheck");
            return (Criteria) this;
        }
    }

    /**
     */
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