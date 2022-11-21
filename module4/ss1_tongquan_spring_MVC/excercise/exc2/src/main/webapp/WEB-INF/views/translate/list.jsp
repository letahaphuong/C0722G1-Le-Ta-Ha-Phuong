<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/18/2022
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/search">
    <input type="text" name="text" placeholder="Nhập từ cần tra">
    <button type="submit">TÌm</button>
</form>
<p>${result}</p>
</body>
</html>
