package dao;

import pojo.User;

public interface LoginDao {
	User checkLoginDao(String uname,String pwd);
	User checkUidUserDao (String uid);
	int userChangePwdDao(String newPwd, int uid);
}
