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
    <script type="text/javascript" src="scripts/jquery-3.2.1.js"></script>
    <script type="text/javascript">
        $(function(){
            $("a").click(function(){
                var serializeVal = $(":hidden").serialize();
                var href = this.href + "&" + serializeVal;
                window.location.href = href;
                return false;

            })
            $("input[name = 'submit']").click(function(){
                var val = $("input[name = 'gotoNo']").val();
                var serializeVal = $(":hidden").serialize();
                var flag = false;
                var reg = /^\d+$/;
                if(reg.test(val)){
                    var pageNo = parseInt(val);
                    if(pageNo>=1 && pageNo <= parseInt("${bookPage.totalPageNumber}")){

                        flag = true;
                    }
                }
                if(!flag){
                    $("input[name = 'gotoNo']").val("");
                    val  = ${bookPage.pageNo}
                    alert("输入的页面不合法!");

                }
                var href = "bookServlet?pageNo="  + val+ "&"+ serializeVal;
                window.location.href = href;
                return false;
            })

        })
    </script>
</head>

<body>
<input type = "hidden" name ="minPrice"  value="${param.minPrice}"/>
<input type = "hidden" name ="maxPrice"  value="${param.maxPrice}"/>
        <center><br><br>
            <form action="bookServlet" method="post">
                price:
                <input type = "text" size="1" name = "minPrice"/> -
                <input type = "text" size="1" name = "maxPrice"/>
                <input type ="submit" value = "submit"/>
            </form>
            <br><br>
            <table cellpadding="10">
                <c:forEach items = "${bookPage.pageList}" var="book">
                    <tr>
                        <td>
                            <a href = "">${book.title}</a>
                            <br>
                              ${book.author}
                        </td>
                        <td>${book.price}</td>
                        <td><a href="">加入购物车</a></td>
                    </tr>

                </c:forEach>
            </table>
            <br><br>
            共${bookPage.totalPageNumber}页
            &nbsp;&nbsp;
            当前第${bookPage.pageNo}页
            &nbsp;&nbsp;
            <c:if test="${bookPage.hasPrev}">
                <a href="bookServlet?pageNo=1">首页</a>
                &nbsp;&nbsp;
                <a href="bookServlet?pageNo=${bookPage.pagePrev}">上一页</a>
            </c:if>
            &nbsp;&nbsp;
            <c:if test="${bookPage.hasNext}">
                <a href="bookServlet?pageNo=${bookPage.pageNext}">下一页</a>
                &nbsp;&nbsp;
                <a href="bookServlet?pageNo=${bookPage.totalPageNumber}">末页</a>
            </c:if>
            &nbsp;&nbsp;


            <form action="bookServlet" method="post">
                <input type="text" name ="gotoNo">
                <input type="submit" name = "submit" value="转到">
            </form>

        </center>
</body>
</html>
