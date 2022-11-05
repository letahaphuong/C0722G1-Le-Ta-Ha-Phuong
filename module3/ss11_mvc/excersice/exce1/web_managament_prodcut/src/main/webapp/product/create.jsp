<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/4/2022
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product management</title>
</head>
<body>
<h1>Trang thêm mới</h1>
<a href="/product">Quay lại list</a>
<c:if test="${mess!=null}">
    <span style="color: red">${mess}</span>
</c:if>
<form action="/product?action=add" method="post">
    <pre>ID :              <input type="text" name="id"></pre>
    <pre>Name :            <input type="text" name="name"></pre>
    <pre>Price :           <input type="text" name="price"></pre>
    <pre>Product Detail :  <input type="text" name="productDetail"></pre>
    <pre>Producer :        <input type="text" name="producer"></pre>
    <pre>                  <button>Save</button></pre>
</form>
</body>
</html>
