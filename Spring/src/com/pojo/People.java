package com.pojo;

import java.util.Arrays;

public class People {
	private int ID;
	private String name;
	int num[];
	public int[] getNum() {
		return num;
	}
	public void setNum(int[] num) {
		this.num = num;
	}
	public People() {
		System.out.println("People ����");
	}
	public People(int id,String name)
	{
		this.ID=id;
		this.name=name;
		System.out.println("People�в������캯��");
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("set����");
		this.name = name;
	}
	@Override
	public String toString() {
		return "People [ID=" + ID + ", name=" + name + ", num="
				+ Arrays.toString(num) + "]";
	}
	
}	
