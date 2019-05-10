package com.test;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.*;

public class test3 {
	JedisCluster cluster = null;
	public test3() {
		// TODO Auto-generated constructor stub
		Set<HostAndPort>connection = new HashSet<HostAndPort>();
		connection.add(new HostAndPort("127.0.0.1", 6379));
		connection.add(new HostAndPort("127.0.0.1", 8888));
		connection.add(new HostAndPort("127.0.0.1", 8889));
		connection.add(new HostAndPort("127.0.0.1", 8890));
		
		cluster = new JedisCluster(connection);
	}
	
	public void insert(String key,String value)
	{
		cluster.set(key, value);
	}
	
	public void delete(String key)
	{
		cluster.del(key);
	}
	
	public void update(String key,String value)
	{
		cluster.set(key, value);
	}
	
	public String select(String key)
	{
		String result = cluster.get(key);
		return result;
	}
	
	public static void main(String[] args) {
		Set<HostAndPort>connection = new HashSet<HostAndPort>();
		connection.add(new HostAndPort("127.0.0.1", 6379));
		connection.add(new HostAndPort("127.0.0.1", 8888));
		connection.add(new HostAndPort("127.0.0.1", 8889));
		connection.add(new HostAndPort("127.0.0.1", 8890));
		
		JedisCluster cluster = new JedisCluster(connection);
		cluster.set("clusterTest", "HelloWorld");
		System.out.println(cluster.get("clusterTest"));
		
	}
}
