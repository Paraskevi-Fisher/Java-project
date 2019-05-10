package com.test;


import net.sf.json.JSONObject;

import com.UserDao.SerializeUtil;
import com.UserDao.UserVO;

import redis.clients.jedis.Jedis;

public class counter {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost", 6379);
		//普通键值对存储查询删除
		jedis.set("key", "value");
		System.out.println(jedis.get("key"));
		jedis.del("key");
		
		// 对象的存储
		UserVO student1 = new UserVO();
    	student1.setUserId("1");
    	student1.setPassWord("123456");
    	student1.setUserName("张三");
    	
    	//方法一：序列化对象存储
    	byte[] stuSer = SerializeUtil.serizlize(student1);
    	jedis.set("stu1".getBytes(), stuSer);
    	System.out.println(SerializeUtil.deserialize(jedis.get("stu1".getBytes())));
    	jedis.del("stu1".getBytes());
    	
    	//方法二：JSON存储
    	JSONObject stuJSON = JSONObject.fromObject(student1);
    	jedis.set("stu1", stuJSON.toString());
    	String re = jedis.get("stu1");
    	JSONObject json = JSONObject.fromObject(re);
    	UserVO output = (UserVO)JSONObject.toBean(json,UserVO.class);
    	System.out.println(output);
    	jedis.del("stu1");
    	
    	
    	//方法三：hash结构存储
    	jedis.hset("stu1", "UserId", student1.getUserId());
    	jedis.hset("stu1", "PassWord", student1.getPassWord());
    	jedis.hset("stu1", "UserName", student1.getUserName());
    	
    	UserVO output2 = new UserVO();
    	output2.setUserId(jedis.hget("stu1", "UserId"));
    	output2.setPassWord(jedis.hget("stu1", "PassWord"));
    	output2.setUserName(jedis.hget("stu1", "UserName"));
    	System.out.println(output2);
    	jedis.del("stu1");
    	
		jedis.close();
	}
}
