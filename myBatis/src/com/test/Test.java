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
		InputStream is = Resources.getResourceAsStream("mybatis.xml");//ѡ�����XML
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);//��XML���͸�����
		SqlSession session = factory.openSession();//����������һ���Ự
		
		FlowerMapper ses = session.getMapper(FlowerMapper.class);
		flower f = new flower(0, "", 3, "������");
		List<flower>list = ses.selByFlower(f);

		for (flower flw : list)
		{
			System.out.println(flw);
		}
		
		session.close();
	}
}
