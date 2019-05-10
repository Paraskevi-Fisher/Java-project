package com.test;

import java.util.HashSet;
import java.util.Set;

import javax.print.DocFlavor.STRING;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

public class test {
	JedisSentinelPool pool = null;
	JedisPoolConfig config = null;
	public test() {
		Set<String>set = new HashSet<String>();
		set.add("127.0.0.1:26379");
		config = new JedisPoolConfig();
		config.setMaxTotal(8);
		config.setMaxIdle(8); //设置最大空闲连接数，默认为8
        config.setMinIdle(0);//设置最小空闲连接数，默认为0
        config.setMaxWaitMillis(1000);//设置连接时的最长等待时间，单位为毫秒，默认为-1，表示永不超时
		
		pool = new JedisSentinelPool("xiaoF",set,config);
	}
	
	public void insert(String key,String value)
	{
		Jedis resource = pool.getResource();
		resource.set(key, value);
	}
	
	public void delete(String key)
	{
		Jedis resource = pool.getResource();
		resource.del(key);
	}
	
	public void update (String key,String value)
	{
		delete(key);
		insert(key, value);
	}
	
	public String select(String key)
	{
		Jedis resource = pool.getResource();
		String result = resource.get(key);
		return result;
	}
	
	public static void main(String[] args) {
//		Set<String>set = new HashSet<String>();
//		set.add("127.0.0.1:26379");
//		JedisPoolConfig config = new JedisPoolConfig();
//		config.setMaxTotal(8);
//		config.setMaxIdle(8); //设置最大空闲连接数，默认为8
//        config.setMinIdle(0);//设置最小空闲连接数，默认为0
//        config.setMaxWaitMillis(1000);//设置连接时的最长等待时间，单位为毫秒，默认为-1，表示永不超时
//		
//		JedisSentinelPool pool = new JedisSentinelPool("xiaoF",set,config);
//		HostAndPort hap = pool.getCurrentHostMaster();
//		System.out.println(hap.getHost() +" "+ hap.getPort());
//		
//		Jedis resource = pool.getResource();
//		resource.set("Firstpoolkey", "Hello World");
//		String result = resource.get("Firstpoolkey");
//		
//		resource.close();
	}
}
