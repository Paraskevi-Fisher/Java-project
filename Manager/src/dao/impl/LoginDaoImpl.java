package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.User;
import dao.LoginDao;

public class LoginDaoImpl implements LoginDao{

	@Override
	public User checkLoginDao(String uname, String pwd) {
		// 创建Jdbc对象
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		User u = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/407","root","123456");
			
			String sql = "select * from t_user where uname=? and pwd=?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			rs=ps.executeQuery();
			while(rs.next())
			{
				u=new User();
				u.setUid(rs.getInt("uid"));
				u.setPwd(rs.getString("pwd"));
				u.setUname(rs.getString("uname"));
				u.setAge(rs.getInt("age"));
				u.setSex(rs.getString("sex"));
				u.setBirth(rs.getString("birth"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return u;
	}
	public User checkUidUserDao (String uid)
	{
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		User u = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/407","root","123456");
			
			String sql = "select * from t_user where uid=?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			rs=ps.executeQuery();
			while(rs.next())
			{
				u=new User();
				u.setUid(rs.getInt("uid"));
				u.setPwd(rs.getString("pwd"));
				u.setUname(rs.getString("uname"));
				u.setAge(rs.getInt("age"));
				u.setSex(rs.getString("sex"));
				u.setBirth(rs.getString("birth"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return u;
	}
	@Override
	public int userChangePwdDao(String newPwd, int uid) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps = null;
		int index=-1;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/407","root","123456");
			
			String sql = "update t_user set pwd=? where uid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, newPwd);
			ps.setInt(2, uid);
			index = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return index;
	}
}
