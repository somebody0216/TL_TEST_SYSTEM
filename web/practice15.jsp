<%@ page import="pojo.practice15" %><%--
  Created by IntelliJ IDEA.
  User: Melo
  Date: 2020/12/15
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
     practice15 p=new practice15();
     pageContext.setAttribute("p2",p);


%>

${p2.name}
</body>
</html>
