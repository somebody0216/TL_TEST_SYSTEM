package dao;

import pojo.practice14;
import util.jdbc_util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class practice14_dao {


    public void addinfo(String name,String age,String pwd){
        jdbc_util.getConnection();
        String sql="insert into practice14 values(?,?,?);";
        PreparedStatement pstmt = jdbc_util.getPreparedStatement(sql);
        try {
            pstmt.setString(1,name);
            pstmt.setString(2,age);
            pstmt.setString(3,pwd);
            pstmt.execute();
            jdbc_util.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public ArrayList<practice14>  getInfo(){
        ArrayList<practice14> al=new ArrayList<practice14>();
        jdbc_util.getConnection();
        String sql="select name,age,password from practice14 where isdelete=0";
        PreparedStatement pstmt = jdbc_util.getPreparedStatement(sql);
        try {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                al.add(new practice14(rs.getString(1),rs.getString(2),rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return al;
    }
}
