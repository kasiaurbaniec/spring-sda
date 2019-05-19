<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kasia
  Date: 19.05.2019
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<div class="reviewData">
 Name:   <c:out value="${userData.userName}"/>
</div>
<div>
    <span class="reviewPostedDate">
  Mail      <c:out value="${userData.mail}"/>
    </span>
</div>
</body>
</html>
