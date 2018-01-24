package com.fengzhuo.tudou.ms.jedis;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

@Component
public class JedisClient {
    private final static Logger log = Logger.getLogger(JedisClient.class);
    @Resource
    private JedisPool jedisPool;

    public void set(String key, String value) {
        Jedis client = null;
        try {
            client = jedisPool.getResource();
            client.set(key, value);
        } catch (Exception e) {
            log.error("", e);
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    public String get(String key) {
        Jedis client = null;
        try {
            client = jedisPool.getResource();
            return client.get(key);
        } catch (Exception e) {
            log.error("", e);
        } finally {
            if (client != null) {
                client.close();
            }
        }
        return null;
    }

    public void setex(String key, String value, int time) {
        Jedis client = null;
        try {
            client = jedisPool.getResource();
            client.setex(key, time, value);
        } catch (Exception e) {
            log.error("", e);
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    public void hset(String key, String field, String value) {
        Jedis client = null;
        try {
            client = jedisPool.getResource();
            client.hset(key, field, value);
        } catch (Exception e) {
            log.error("", e);
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    public String hget(String key, String field) {
        Jedis client = null;
        try {
            client = jedisPool.getResource();
            return client.hget(key, field);
        } catch (Exception e) {
            log.error("", e);
        } finally {
            if (client != null) {
                client.close();
            }
        }
        return null;
    }

    public void del(String key){
        Jedis client = null;
        try {
            client = jedisPool.getResource();
            client.del(key);
        } catch (Exception e) {
            log.error("", e);
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }
}
