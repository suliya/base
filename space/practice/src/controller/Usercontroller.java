package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;
import dao.Usermapper;

public class Usercontroller {
      public void loginin(User user) {
    	  ResultSet rSet=null;
    	  Usermapper usermapper=new Usermapper();
    	  rSet=usermapper.loginin(user);
    	  if(rSet!=null){
    		  try {
				while(rSet.next()){
					if("T".equals(rSet.getString("Index"))){
						System.out.println("欢迎"+rSet.getString("UserName")+"老师登录成功");
					}else if ("S".equals(rSet.getString("Index"))) {
						System.out.println("欢迎"+rSet.getString("UserName")+"学生登录成功");
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		  
    	  }else{
    		  System.out.println("用户名或密码错误,请重新输入");
    	  }
    	  
		
	}
      public static void main(String[] args) {
		Usercontroller usercontroller=new Usercontroller();
		User usert=new User("123","123");
		User users=new User("suliya","suliya");
		usercontroller.loginin(usert);
		usercontroller.loginin(users);
	}
}
