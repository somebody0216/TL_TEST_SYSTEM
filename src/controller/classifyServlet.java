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
import java.util.UUID;

@WebServlet(value = "/classifyServlet")
public class classifyServlet extends HttpServlet {
    tlService ts= new tlService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String paraming=readJSONString(request);
        Map<String,Object> params=new HashMap<String,Object>();
        Map<String,Object> map = JSON.parseObject(paraming, Map.class);
        String mark = (String) map.get("mark");

        switch (mark){
            case "showClassify":
                params.put("mark1",ts.getClassify());
                break;
            case "plusClassify":
                params.put("mark2",1);
                params.put("UUID",UUID.randomUUID().toString());
                ts.addClassify((String) map.get("data"));

                break;
            case "delClassify":

                ts.delClassify((String) map.get("uuid"));
                break;
            case "changeClassify":
                ts.changeClassify((String) map.get("newvalue"),(String) map.get("oldvalue"));
            case "getClassifyName":
                params.put("mark3",ts.getClassify());
                break;
            case "getbox1":
                params.put("mark4",1);

                String id=UUID.randomUUID().toString();
                Map<String,Object> map2 = JSON.parseObject( map.get("data").toString(), Map.class);
                System.out.println(map2);
                ts.addTest(id,(String) map2.get("content"),(String) map2.get("rightAnswer"),(int) map2.get("score"),(int) map2.get("type"),(String) map2.get("classify"));
                ts.addChoices(id,(String) map2.get("A"),(String) map2.get("B"),(String) map2.get("C"),(String) map2.get("D"));
                break;
            case "getbox2":
                params.put("mark5",1);
                Map<String,Object> map3 = JSON.parseObject( map.get("data").toString(), Map.class);
                System.out.println(map3);
                ts.addTest(UUID.randomUUID().toString(),(String) map3.get("content"),(String) map3.get("rightAnswer"),(int) map3.get("score"),(int) map3.get("type"),(String) map3.get("classify"));
                break;
            case "showTest":
                params.put("mark5",ts.getTest());
                break;
            case "delTest":
//                System.out.println("mmmmmmmmmmmmmmmmmmmmmmmm");
//                System.out.println((String) map.get("content"));
                ts.delTest((String) map.get("content"));
                break;
            case "changebox1":
                params.put("mark6",1);
                Map<String,Object> map4 = JSON.parseObject( map.get("data").toString(), Map.class);
                ts.changeTest((String) map4.get("content"),(String) map4.get("rightanswer"),(int) map4.get("score"),(String) map4.get("classify"));
                ts.changeChoices((String) map4.get("A"),(String) map4.get("B"),(String) map4.get("C"),(String) map4.get("D"),ts.getChoicesID((String) map4.get("old_t_topic")));
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
