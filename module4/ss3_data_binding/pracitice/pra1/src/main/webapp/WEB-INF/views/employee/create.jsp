<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/21/2022
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h3>Welcome, Enter The Employee Details</h3>
  <form:form action="addEmployee" method="post" modelAttribute="employee">
    <tabel>
      <tr>
        <td><form:label path="id">Employee Id: </form:label></td>
        <td><form:input path="id"/></td>
      </tr>
      <tr>
        <td><form:label path="name">Employee Name: </form:label></td>
        <td><form:input path="name"/></td>
      </tr>
      <tr>
        <td><form:label path="contactNumber">Employee Contact Number: </form:label></td>
        <td><form:input path="contactNumber"/></td>
      </tr>
      <tr>
        <td><input type="submit" value="Submit"/></td>
      </tr>
    </tabel>
  </form:form>
  </body>
</html>
