<%--
  Created by IntelliJ IDEA.
  User: 007
  Date: 2018/1/13
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
        <jsp:include page="hidden.jsp"></jsp:include>
        <center>
            <br>
            <br>
            书名:${book.title}<br>
            作者:${book.author}<br>
            单价:${book.price}<br>
            出版时间:${book.publicShingDate}<br>
            评论:${book.remark}<br>
            <a href = "bookServlet?method=getBooks&pageNo=${param.pageNo}&minPrice=${param.minPrice}&maxPrice=${param.maxPrice}" >继续购物emm</a>

        </center>
</body>
</html>
