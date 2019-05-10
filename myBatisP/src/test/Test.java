package test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.Mapper.StudentMapper;
import com.Service.StudentService;
import com.Service.StudentServiceImpl;
import com.pojo.PageInfo;
import com.pojo.Student;
import com.util.MyBatisUtil;

public class Test {
	
	public static void main(String[] args)throws Exception
	{
		PageInfo pi = new PageInfo();
		InputStream is = Resources.getResourceAsStream("Mybatis.xml");
		SqlSessionFactory factory =  new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession(false);
		StudentMapper sm = session.getMapper(StudentMapper.class);
		//pi.setSname("3");
		pi.setTname("2");
		List<Student>list = sm.selByPage(pi);
		
		for (Student s : list)
		{
			System.out.println(s);
		}
		
		StudentService studentService = new StudentServiceImpl();
		
		PageInfo pi2 = studentService.showPage("¹þ", "1", 5, 1);
		System.out.println(pi2);
	}
}
