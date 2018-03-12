package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 该类实现JDBC的封装，主要实现代码的重用
 * 核心是类的抽象过程（成员变量，成员方法），
 * 数据库的访问步骤：
 * （1）加载驱动，建立连接，创建语句对象（封装在构造方法中）
 * （2）对于insert，delete，update之类的操作，返回受影响的记录条数
 * 若>0，则表示操作成功，否则表示操作失败，需要实现一个方法
 * （3）对于select的操作，返回的是查询到的记录集，需要实现一个方法
 * （4）对数据库连接对象的关闭，以释放资源，如果资源不及时的释放，系统将会出现
 * “out of memory”的错误，导致系统奔溃
 * 
 */
public class DBManager {
    //成员变量
    private static Connection con;
    private static Statement stm;
    private ResultSet rs;



    //以下为封装的成员方法
    /*
     * 1.构造方法，实现加载驱动，建立连接，创建语句对象
	 */
    public static Statement  DbManager() {
        try {
            // 1.加载驱动
            String driverName = "com.mysql.jdbc.Driver"; // mysql
            // jdbc驱动描述符,实际上就是driver类在包中的完整路径
            Class.forName(driverName);

            // 2.建立与数据库的连接
            // 数据库连接字符串，一般使用统一资源定位符（url）的形式
            // 其中数据库名为salegui
            String url = "jdbc:mysql://127.0.0.1:3306/lastjavawork?useUnicode=true&characterEncoding=utf-8";

            String user = "root"; // 连接数据库时的用户
            // 连接数据库时的密码
            String password = "root123";
            con = DriverManager.getConnection(url, user, password);

            //3.创建语句对象
            stm = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return stm;

    }
    

    

}
