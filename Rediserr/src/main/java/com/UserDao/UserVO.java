package com.UserDao;

import java.awt.Image;
import java.io.Serializable;

public class UserVO  implements Serializable{

	
	private String userName;
	private String passWord;
	private String userId;
	private String birthday;
	
	public UserVO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public UserVO(String userName, String passWord, String userId) {
		this.userName = userName;
		this.passWord = passWord;
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}



	@Override
	public String toString() {
		return "UserVO [userName=" + userName + ", passWord=" + passWord
				+ ", userId=" + userId + "]";
	}
	
	@Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;//地址相等
        }

        if(obj == null){
            return false;//非空性：对于任意非空引用x，x.equals(null)应该返回false。
        }

        if(obj instanceof UserVO){
            UserVO other = (UserVO) obj;
            //需要比较的字段相等，则这两个对象相等
            if(this.userName.equals(other.getUserName()))
            {
                return true;
            }
        }
        return false;
	}
	
	private static final long serialVersionUID = 1L;
}
