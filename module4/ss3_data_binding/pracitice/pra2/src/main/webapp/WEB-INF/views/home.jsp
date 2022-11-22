<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/21/2022
  Time: 7:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Home</h3>
<form:form method="post" action="login" modelAttribute="login">
    <fieldset>
        <legend>Login</legend>
        <table>
            <tr>
                <td><form:label path="account">Account: </form:label></td>
                <td><form:input path="account"/></td>
            </tr>
        </table>
        <table>
            <tr>
                <td><form:label path="password">Password: </form:label></td>
                <td><form:input path="password"/></td>
            </tr>
            <tr>
                <td></td>
                <td><form:button>Login</form:button></td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
