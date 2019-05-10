package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pojo.People;

public class Test {
	public static void main(String[] args) throws Exception{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		People pe = ac.getBean("peo",People.class); 
		People pf = ac.getBean("peo",People.class); 

		System.out.println(pe);
		System.out.println(pf);
		String[] names = ac.getBeanDefinitionNames();
		for (String i:names)
		{
			System.out.println(i);
		}
	}
}
