package service;

import java.sql.SQLException;
import java.util.List;

import base.RecordBase;
import pojo.Record;

public class RecordService {
 public static void insertRecord(Record record) throws ClassNotFoundException, SQLException {
	 RecordBase.insertRecord(record);
 }
 public static List<Record> selectRecord() throws ClassNotFoundException, SQLException{
	return RecordBase.selectRecord();
 }
}
