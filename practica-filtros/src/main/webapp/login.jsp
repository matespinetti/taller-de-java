<%--
  Created by IntelliJ IDEA.
  User: mateospinetti
  Date: 06/09/2024
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title><%= request.getAttribute("login_page_title") %> </title>
</head>
<body>
    <h1><%= request.getAttribute("login_page_title") %></h1>
    <form method="post" action="/practica_filtros_war_exploded/login">
        <label for="username"><%= request.getAttribute("user_label")%></label>
        <input type="text" id="username" name="username" required/>
        <br/>
        <label for="password"><%= request.getAttribute("password_label")%></label>
        <input type="password" id="password" name="password" required/>
        <button type="submit"><%= request.getAttribute("login_button")%></button>
    </form>

</body>
</html>
