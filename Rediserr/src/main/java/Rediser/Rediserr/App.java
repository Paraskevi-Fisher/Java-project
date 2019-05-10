package Rediser.Rediserr;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONWriter;

import com.UserDao.SerializeUtil;
import com.UserDao.UserDao;
import com.UserDao.UserDaoImpl;
import com.UserDao.UserVO;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	UserVO student1 = new UserVO();
    	student1.setUserId("1");
    	student1.setPassWord("123456");
    	student1.setUserName("张三");
    	
    	UserVO student2 = new UserVO();
    	student2.setUserId("2");
    	student2.setPassWord("654321");
    	student2.setUserName("李四");
    	
    	UserDao ud = new UserDaoImpl();
    	ud.insert(student1);
    	List<UserVO>list = ud.queryAll();
    	System.out.println(list);
    	
    	ud.insert(student2);
    	list = ud.queryAll();
    	System.out.println(list);
    	
    	
    	UserVO l = ud.queryById("1");
    	System.out.println(l);
    	
    	
    	list = ud.queryByName("李四");
    	System.out.println(list);
    	
    	ud.delete(student2);
    	list = ud.queryAll();
    	System.out.println(list);
    	
    	
    }
}
