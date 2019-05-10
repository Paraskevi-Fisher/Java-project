package com.test;

import java.util.Arrays;
import java.util.List;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class test2 {
	ShardedJedis jedis;
	public test2() {
		// TODO Auto-generated constructor stub
		JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(2);
        poolConfig.setMaxIdle(1);
        poolConfig.setMaxWaitMillis(2000);
        poolConfig.setTestOnBorrow(false);
        poolConfig.setTestOnReturn(false);
        
        JedisShardInfo jsi1 = new JedisShardInfo("127.0.0.1",6379,500);
        JedisShardInfo jsi2 = new JedisShardInfo("127.0.0.1",8888,500);
        JedisShardInfo jsi3 = new JedisShardInfo("127.0.0.1",8889,500);
        JedisShardInfo jsi4 = new JedisShardInfo("127.0.0.1",8890,500);
        
        List<JedisShardInfo> infoList = Arrays.asList(jsi1,jsi2,jsi3,jsi4);
        
        ShardedJedisPool pool = new ShardedJedisPool(poolConfig, infoList);
        
        jedis = pool.getResource();
	}

	public void insert(String key,String value)
	{
		jedis.set(key, value);
	}
	
	public void delete(String key)
	{
		jedis.del(key);
	}
	
	public void update(String key,String value)
	{
		jedis.set(key, value);
	}
	
	public String select(String key)
	{
		String result = jedis.get(key);
		return result;
	}
	
	
//	public static void main(String[] args) {
//		JedisPoolConfig poolConfig = new JedisPoolConfig();
//        poolConfig.setMaxTotal(2);
//        poolConfig.setMaxIdle(1);
//        poolConfig.setMaxWaitMillis(2000);
//        poolConfig.setTestOnBorrow(false);
//        poolConfig.setTestOnReturn(false);
//        
//        JedisShardInfo jsi1 = new JedisShardInfo("127.0.0.1",6379,500);
//        JedisShardInfo jsi2 = new JedisShardInfo("127.0.0.1",8888,500);
//        JedisShardInfo jsi3 = new JedisShardInfo("127.0.0.1",8889,500);
//        JedisShardInfo jsi4 = new JedisShardInfo("127.0.0.1",8890,500);
//        
//        List<JedisShardInfo> infoList = Arrays.asList(jsi1,jsi2,jsi3,jsi4);
//        
//        ShardedJedisPool pool = new ShardedJedisPool(poolConfig, infoList);
//        
//        ShardedJedis jedis = pool.getResource();
//        
//        jedis.set("shareTest", "HelloWorld");
//        String result = jedis.get("shareTest");
//        
//        System.out.println(result);
//     }
}
