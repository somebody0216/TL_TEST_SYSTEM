package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class jdbc_util {
    private  static String url;
    private  static String user;
    private  static String password;
    public static Connection conn=null;
    public static PreparedStatement pstmt = null;
//    public static Statement stmt;
    //获取连接

    public static Connection getConnection(){
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //读取properties文件 获取用户信息
            InputStream is = jdbc_util.class.getClassLoader().getResourceAsStream("info.properties");
            // 实例化properties对象 调用load方法读取键值对
            Properties proper = new Properties();
            proper.load(is);
            //读取
            url=proper.getProperty("url");
            user=proper.getProperty("user");
            password=proper.getProperty("password");
             conn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
        return  conn;
    }

    //获取执行
//    public static Statement getStatement(){
//
//        try {
//            stmt = conn.createStatement();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return stmt;
//    }


    //获取预处理对象（执行、验证语法功能）
    public static PreparedStatement getPreparedStatement(String sql){

        try {
            pstmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstmt;

    }





    //关闭
    public static void close(){
        if(pstmt!=null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
