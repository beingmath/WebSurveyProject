package service;

import pojo.User;

import java.sql.SQLException;

import base.UserBase;

public class UserService {
	//查询
   public static Boolean findUser(User user) throws ClassNotFoundException, SQLException {
	   Boolean isReg = UserBase.Selectuser(user);
	   return isReg;
   }
   //用户注册
   public static Boolean registerUser(User user) throws ClassNotFoundException, SQLException {
	   Boolean isReg = UserBase.SelectName(user);
	   //查询到了这个用户名
	   if(isReg) {
		   return false;
	   }else {
		   //没有查询到此用户名，可以注册
		   //把用户信息插入到表中
		   UserBase.insertUser(user);
		   return true;  
	   }
	   
   }
}
