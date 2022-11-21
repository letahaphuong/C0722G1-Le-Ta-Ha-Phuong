<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/18/2022
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/to-usd" method="post">
    <label>
        <span>VND</span><input type="text" value="vnd" name="vnd">
    </label>
    <input type="submit" value="To USD">
</form>
<form action="/to-vnd" method="post">
    <label>
        <span>USD</span><input type="text" value="vnd" name="usd">
    </label>
    <input type="submit" value="To VND">
</form>
<h1>${result}</h1>

</body>
</html>
