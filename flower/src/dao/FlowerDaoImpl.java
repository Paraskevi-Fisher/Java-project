package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojo.flower;

public class FlowerDaoImpl implements FlowerDao{

	@Override
	public List<flower> selAll() {
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<flower> u = new ArrayList<flower>();
		try{
			System.out.println("great");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("great");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm","root","123456");
			System.out.println("great");
			String sql = "select * from flower";
			System.out.println("great");
			ps = conn.prepareStatement(sql);
			System.out.println("great");
			rs=ps.executeQuery();
			while(rs.next())
			{
				u.add(new flower(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("production")));
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
	
}
