package service;

import dao.tldao;
import pojo.classify;
import pojo.test;

import java.util.ArrayList;
import java.util.UUID;

public class tlService {
    tldao td=new tldao();

//    判断账号是否存在
    public  boolean  userid_test(String userid){
        boolean flag=false;
        for(String s:td.getUserId()){
            System.out.println(s);
            if(s.equals(userid)){
                flag=true;
               break;
            }
        }
        return flag;
    }

//    判断是否添加入库
    public boolean addUser(String userid,String phone,String email,String password){
        boolean flag=false;
        if(userid!=null&&phone!=null&&email!=null&&password!=null){
            td.plusUser(userid,phone,email,password);
            flag=true;
        }
        return flag;
    }

//    验证账号密码
    public boolean loginTest(String password,String userid){
        boolean flag=false;
        if(td.getPassword(userid).equals(password)){
             flag=true;
        }
        return flag;
    }

//得到数据库中Classify信息

    public ArrayList getClassify(){
        ArrayList<classify> al= new ArrayList<classify>();
        al=td.getClassifyInfo();
        return al;
    }

//向数据库中添加Classify信息
    public void  addClassify(String c_name){
                td.addClassifyInfo(UUID.randomUUID().toString(),c_name);

    }

//    删除单条Classify信息
    public void delClassify(String uuid){
        td.delClassifyInfo(uuid);
    }
//    删除单条题目信息
    public void delTest(String t_topic){
        td.delTestInfo(t_topic);
    }
//    修改Classoify信息
    public void changeClassify(String newvalue,String oldvalue){
        td.changeClassifyInfo(newvalue,oldvalue);
    }

//    添加题目信息
    public void addTest(String ID ,String t_topic, String t_answer, int t_score,int t_type,String c_id){
        td.addTestInfo(ID,t_topic,t_answer,t_score,t_type,c_id);
    }
// 添加单选选项信息
    public void addChoices(String ID,String A,String B,String C,String D){
        td.addChoicesInfo(ID,A,B,C,D);
    }
//   得到题目信息
    public ArrayList<test> getTest(){
        ArrayList<test> al=new ArrayList<test>();
        al=td.getTestInfo();
//        System.out.println(al);
//        System.out.println("2222222");
        return al;
    }
//    修改试题信息
    public void changeTest(String t_topic, String t_answer, int t_score,String c_id){
        td.changeTestInfo(t_topic,t_answer,t_score,c_id);
    }
//    得到选择题ID
    public String getChoicesID(String t_topic){
        return td.getChoicesIDInfo(t_topic);
    }
//    修改单选选项信息
    public void changeChoices(String a,String b, String c, String d,String t_id){
        td.changeChoicesInfo(a,b,c,d,t_id);
    }

}
