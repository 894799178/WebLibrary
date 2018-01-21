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
    <script type="text/javascript" src="scripts/jquery-3.2.1.js"></script>
    <script type="text/javascript">
        $(function(){
            $(".delete").click(function(){
                var $tr = $(this).parent().parent();
                var title = $.trim($tr.find("td:first").text());
                var flag = confirm("确定要删除"+title+"的信息?");
                if(flag){
                    return true;
                }
                return false;
            });
            //ajax修改单个商品的数量
            $(":text").change(function(){
                var tr = $(this).parent().parent();
                var title = $.trim(tr.find("td:first").text());
                var url = "bookServlet";
                var idVal = $.trim(this.name);
                var quantityVal = $.trim(this.value);
                if(quantityVal == 0){
                    var flag = confirm("确定要从购物车中删除"+title+"这本书吗?");
                    if(!flag){
                        return ;
                    }else{
                        var href = tr.find("td:last").find("a").attr("href");
                        window.location.href = href;
                        return;
                    }

                }else if(quantityVal < 0){
                    alert("你输入的值错误!");
                    return;
                }else{
                    var flag = confirm("确定要修改"+title+"的数量吗?");
                    if(!flag){
                        return ;
                    }
                }
                var args ={"method":"updateItemQuantity","id":idVal,"quantity":quantityVal,"time":new Date()};
                $.post(url,args,function(data){
                    var bookNumber = data.bookNumber;
                    var totalMoney = data.totalMoney;
                    alert(bookNumber);
                    alert(totalMoney);
                    $("#totalMoney").text("总金额:"+totalMoney);
                    $("#bookNumber").text("您的购物车中有"+bookNumber+"本书");
                },"JSON")


            })
        })
    </script>
</head>
<body>
        <center>
            <br><br>
        <dir id="bookNumber">您的购物车中有${sessionScope.ShoppingCart.bookNumber}本书</dir>
            <table>

            <tr>
                <td>书名</td>
                <td>数量</td>
                <td>价格</td>
                <td>&nbsp;</td>
            </tr>
            <c:forEach items="${sessionScope.ShoppingCart.items}" var="item">
                <tr>
                      <td>${item.book.title}</td>
                      <td><input type="text" size="1" name="${item.book.bookId}" value ="${item.quantity}"></td>
                      <td>${item.book.price}</td>
                      <td><a href="bookServlet?method=remove&pageNo=${param.pageNo}&id=${item.book.bookId}" class ="delete">删除</a> </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="4" id="totalMoney">总金额:${sessionScope.ShoppingCart.totalMoney}</td>
            </tr>
            <tr>
                <td colspan="4">
                    <a href="bookServlet?method=toBooks&pageNo=${param.pageNo}&minPrice=${param.minPrice}&maxPrice=${param.maxPrice}">继续购物</a>
                     &nbsp;
                    <a href="bookServlet?method=emptyCart&pageNo=${param.pageNo}&minPrice=${param.minPrice}&maxPrice=${param.maxPrice}">清空购物车</a>
                    &nbsp;
                    <a href="">结账</a>
                    &nbsp;
                </td>
            </tr>
        </table>


        </center>
</body>
</html>
