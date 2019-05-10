package Service;

import org.apache.log4j.Logger;

import dao.LoginDao;
import dao.impl.LoginDaoImpl;
import pojo.User;

public class LoginServiceImpl implements LoginService{

	@Override
	public User checkLoginService(String uname, String pwd) {
		Logger logger = Logger.getLogger(LoginServiceImpl.class);
		LoginDao ld =new LoginDaoImpl();
		logger.debug(uname+"�����½����");
		User result = ld.checkLoginDao(uname, pwd);
		if (result!=null) logger.debug(uname+"��½�ɹ�");
		else logger.debug(uname+"��¼ʧ��");
		return result;
	}

	@Override
	public User checkUidUser(String id) {
		LoginDao ld = new LoginDaoImpl();
		User result = ld.checkUidUserDao(id);
		return result;
	}

	@Override
	public int userChangePwdService(String newPwd, int uid) {
		LoginDao ld = new LoginDaoImpl();
		return ld.userChangePwdDao(newPwd,uid);
	}
	
	
}
