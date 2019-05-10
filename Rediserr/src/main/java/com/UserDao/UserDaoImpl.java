package com.UserDao;

import java.util.ArrayList;
import java.util.List;
import redis.clients.jedis.Jedis;

public class UserDaoImpl implements UserDao {
	private Jedis jedis;
	
	public int getIdNum()
	{
		init();
		
		int result = Integer.parseInt(jedis.get("UserVONum"));
		
		return result;
	}
	
	@Override
	public List<UserVO> queryAll() {
		init();
		
		List<byte[]> allList = jedis.lrange("UserVO".getBytes(), 0, -1);
		
		List<UserVO> result = new ArrayList<>();
		for (byte[] i : allList)
		{
			UserVO Student = (UserVO)SerializeUtil.deserialize(i);
			result.add(Student);
		}
		
		return result;
	}

	@Override
	public List<UserVO> queryByName(String name) {
		List<UserVO>allList = queryAll();
		List<UserVO>result = new ArrayList<>();
		for (UserVO student: allList)
		{
			if (name.equals(student.getUserName()))
			{
				result.add(student);
			}
		}
		
		return result;
	}

	@Override
	public UserVO queryById(String userId) {
		List<UserVO>allList = queryAll();
		UserVO result = null;
		for (UserVO student: allList)
		{
			if (userId.equals(student.getUserId()))
			{
				result = student;
				break;
			}
		}
		
		return result;
	}

	@Override
	public void insert(UserVO user) {
		init();
		
		Integer id = getIdNum();
		user.setUserId(id.toString());
		
		byte[] save = SerializeUtil.serizlize(user);
		jedis.rpush("UserVO".getBytes(), save);
		
		id++;
		jedis.set("UserVONum", id.toString());
		
		return;
	}

	@Override
	public void update(UserVO user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserVO user) {
		List<UserVO>allList = queryAll();
		
		jedis.ltrim("UserVO".getBytes(), 1, 0);
		
		int len = allList.size();
		for (int i=0;i<allList.size();i++)
		{
			if (user.equals(allList.get(i)))
			{
				allList.remove(i);
			}
		}
		
		for (UserVO i : allList)
		{
			byte[] save = SerializeUtil.serizlize(i);
			jedis.rpush("UserVO".getBytes(), save);
		}
	}
	
	private void init()
	{
		jedis = new Jedis("localhost", 6379);
	}
}
