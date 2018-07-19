<%-- 
    Document   : teste
    Created on : Jun 15, 2018, 8:39:38 AM
    Author     : marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
    <%
        response.addHeader("Content-Type", "text/html; charset=utf-8");
        response.setCharacterEncoding("UTF-8");
    %>
    
</html>
