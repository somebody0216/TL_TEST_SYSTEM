package controller;

import com.alibaba.fastjson.JSON;
import service.tlService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(value = "/Servlet")
public class Servlet extends HttpServlet {
    tlService us= new tlService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,Object> params = new HashMap<String,Object>();
        String paramString = readJSONString(request) ;
//        System.out.println(paramString);
        Map<String,Object> map = JSON.parseObject(paramString, Map.class);
//        System.out.println(u);
        String mark = (String) map.get("mark");
        switch (mark){
            case "accTest":
                if(us.userid_test((String) map.get("userid"))==false){
                    params.put("mark1",1);
                }else {
                    params.put("mark1",0);
                }
                break;
            case "submit":
                if(us.userid_test((String) map.get("userid"))==false&&us.addUser((String) map.get("userid"),(String) map.get("phone"),(String) map.get("email"),(String) map.get("password"))==true){
                    params.put("mark2",1);
                }else {
                    params.put("mark2",0);
                }
                break;
            case "login":
                if(us.userid_test((String) map.get("userid"))&&us.loginTest((String) map.get("password"),(String) map.get("userid"))){
                    params.put("mark3",1);
                }else {
                    params.put("mark3",0);
                }
                break;
        }

        String result=JSON.toJSONString(params);
        response.setContentType("application/json");
        PrintWriter pw = response.getWriter();
        pw.write(result);
        pw.flush();
        pw.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    public String readJSONString(HttpServletRequest request){
        StringBuffer json=new StringBuffer();
        String line=null;
        BufferedReader reader = null;
        try {
            reader = request.getReader();
            while((line=reader.readLine())!=null){
                json.append(line);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return json.toString();
    }
}
