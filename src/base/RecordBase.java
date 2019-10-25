package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Question;
import pojo.Record;
import pojo.Survey;

public class RecordBase {
	private static final String URL = "jdbc:mysql://localhost/db_admin?useUnicode=true&characterEncoding=utf8";
	private static final String username = "root";
	private static final String PWD = "root";
	static Connection connection = null;
	static PreparedStatement pStatement = null;

	public static Connection ConnectionDatabase() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return connection = DriverManager.getConnection(URL, username, PWD);
	}
	//添加一个记录
//	private int id;
//	private String task;
//	private String pro;
//	private int type;
//	private String A;
//	private String B;
//	private String C;
//	private String D;
//	private String useroption;
//	private String username;
		public static Boolean insertRecord(Record record) throws ClassNotFoundException, SQLException {
			connection = ConnectionDatabase();
			String sql = "insert into record(task,pro,type,A,B,C,D,useroption,username) values(?,?,?,?,?,?,?,?,?)";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, record.getTask());
			pStatement.setString(2, record.getPro());
			pStatement.setInt(3, record.getType());
			pStatement.setString(4, record.getA());
			pStatement.setString(5, record.getB());
			pStatement.setString(6, record.getC());
			pStatement.setString(7, record.getD());
			pStatement.setString(8, record.getUseroption());
			pStatement.setString(9, record.getUsername());
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
		public static List<Record> selectRecord() throws ClassNotFoundException, SQLException{
			connection = ConnectionDatabase();
			List<Record> records=new ArrayList<>();
			String sql = "select * from record";
			pStatement = connection.prepareStatement(sql);
			pStatement=connection.prepareStatement(sql);
			ResultSet rSet = pStatement.executeQuery();
			while(rSet.next()) {
				    String  task=rSet.getString("task");
					String pro=rSet.getString("pro");
					int type=rSet.getInt("type");
					String A=rSet.getString("A");
					String B=rSet.getString("B");
					String C=rSet.getString("C");
					String D=rSet.getString("D");
					String useroption=rSet.getString("useroption");
					String username=rSet.getString("username");
					Record re=new Record(task,pro,type,A,B,C,D,useroption,username);
					records.add(re);
				    		}
				return records;
		}
}
