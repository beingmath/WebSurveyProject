package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Option;
import pojo.Question;

public class QuestionBase {
	private static final String URL = "jdbc:mysql://localhost/db_admin?useUnicode=true&characterEncoding=utf8";
	private static final String username = "root";
	private static final String PWD = "root";
	static Connection connection = null;
	static PreparedStatement pStatement = null;
	public static Connection ConnectionDatabase() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return connection = DriverManager.getConnection(URL, username, PWD);
}
	public static void  inserQuestion(Question que) throws SQLException, ClassNotFoundException {
		connection = ConnectionDatabase();
		String sql = "insert into question(question,type,A,B,C,D,task) values(?,?,?,?,?,?,?)";
		pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, que.getPro());
		pStatement.setInt(2, que.getType());
		pStatement.setString(3, que.getA());
		pStatement.setString(4, que.getB());
		pStatement.setString(5, que.getC());
		pStatement.setString(6, que.getD());
		pStatement.setString(7, que.getTask());
		pStatement.executeUpdate();
		pStatement.close();
		connection.close();
		
	}
	public static List<Question> SelectAllquestion() throws SQLException, ClassNotFoundException {
		connection = ConnectionDatabase();
		List<Question> questions=new ArrayList<>();
		String sql = "select * from question";
		pStatement = connection.prepareStatement(sql);
		pStatement=connection.prepareStatement(sql);
		ResultSet rSet = pStatement.executeQuery();
		while(rSet.next()) {
			    int id=rSet.getInt("id");
			    String  question=rSet.getString("question");
				int type=rSet.getInt("type");
				String A=rSet.getString("A");
				String B=rSet.getString("B");
				String C=rSet.getString("C");
				String D=rSet.getString("D");
				String task=rSet.getString("task");
				Question que=new Question(id,question,type,A,B,C,D,task);
				questions.add(que);
			    		}
			return questions;
	}
	//通过task查询问题
	public static List<Question> SelectByTask(String task) throws SQLException, ClassNotFoundException {
		connection = ConnectionDatabase();
		List<Question> questions=new ArrayList<>();
		String sql = "select * from question where task=?";
		pStatement=connection.prepareStatement(sql);
		pStatement.setString(1,task);
		ResultSet rSet = pStatement.executeQuery();
		while(rSet.next()) {
			    int id=rSet.getInt("id");
			    String  question=rSet.getString("question");
				int type=rSet.getInt("type");
				String A=rSet.getString("A");
				String B=rSet.getString("B");
				String C=rSet.getString("C");
				String D=rSet.getString("D");
				String task1=rSet.getString("task");
				Question que=new Question(id,question,type,A,B,C,D,task1);
				questions.add(que);
			    		}
		pStatement.close();
		connection.close();
			return questions;
	}
	//通过task查询问题
		public static Option SelectByQuestion(String question) throws SQLException, ClassNotFoundException {
			connection = ConnectionDatabase();
			Option op=new Option();
			String sql = "select * from question where question=?";
			pStatement=connection.prepareStatement(sql);
			pStatement.setString(1,question);
			ResultSet rSet = pStatement.executeQuery();
			while(rSet.next()) {
				    int id=rSet.getInt("id");
					String A=rSet.getString("A");
					String B=rSet.getString("B");
					String C=rSet.getString("C");
					String D=rSet.getString("D");
					op=new Option(A,B,C,D);
				    		}
			pStatement.close();
			connection.close();
				return op;
		}
}