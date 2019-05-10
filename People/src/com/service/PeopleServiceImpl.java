package com.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pojo.People;

public class PeopleServiceImpl implements PeopleService{

	@Override
	public List<People> show() throws IOException {
		InputStream is = Resources.getResourceAsStream("Mybatis.xml");
		SqlSessionFactory factory =  new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		List<People>result = session.selectList("com.Mapper.selAll");
		session.close();
		return result;
	}

}
