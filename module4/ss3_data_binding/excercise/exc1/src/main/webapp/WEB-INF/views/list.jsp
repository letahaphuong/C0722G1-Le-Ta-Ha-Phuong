<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/22/2022
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Kết Quả</h3>
<h4>Languages: ${email.getLanguages()}</h4>
<h4>Page Size: ${email.getPageSize()}</h4>
<h4>Spam Filter: ${email.getSpamsFilter()}</h4>
<h4>Signature: ${email.getSignature()}</h4>
</body>
</html>
