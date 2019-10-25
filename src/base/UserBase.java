package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import pojo.User;

public class UserBase {

	private static final String URL = "jdbc:mysql://localhost/db_admin?useUnicode=true&characterEncoding=utf8";
	private static final String username = "root";
	private static final String PWD = "root";
	static Connection connection = null;
	static PreparedStatement pStatement = null;

	public static Connection ConnectionDatabase() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return connection = DriverManager.getConnection(URL, username, PWD);

	}

//添加一个用户
	public static Boolean insertUser(User user) throws ClassNotFoundException, SQLException {
		connection = ConnectionDatabase();
		String sql = "insert into user values(?,?,?)";
		pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, user.getName());
		pStatement.setString(2, user.getPwd());
		pStatement.setString(3, user.getRole());
		int count = pStatement.executeUpdate();
		if (count > 0) {
			pStatement.close();
			connection.close();
			return true;
		} else {
			pStatement.close();
			connection.close();
			return false;
		}
	}
//查询用户

	public static Boolean Selectuser(User user) throws ClassNotFoundException, SQLException {
		connection = ConnectionDatabase();
		String sql = "select * from user where name=? and pwd=? and role=?";
		pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, user.getName());
		pStatement.setString(2, user.getPwd());
		pStatement.setString(3, user.getRole());
		ResultSet rSet = pStatement.executeQuery();
		if(rSet.next()) {
			return true;
		}
		pStatement.close();
		connection.close();
		return false;

	}
	//查询用户名是否存在
	public static Boolean SelectName(User user) throws ClassNotFoundException, SQLException {
		connection = ConnectionDatabase();
		String sql = "select * from user where name=?";
		pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, user.getName());
		ResultSet rSet = pStatement.executeQuery();
		if(rSet.next()) {
			return true;
		}
		pStatement.close();
		connection.close();
		return false;

	}
}
/*
	// 查询所有学生
	public static List<User> SelectAll() throws ClassNotFoundException, SQLException {
		List<User> students=new ArrayList<>();
		User student=new User();
		connection = ConnectionDatabase();
		String sql="select * from student";
		pStatement=connection.prepareStatement(sql);
		ResultSet rSet = pStatement.executeQuery();
		while(rSet.next()) {
		 int sno=	rSet.getInt(1);
			String name=rSet.getString(2);
			int age=rSet.getInt(3);
			student=new User(sno,name,age);
					students.add(student);	
					
			
		    		}
		return students;
	}

	// 删除某一行的数据
	public static Boolean DeleteBySno(int sno) throws ClassNotFoundException, SQLException {
		connection = ConnectionDatabase();
		String sql = "delete from user where sno=?";
		pStatement = connection.prepareStatement(sql);
		pStatement.setInt(1, sno);
		int executeUpdate = pStatement.executeUpdate();
		if (executeUpdate > 0) {
			pStatement.close();
			connection.close();
			return true;

		} else {
			pStatement.close();
			connection.close();
			return false;
		}
	}

	// 修改某条数据
	public static Boolean UpdataStudent(User stu) throws ClassNotFoundException, SQLException {
		connection = ConnectionDatabase();
		String sql = "update student set name=?,age=? where sno=?";
		pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, stu.getName());
		pStatement.setInt(2, stu.getAge());
		pStatement.setInt(3, stu.getSno());
		int count = pStatement.executeUpdate();
		if (count > 0) {
			pStatement.close();
			connection.close();
			return true;
		} else {
			pStatement.close();
			connection.close();
			return false;
		}

	}

}
	*/