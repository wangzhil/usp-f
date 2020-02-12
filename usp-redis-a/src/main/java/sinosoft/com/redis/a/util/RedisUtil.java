package sinosoft.com.redis.a.util;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String, ?> redisTemplate;
    
    //切换redis数据库
    public void changeDatabase(String database) {
    	JedisConnectionFactory jedisConnectionFactory =(JedisConnectionFactory)redisTemplate.getConnectionFactory();
    	jedisConnectionFactory.setDatabase(new Integer(database));
    	redisTemplate.setConnectionFactory(jedisConnectionFactory);
    }
    
    
    
    /** 
     * 获取map缓存 
     * @param key 
     * @param clazz 
     * @return 
     */  
    public  <T> Map<String, T> getMap(String key, Class<T> clazz){  
        BoundHashOperations<String, String, T> boundHashOperations = redisTemplate.boundHashOps(key);   
        return boundHashOperations.entries();  
    }  
    
    
    /**
     * 
     * 给redis缓存（key-value）
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, final String value) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                connection.set(serializer.serialize(key), serializer.serialize(value));
                return true;
            }
        });
        return result;
    }
    
    /**
     * 
     * 给redis缓存（key-value）
     * @param key
     * @param value
     * @return
     */
    public boolean getList(final String key, final String value) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                connection.set(serializer.serialize(key), serializer.serialize(value));
                return true;
            }
        });
        return result;
    }

    /**
     * 
     * 从redis缓存中取key对应的value
     * @param key
     * @return
     */
    public String get(final String key) {
        String result = redisTemplate.execute(new RedisCallback<String>() {

            public String doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] value = connection.get(serializer.serialize(key));
                return serializer.deserialize(value);
            }
        });
        return result;
    }

    /**
     * 
     * 给redis的key设置有效时间
     * @param key
     * @param expire
     * @return
     */
    public boolean expire(final String key, long expire) {
        return redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }


    /**
     * 
     * 用于移除并返回列表的第一个元素
     * @param key
     * @return
     */
    public String lpop(final String key) {
        String result = redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] res = connection.lPop(serializer.serialize(key));
                return serializer.deserialize(res);
            }
        });
        return result;
    }

    /**
     * 
     * 校验redis缓存中是否存在key
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 
     * 删除redis缓存存在key
     * @param key
     * @return
     */
    public void delete(final String key) {
        redisTemplate.delete(key);
    }
    
    /**
     * 
     * redis存list
     * @param key
     * @return
     */
    public  void setListAll(String key, List list) {
        redisTemplate.opsForList().leftPushAll(key,list);
    } 
    
    /**
     * 
     * redis取list
     * @param key
     * @return
     */
	public List<String> getListAll(String key) {
        return (List<String>) redisTemplate.opsForList().range(key, 0, -1);
    } 
	/**
     * 
     * redis取set
     * @param key
     * @return
     */
	public Set<String> getSet(String key) {
        return (Set<String>) redisTemplate.opsForSet().members(key);
    } 
}
