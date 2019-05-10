package test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pojo.People;

public class test {
	public static void main(String[] args) throws Exception
	{
		InputStream is = Resources.getResourceAsStream("Mybatis.xml");
		SqlSessionFactory factory =  new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession(false);
		
		People np = new People();
		np.setAge(11);
		np.setName("ÕÅÈý");
		session.insert("com.Mapper.insert", np);
		session.commit();
		List<People>result = session.selectList("com.Mapper.selAll");
		for (People i : result)
		{
			System.out.println(i);
		}
		People p = session.selectOne("com.Mapper.selById",1);
		System.out.println(p);
		session.close();
	}
}
