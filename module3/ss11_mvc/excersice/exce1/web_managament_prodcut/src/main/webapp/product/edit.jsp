<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/5/2022
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Trang Chỉnh sửa</h1>
<a href="/product">Quay lại list</a>
<c:if test="${mess!=null}">
    <span style="color: red">${mess}</span>
</c:if>
<form action="product?action=edit&id=${product.getId()}" method="post">
<%--    <pre><input type="text" name="enterId" value="Edit product" placeholder="enter id"></pre>--%>
<%--    <pre>ID :              <input type="text" name="id" id="id"></pre>--%>
    <pre>Name :            <input type="text" name="name" id="name" ></pre>
    <pre>Price :           <input type="text" name="price" id="price" ></pre>
    <pre>Product Detail :  <input type="text" name="productDetail" id="productDetail" ></pre>
    <pre>Producer :        <input type="text" name="producer" id="producer" ></pre>
    <pre>                  <button>Save</button></pre>
</form>
</body>
</html>
