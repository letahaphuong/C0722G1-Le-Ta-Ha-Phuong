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
<form action="/calculate" method="post">
    <label>
        <span>Số thứ 1</span><input type="text" name="x">
        <select name="operator">
            <option selected>Chọn phép toán</option>
            <option value="addition">+</option>
            <option value="subtraction">-</option>
            <option value="multiplication">*</option>
            <option value="division">/</option>
        </select>
        <span>Số thứ 2</span><input type="text" name="y">
    </label>
    <button>Kết quả</button>

</form>

<h1>${result}</h1>

</body>
</html>
