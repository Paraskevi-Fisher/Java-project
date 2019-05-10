package Service;

import dao.LoginDao;
import dao.impl.LoginDaoImpl;
import pojo.User;

public class LoginServiceImpl implements LoginService{

	@Override
	public User checkLoginService(String uname, String pwd) {
		LoginDao ld =new LoginDaoImpl();
		User result = ld.checkLoginDao(uname, pwd);
		return result;
	}

	@Override
	public User checkUidUser(String id) {
		LoginDao ld = new LoginDaoImpl();
		User result = ld.checkUidUserDao(id);
		return result;
	}
	
	
}
