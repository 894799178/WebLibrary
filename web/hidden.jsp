<%--
  Created by IntelliJ IDEA.
  User: 007
  Date: 2018/1/20
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<input type = "hidden" name ="minPrice"  value="${param.minPrice}"/>
<input type = "hidden" name ="maxPrice"  value="${param.maxPrice}"/>
<script type="text/javascript">
    $(function(){
        $("a").click(function(){
            var serializeVal = $(":hidden").serialize();
            var href = this.href + "&" + serializeVal;
            window.location.href = href;
            return false;
        })
    })
</script>