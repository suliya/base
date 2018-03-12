package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.User;
import util.DBManager;

public class Usermapper {
	
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    
	public ResultSet loginin(User user) {
		stm=DBManager.DbManager();
		String strsql="select * from user where UserName="+"'"+user.getUsername()+"'"+
	             "and PassWord="+"'"+user.getPassword()+"'";
		System.out.println(user.getIndex());
		try {
			rs=stm.executeQuery(strsql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
		
	}
    /*
     * 2.对于insert，delete，update之类的操作,对于异常的出来，可以采取两种方式
     * （1）使用try，catch
     * （2)直接抛出，使用thows，即交给调用者进行处理
     
    public boolean executeUpdate(String sql) throws SQLException {
        boolean ret = false;
        int i = stm.executeUpdate(sql);
        if (i > 0) {
            ret = true;
        }
        return ret;
    }

    /*
     * 3.对于select的操作
     
    public ResultSet executeQuery(String sql) throws SQLException {
        rs = stm.executeQuery(sql);
        return rs;
    }

    /*
     * 4.资源的释放
     
    public void close() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
