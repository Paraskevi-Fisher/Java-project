package dao;

import java.util.List;

import pojo.flower;

public class Main {
	public static void main(String[] args){
		FlowerDao fd = new FlowerDaoImpl();
		List<flower>sss = fd.selAll(); 
		for (int i = 0;i < sss.size(); i++)
		{
			System.out.println(sss.get(i));
		}
	}
}
