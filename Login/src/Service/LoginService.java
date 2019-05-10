package Service;

import pojo.User;

public interface LoginService {
	User checkLoginService(String uname,String pwd);
	User checkUidUser(String id);
}
