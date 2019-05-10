package com.test;

import java.util.*;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mapper.FlowerMapper;

import pojo.flower;

public class Test {
	public static void main(String[] args) throws Exception
	{
		InputStream is = Resources.getResourceAsStream("mybatis.xml");//选择核心XML
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);//把XML发送给工厂
		SqlSession session = factory.openSession();//工厂生产出一个会话
		
		FlowerMapper ses = session.getMapper(FlowerMapper.class);
		flower f = new flower(0, "", 3, "啊哈哈");
		List<flower>list = ses.selByFlower(f);

		for (flower flw : list)
		{
			System.out.println(flw);
		}
		
		session.close();
	}
}
