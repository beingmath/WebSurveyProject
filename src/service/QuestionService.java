package service;

import java.sql.SQLException;
import java.util.List;

import base.QuestionBase;
import pojo.Option;
import pojo.Question;

public class QuestionService {
 public static void insertQuestion(Question que) throws ClassNotFoundException, SQLException {
	 QuestionBase.inserQuestion(que);
 }
 public static List<Question> SelectAllQuestion() throws ClassNotFoundException, SQLException {
	return QuestionBase.SelectAllquestion();
 }
 public static List<Question> SelectQuestionByTask(String task) throws ClassNotFoundException, SQLException{
	 List<Question> selectByTask = QuestionBase.SelectByTask(task);
	return selectByTask;
 }
 //通过问题查询选项
 public static Option SelectByQuestion(String question) throws ClassNotFoundException, SQLException {
         return	 QuestionBase.SelectByQuestion(question);
 }
}
