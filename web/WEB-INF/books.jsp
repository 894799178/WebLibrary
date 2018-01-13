<%--
  Created by IntelliJ IDEA.
  User: 007
  Date: 2018/1/13
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <center><br><br>
            <form action="bookServlet?method=getBooks" method="post">
                price:
                <input type = "text" size="1" name = "minPrice"/> +
                <input type = "text" size="1" name = "maxPrice"/>
                <input type ="submit" value = "submit"/>
            </form>
            <br><br>
            <table cellpadding="10">
                <c:forEach items = "${bookPage.list}" var="book">
                    <tr>
                        <td>
                            <a href = "">${book.title}</a>
                            <br>
`                              ${book.auyhor}
                        </td>
                        <td>${book.price}</td>
                        <td><a href="">加入购物车</a></td>
                    </tr>

                </c:forEach>
            </table>
            <<br><br>
            共${bookPage.totalPageNumber}页
            &nbsp;&nbsp;
            当前第${bookPage.pageNo}页
            &nbsp;&nbsp;
            <c:if test="${bookPage.hasPrev}">
                <a href="bookServlet?method=getBooks&pageNo=1">首页</a>
                &nbsp;&nbsp;
                <a href="bookServlet?method=getBooks&pageNo=${bookPage.prevPage}">上一页</a>
            </c:if>
            &nbsp;&nbsp;
            <c:if test="${bookPage.hasNext}">

                <a href="bookServlet?method=getBooks&pageNo=${bookPage.nextPage}">下一页</a>
                &nbsp;&nbsp;
                <a href="bookServlet?method=getBooks&pageNo=${bookPage.totalPageNumber}">末页</a>
            </c:if>
        </center>
</body>
</html>
