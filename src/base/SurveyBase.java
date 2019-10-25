package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pojo.Survey;
import pojo.User;


public class SurveyBase {
	private static final String URL = "jdbc:mysql://localhost/db_admin?useUnicode=true&characterEncoding=utf8";
	private static final String username = "root";
	private static final String PWD = "root";
	static Connection connection = null;
	static PreparedStatement pStatement = null;

	public static Connection ConnectionDatabase() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return connection = DriverManager.getConnection(URL, username, PWD);

	}

//添加一个调查
	public static Boolean insertSurvey(Survey survey) throws ClassNotFoundException, SQLException {
		connection = ConnectionDatabase();
		String sql = "insert into survey(task,time,intro) values(?,?,?)";
		pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, survey.getTask());
		pStatement.setInt(2, survey.getTime());
		pStatement.setString(3, survey.getIntro());
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
//查询调查

	public static List<Survey> SelectSurvey() throws ClassNotFoundException, SQLException {
		connection = ConnectionDatabase();
		List<Survey> Surveys=new ArrayList<>();
		String sql = "select * from survey";
		pStatement = connection.prepareStatement(sql);
		pStatement=connection.prepareStatement(sql);
		ResultSet rSet = pStatement.executeQuery();
		Map map=new HashMap();
		while(rSet.next()) {
			int id=rSet.getInt("id");
			    int time=rSet.getInt("time");
				String task=rSet.getString("task");
				String intro=rSet.getString("intro");
				Survey survey=new Survey(id,task,time,intro);
				survey.setid(id);
				Surveys.add(survey);
			    		}
			return Surveys;

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
