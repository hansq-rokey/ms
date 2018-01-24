package com.fengzhuo.tudou.ms.domain;

/**
 * Created by hanshuaiqi 18:44 2017/11/6
 */
public class LoanStrategyResult {

    private Double score;
    private String status; //10：执行失败  20：执行成功

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
