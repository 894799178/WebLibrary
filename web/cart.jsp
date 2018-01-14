<%--
  Created by IntelliJ IDEA.
  User: 007
  Date: 2018/1/14
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <center>
        您的购物车中有${sessionScope.ShoppingCart.bookNumber}本书
        <br><br>
        <c:forEach items="${sessionScope.ShoppingCart.items}" var="item">
            ${item.book.title} -${item.book.price} - ${item.quantity}
            <br>
        </c:forEach>

        </center>
</body>
</html>
