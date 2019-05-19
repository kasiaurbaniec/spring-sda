<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kasia
  Date: 19.05.2019
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Review</title>
</head>
<body>
<div class="reviewData">
    <c:out value="${review.content}"/>
</div>
<div>
    <span class="reviewPostedDate">
        <c:out value="${review.postedDate}"/>
    </span>
</div>
</body>
</html>
