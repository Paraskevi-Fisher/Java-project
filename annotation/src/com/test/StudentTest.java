package com.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StudentTest {
	@SuppressWarnings("all")
	public static void main(String[] args) throws Exception {
		String path = "com.test.Student";
		Class<Student> clazz = (Class<Student>) Class.forName(path);
		
		Constructor<Student> c =  clazz.getDeclaredConstructor(null);
		Student s = c.newInstance();
		s.setAge(2);
		System.out.println(s.getAge());
		
		Field xiaoF = clazz.getDeclaredField("age");
		xiaoF.setAccessible(true);//������Բ���Ҫ����ȫ��飬����ֱ�ӷ���
		xiaoF.set(s, 3);
		System.out.println(s.getAge());
	}
}
