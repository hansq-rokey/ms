package com.fengzhuo.tudou.ms.domain;

public class AppConfig {
    private String signKey;
    private int env;

    public String getSignKey() {
        return signKey;
    }

    public void setSignKey(String signKey) {
        this.signKey = signKey;
    }

    public int getEnv() {
        return env;
    }

    public void setEnv(int env) {
        this.env = env;
    }

}
