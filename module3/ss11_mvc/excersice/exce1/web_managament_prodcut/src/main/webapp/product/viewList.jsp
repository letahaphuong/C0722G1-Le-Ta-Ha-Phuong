<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/4/2022
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <h1>Trang danh sách sản phẩm</h1>
    <a href="/product?action=add">Thêm mới</a>
    <table class="table table-dark">
        <tr>
<%--            <th>STT</th>--%>
<%--            <th>ID</th>--%>
            <th>Name</th>
            <th>Price</th>
            <th>Product Detail</th>
            <th>Producer</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="product" items="${productList}" varStatus="status">
            <tr>
<%--                <td>${status.count}</td>--%>
<%--                <td>${product.getId()}</td>--%>
                <td>${product.getName()}</td>
                <td>${product.getPrice()}</td>
                <td>${product.getProductDetail()}</td>
                <td>${product.getProducer()}</td>
                <td>
                    <button class="btn btn-success" onclick="location.href='/product?action=edit';">Edit</button>
                <td><button class="btn btn-danger"> Delete</button></td>
            </tr>

        </c:forEach>
    </table>
</body>
</html>
