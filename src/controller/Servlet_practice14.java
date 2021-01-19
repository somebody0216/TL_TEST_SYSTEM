package controller;

import dao.practice14_dao;
import dao.tldao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(value = "/Servlet_practice14")
public class Servlet_practice14 extends HttpServlet {
    practice14_dao td= new practice14_dao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String age=request.getParameter("age");
        String pwd=request.getParameter("pwd");
        td.addinfo(username,age,pwd);
        request.setAttribute("data",td.getInfo());
        request.getRequestDispatcher("practice1.jsp").forward(request,response);
    }

//    public String readJSONString(HttpServletRequest request){
//        StringBuffer json=new StringBuffer();
//        String line=null;
//        BufferedReader reader = null;
//        try {
//            reader = request.getReader();
//            while((line=reader.readLine())!=null){
//                json.append(line);
//            }
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
//        return json.toString();
//    }
}
