<%--
  Created by IntelliJ IDEA.
  User: 007
  Date: 2018/1/20
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <br><br>
    <table>

        <tr>
            <tb>您的购物车为空</tb>
        </tr>
        <tr>
            <br>
            <br>
            <td colspan="4">
                <a href="bookServlet?method=toBooks&pageNo=${param.pageNo}&minPrice=${param.minPrice}&maxPrice=${param.maxPrice}">继续购物</a>
            </td>
        </tr>
    </table>
</center>
</body>
</html>
