<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kasia
  Date: 19.05.2019
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>REGISTRATION FORM</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>"/>
</head>
<body>
<h1>WELCOME TO THE REGISTRATION</h1>
    <sf:form method="POST" modelAttribute="user">
        <sf:input path="userName"/> <sf:errors path="userName" cssClass="error"/>
        Username: <input type="text" name="userName"/><br>
        Password: <input type="password" name="password"/><br>
        Mail: <input type="text" name="mail"/><br>
        <input type="submit" name="Register"/><br>
    </sf:form>
</body>
</html>
