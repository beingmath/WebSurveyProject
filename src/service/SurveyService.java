package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import base.SurveyBase;
import pojo.Survey;

public class SurveyService {

	public static void inserSurvey(Survey survey) throws ClassNotFoundException, SQLException {
	          SurveyBase.insertSurvey(survey);
	}
	public static List<Survey> SelectSurvey() throws ClassNotFoundException, SQLException {
		return SurveyBase.SelectSurvey();
	}
}
