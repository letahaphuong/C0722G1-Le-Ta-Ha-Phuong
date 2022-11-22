<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/21/2022
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Submitted Employee Information</h2>
<a href="/a">Create</a>
<br>
<%--<tabel>--%>
<%--    <tr>--%>
<%--        <td>Name: </td>--%>
<%--        <td>${name}</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>ID: </td>--%>
<%--        <td>${id}</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>Contact Number: </td>--%>
<%--        <td>${contactNumber}</td>--%>
<%--    </tr>--%>
<%--</tabel>--%>
<tabel>
    <tr>
        <th>ID: </th>

        <th>Name: </th>
        <th>Contact Number: </th>
    </tr>

       <tr>
           <td>${employee.getId()}</td>
           <td>${employee.getName()}</td>
           <td>${employee.getContactNumber()}</td>
       </tr>

</tabel>
</body>
</html>
