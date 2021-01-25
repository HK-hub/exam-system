package cn.exam.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author YS
 * @version 1.0
 * @date 2020/3/19 14:56
 */
@Component
@Slf4j
public class RedisUtil {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    public String getKey(String key) {
        System.out.println(key);
        String str = null;
        Object s = redisTemplate.opsForValue().get(key);
        if (!ObjectUtils.isEmpty(s)) {
            str = s.toString();
        }
        return str;
    }

    /**
     * 没有超时时间放入key
     *
     */
    public boolean setKey(String key, String value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            log.debug("redis异常"+e);
            return false;
        }
    }

    /**
     * 有超时时间
     *
     */
    public boolean setKeyTime(String key, String value, long time) {
        try {
            redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            log.debug("redis异常"+e);
            return false;
        }
    }


    public boolean delKey(String key){
        try{
            redisTemplate.delete(key);
            return true;
        }catch (Exception e){
            log.debug("redis异常"+e);
            return false;
        }

    }

}
