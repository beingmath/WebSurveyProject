import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test1 {
	private static final String URL = "jdbc:mysql://localhost/db_admin?useUnicode=true&characterEncoding=utf8";
	private static final String username = "root";
	private static final String PWD = "root";
	static Connection connection = null;
	static PreparedStatement pStatement = null;
 	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(URL, username, PWD);
		Pideal();
		/*
		String sql = "select * from Student where name LIKE '%方%'";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		System.out.println(prepareStatement);
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			int sno = rs.getInt("sno");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			System.out.println("学号：" + sno + "姓名：" + name + "   年龄：" + age);
		}
		*/
	}

	public static void Pideal() throws Exception{
		String sql = "REPLACE into student(sno,name,age) values(?,?,?)";
			pStatement = connection.prepareStatement(sql);
		for (int i = 15; i < 40; i++) {
				pStatement.setInt(1,i);
			pStatement.setString(2, "PLO" + i);
			pStatement.setInt(3,i+2);
			pStatement.addBatch(); 
				pStatement.executeBatch();
				pStatement.clearBatch();
		}
		System.out.println("完毕");
	}
}
