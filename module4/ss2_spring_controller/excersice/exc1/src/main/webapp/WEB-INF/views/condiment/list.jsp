<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/20/2022
  Time: 7:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/condiment" method="post">
    <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" id="inlineCheckbox1" name="Lettuce" value="Lettuce">
        <label class="form-check-label" for="inlineCheckbox1">Lettuce</label>
    </div>
    <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" id="inlineCheckbox2" name="Tomato" value="Tomato">
        <label class="form-check-label" for="inlineCheckbox2">Tomato</label>
    </div>
    <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" id="inlineCheckbox3" name="Mustard" value="Mustard">
        <label class="form-check-label" for="inlineCheckbox1">Mustard</label>
    </div>
    <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" id="inlineCheckbox4" name="Sprouts" value="Sprouts">
        <label class="form-check-label" for="inlineCheckbox2">Sprouts</label>
    </div>
    <hr>
    <button type="submit" class="btn btn-outline-success">Save</button>
</form>
<c:if test="${result!=null}">
    <c:forEach var="list" items="${result}">
        <p>${list}</p>
    </c:forEach>
</c:if>

</body>
</html>
