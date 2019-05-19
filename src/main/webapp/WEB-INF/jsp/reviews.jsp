<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kasia
  Date: 18.05.2019
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reviews</title>


</head>
<body>
<h1>YOUR REVIEWS</h1>
<c:forEach items="${reviews}" var="reviewItem">
    <div class="reviewData">
        <c:out value="${reviewItem.content}"/>
    </div>
    <div>
    <span class="reviewPostedDate">
        <c:out value="${reviewItem.postedDate}" />
    </span>
    </div>
</c:forEach>
</body>
</html>
