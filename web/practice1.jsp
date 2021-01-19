<%@ page import="java.util.ArrayList" %>
<%@ page import="pojo.practice14" %><%--
  Created by IntelliJ IDEA.
  User: Melo
  Date: 2020/12/14
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%
    if(request.getAttribute("data")==null){
        request.getRequestDispatcher("Servlet_practice14").forward(request,response);
    }else {
       request.getAttribute("data");
    }


%>
<a href="add_practice14.jsp">添加</a>
<table cellspacing="0" cellpadding="1">
    <tr><td>姓名</td>
        <td>年龄</td>
        <td>密码</td>
        <td>操作</td>
    </tr>

    <%
        for(practice14 p:(ArrayList<practice14>)request.getAttribute("data")){

        }
    %>
</table>


</body>
</html>
