package dao;

import pojo.classify;
import pojo.test;
import util.jdbc_util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class tldao {
//    得到数据库中的userid
    public ArrayList<String> getUserId(){
        ArrayList<String> al=new ArrayList<String>();
        jdbc_util.getConnection();
        String sql="select userid from user";
        PreparedStatement pstmt = jdbc_util.getPreparedStatement(sql);
        try {
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String userid=rs.getString(1);
                al.add(userid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return al;
    }
//向数据库中添加user注册用户

    public void plusUser(String userid,String phone,String email,String password){
        jdbc_util.getConnection();
        String sql="insert into  user values(?,?,?,?,?)";
        PreparedStatement pstmt = jdbc_util.getPreparedStatement(sql);
        try {
            pstmt.setString(1, UUID.randomUUID().toString());
            pstmt.setString(2,userid);
            pstmt.setString(3,phone);
            pstmt.setString(4,email);
            pstmt.setString(5,password);
            int i = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


//    验证账号密码
    public String getPassword(String userid){
        String password="";
        jdbc_util.getConnection();
        String sql="select password from user where userid=?";
        PreparedStatement pstmt = jdbc_util.getPreparedStatement(sql);
        try {
            pstmt.setString(1,userid);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                password = rs.getString(1);
            }

            jdbc_util.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return password;
    }



//获取分类信息
    public ArrayList<classify> getClassifyInfo(){
        ArrayList<classify> al=new ArrayList<classify>();
        jdbc_util.getConnection();
        String sql="select c_id,c_name from e_classify where is_delete=0";
        PreparedStatement pstmt = jdbc_util.getPreparedStatement(sql);
        try {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                al.add(new classify(rs.getString(1),rs.getString(2)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return al;
    }

//    添加分类信息
    public void addClassifyInfo(String c_id,String c_name){
        jdbc_util.getConnection();
        String sql="insert into e_classify values(?,?,0)";
        PreparedStatement pstmt = jdbc_util.getPreparedStatement(sql);
        try {
            pstmt.setString(1,c_id);
            pstmt.setString(2,c_name);
            pstmt.execute();
            jdbc_util.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


//添加题目信息
    public void addTestInfo(String ID ,String t_topic, String t_answer, int t_score,int t_type,String c_id){
        jdbc_util.getConnection();
        String sql="insert into e_test values(?,?,?,?,?,?,now(),0)";
        PreparedStatement pstmt = jdbc_util.getPreparedStatement(sql);
        try {
            pstmt.setString(1,ID);
            pstmt.setString(2,t_topic);
            pstmt.setString(3,t_answer);
            pstmt.setInt(4,t_score);
            pstmt.setInt(5,t_type);
            pstmt.setString(6,c_id);
            pstmt.execute();
            jdbc_util.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

//    添加单选选项信息
    public void addChoicesInfo(String ID,String A, String B, String C, String D){
        jdbc_util.getConnection();
        String sql="insert into e_option values(?,?,?,?,?)";
        PreparedStatement pstmt = jdbc_util.getPreparedStatement(sql);
        try {
            pstmt.setString(1,ID);
            pstmt.setString(2,A);
            pstmt.setString(3,B);
            pstmt.setString(4,C);
            pstmt.setString(5,D);
            pstmt.execute();
            jdbc_util.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    删除单条分类信息
    public void delClassifyInfo(String uuid){
        jdbc_util.getConnection();
        String sql="update e_classify set is_delete= 1 where c_id=?";
        PreparedStatement pstmt = jdbc_util.getPreparedStatement(sql);
        try {
            pstmt.setString(1,uuid);

            pstmt.execute();
            jdbc_util.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    删除单条题目信息
    public void delTestInfo(String t_topic){
        jdbc_util.getConnection();
        String sql="update e_test set is_delete=1 where t_topic=?";
        PreparedStatement pstmt = jdbc_util.getPreparedStatement(sql);
        try {
            pstmt.setString(1,t_topic);
            pstmt.execute();
            jdbc_util.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    修改分类名称信息、
    public void changeClassifyInfo(String newvalue,String oldvalue){
        jdbc_util.getConnection();
        String sql="update e_classify set c_name=? where c_name=?";
        PreparedStatement pstmt = jdbc_util.getPreparedStatement(sql);
        try {
            pstmt.setString(1,newvalue);
            pstmt.setString(2,oldvalue);
            pstmt.execute();
            jdbc_util.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
//    得到题目信息
    public ArrayList<test> getTestInfo(){
        ArrayList<test> al=new ArrayList<test>();
        jdbc_util.getConnection();
        String sql="select t_type,c_id,t_topic,creat_time from e_test where is_delete=0 order by creat_time desc";
        PreparedStatement pstmt = jdbc_util.getPreparedStatement(sql);
        try {
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                al.add(new test(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return al;
    }
//修改题目信息
    public void changeTestInfo(String t_topic, String t_answer, int t_score,String c_id){
        jdbc_util.getConnection();
        String sql="update e_test set t_topic=?,t_answer=?,t_score=?,c_id=?,creat_time=?";
        PreparedStatement pstmt = jdbc_util.getPreparedStatement(sql);
        try {
            pstmt.setString(1,t_topic);
            pstmt.setString(1,t_answer);
            pstmt.setInt(1,t_score);
            pstmt.setString(1,c_id);
            pstmt.execute();
            jdbc_util.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    //    修改单选选项信息
    public void changeChoicesInfo(String a,String b, String c, String d,String t_id){
        jdbc_util.getConnection();
        String sql="update e_option set o_a=?,o_b=?,o_c=?,o_d=? where t_id=?";
        PreparedStatement pstmt = jdbc_util.getPreparedStatement(sql);
        try {
            pstmt.setString(1,a);
            pstmt.setString(2,b);
            pstmt.setString(3,c);
            pstmt.setString(4,d);
            pstmt.setString(5,t_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    查询选择题ID
    public String getChoicesIDInfo(String t_topic){
        String x="";
        jdbc_util.getConnection();
        String sql="select t_id from e_test where t_topic=?";
        PreparedStatement pstmt = jdbc_util.getPreparedStatement(sql);
        try {
            pstmt.setString(1,t_topic);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
               x= rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    return x;
    }

}
