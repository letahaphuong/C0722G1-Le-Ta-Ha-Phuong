<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/7/2022
  Time: 8:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Furama-Danh sach dich vu</title>
    <link rel="stylesheet" href="mystyle.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>

<div class="vh-100 vw-100">
    <header class="d-flex justify-content-between" style="height: 15%;">
        <div class=" d-flex justify-content-center ps-5">
            <div class="shadow-lg">
                <a href="https://furamavietnam.com/" class="header-logo1 rounded">
                    <img src="https://furamavietnam.com/wp-content/uploads/2018/08/logo.png" class="img-fura"></a>
            </div>
        </div>
        <div class=" d-flex justify-content-center " style="flex-direction: column">
            <div class="border rounded shadow-lg" style="border: 1px solid  #046056 ">
                <a class="m-0"
                   href="https://www.tripadvisor.com/Hotel_Review-g298085-d302750-Reviews-Furama_Resort_Danang-Da_Nang.html">
                    <img src="https://logos-marques.com/wp-content/uploads/2021/03/TripAdvisor-Logo-500x283.png"
                         style="width: 150px">
                </a>
            </div>
        </div>
        <div class=" d-flex justify-content-center align-items-center">
            <div class="container border rounded " style="height: 100px;width: 250px">
                <a href="https://goo.gl/maps/oaWEpPuBNhUYoFPN8"><img src="../../1x/baseline_location_on_black_24dp.png"
                                                                     height="24" width="24"/></a>
                <a class="text-black text-decoration-none" href="https://goo.gl/maps/oaWEpPuBNhUYoFPN8"
                   style="font-size: 13px">
                    103 - 105 Vo Nguyen Giap Street,
                    Khue My Ward, Ngu Hanh Son
                    District, Danang City, Vietnam
                    7,0 km from Danang Airport
                </a>
            </div>
        </div>
        <div class=" d-flex justify-content-center align-items-center">
            <div class="container border rounded shadow-lg" style="width: 235px;height: 115px">
                <img src="../../1x/baseline_local_phone_black_24dp.png" height="24" width="24"/>
                <p style="font-size: 13px">84-236-3847 333/888</p>
                <img src="../../1x/baseline_email_black_24dp.png" height="24" width="24"/>
                <p style="font-size: 13px">reservation@furamavietnam.com</p>
            </div>
        </div>
        <div class="d-flex justify-content-center pe-5">
            <button type="button" class="btn btn-success my-5 text-dark bg-light ">login</button>
            <button type="button" class="btn btn-success my-5 text-dark bg-secondary">log out</button>
        </div>
    </header>
    <div class="row sticky-top" style="height: 5%">
        <nav class="navbar navbar-expand-lg " style="background-color: #046056">
            <div class="container-fluid">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item ">
                            <a class="nav-link active text-white" aria-current="page" href="#"
                               style="color: #0000008c ">Home</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle text-white" href="#" id="navbarEmployee" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                Employee
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarEmployee">
                                <li><a class="dropdown-item" href="#">Management</a></li>
                                <li><a class="dropdown-item" href="#">Staff</a></li>
                                <li><a class="dropdown-item" href="#">Show All</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle text-white" href="#" id="navbarCustomer" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                Customer
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarCustomer">
                                <li><a class="dropdown-item" href="#">Diamond</a></li>
                                <li><a class="dropdown-item" href="#">Platinium</a></li>
                                <li><a class="dropdown-item" href="#">Gold</a></li>
                                <li><a class="dropdown-item" href="#">Silver</a></li>
                                <li><a class="dropdown-item" href="#">Member</a></li>

                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle text-white" href="#" id="navbarService" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                Service
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarService">
                                <li><a class="dropdown-item" href="#">Villa</a></li>
                                <li><a class="dropdown-item" href="#">House</a></li>
                                <li><a class="dropdown-item" href="#">Room</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle text-white" href="#" id="navbarContract" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                Contract
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarContract">
                                <li><a class="dropdown-item" href="#">Action</a></li>
                                <li><a class="dropdown-item" href="#">Another action</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="#">Something else here</a></li>
                            </ul>
                        </li>
                    </ul>
                    <form class="d-flex col-xxl-2 col-xl-2 col-lg-3 col-md-3 col-sm-3 ">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>

                </div>
            </div>
        </nav>
    </div>
    <div class="row text-center"
         style="height: 75%">
        <div class="row ">
            <div class="col-lg-1">
                <button class="btn btn-outline-primary mt-5" type="submit" onclick="location.href='/customer'">Back
                </button>
            </div>
            <div class="col-lg-10">
                <div class="row m-5">
                    <div class="container register-form">
                        <div class="form">
                            <div class="note align-items-center d-flex justify-content-center">
                                <h2>CREATE CUSTOMER</h2>
                            </div>
                            <c:if test="${mess!=null}">
                                <h4 style="color: blue">${mess}</h4>
                            </c:if>
                            <form action="/employee?action=add" method="post">
                                <div class="form-content">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Name</label>
                                                <input style="border-radius: 30px" type="text" class="form-control"
                                                       name="name"
                                                       placeholder="NAME *"/>
                                                <%--                                                <label>Select Customer Type</label>--%>
                                                <%--                                                <select name="customerType" class="form-select" aria-label="Default select example"--%>
                                                <%--                                                        style="border-radius: 30px">--%>
                                                <%--                                                    <option selected>SELECT CUSTOMER TYPE *</option>--%>
                                                <%--                                                    <option value="1">Diamond</option>--%>
                                                <%--                                                    <option value="2">Platinum</option>--%>
                                                <%--                                                    <option value="3">Gold</option>--%>
                                                <%--                                                    <option value="4">Silver</option>--%>
                                                <%--                                                    <option value="5">Member</option>--%>
                                                <%--                                                </select>--%>
                                            </div>
                                            <br>
                                            <div class="form-group">
                                                <label for="birtdDateAdd">Birth Day</label>
                                                <input style="border-radius: 30px" value="${customer.getDateOfBirth()}"
                                                       name="dateOfBirth" id="birtdDateAdd" class="form-control"
                                                       type="date"/>

                                            </div>
                                            <br>
                                            <div class="form-group">
                                                <label>Id Card</label>
                                                <input style="border-radius: 30px" type="text" class="form-control"
                                                       name="idCard"
                                                       placeholder="ID CARD *"/>
                                            </div>
                                            <br>
                                            <div class="form-group">
                                                <label>Salary</label>
                                                <input style="border-radius: 30px" type="text" class="form-control"
                                                       name="salary"
                                                       placeholder="SALARY *"/>
                                            </div>
                                            <br>
                                            <div class="form-group">
                                                <label>Phone Number</label>
                                                <input type="text" style="border-radius: 30px" class="form-control"
                                                       name="phoneNumber"
                                                       placeholder="PHONE NUMBER *"/>
                                            </div>
                                            <br>
                                            <div class="form-group">
                                                <label>Email</label>
                                                <input type="text" style="border-radius: 30px" class="form-control"
                                                       name="email"
                                                       placeholder="E-MAIL *"/>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Address</label>
                                                <input type="text" style="border-radius: 30px" class="form-control"
                                                       name="address"
                                                       placeholder="ADDRESS *"/>
                                            </div>
                                            <br>
                                            <div class="form-group">
                                                <label>Position</label>
                                                <select name="positionId" class="form-select"
                                                        aria-label="Default select example"
                                                        style="border-radius: 30px" onmouseover="disappear()">
                                                    <option id="disappearId1">SELECT POSITION *</option>
                                                    <option value="1">Management</option>
                                                    <option value="2">Staff</option>
                                                </select>
                                            </div>
                                            <br>
                                            <div class="form-group">
                                                <label>Education Degree</label>
                                                <select name="educationDegreeId" class="form-select"
                                                        aria-label="Default select example"
                                                        style="border-radius: 30px" onmouseover="disappear()">
                                                    <option id="disappearId" >SELECT EDUCATION DEGREE*</option>
                                                    <option value="1">Post- Graduate</option>
                                                    <option value="2">Bachelor’s Degree</option>
                                                    <option value="3">Associate’s degree</option>
                                                    <option value="4">Intermediate Level</option>
                                                </select>
                                            </div>
                                            <br>
                                            <div class="form-group">
                                                <label>Division</label>
                                                <select name="divisionId" class="form-select"
                                                        aria-label="Default select example"
                                                        style="border-radius: 30px" onmouseover="disappear()">
                                                    <option id="disappearId2">SELECT DIVISION *</option>
                                                    <option value="1">Sale-Marketing</option>
                                                    <option value="2">Administrative Division</option>
                                                    <option value="3">Service Department</option>
                                                    <option value="4">Management Department</option>
                                                </select>
                                            </div>
                                            <br>
                                            <div class="form-group">
                                                <label>USERNAME</label>
                                                <input type="text" style="border-radius: 30px" class="form-control"
                                                       name="userName"
                                                       placeholder="USERNAME *"/>
                                            </div>
                                        </div>

                                    </div>
                                    <br>
                                    <button type="submit" class="btn btn-outline-success">Submit</button>
                                </div>
                            </form>

                        </div>
                    </div>

                </div>

                <div></div>

            </div>
            <div class="col-lg-1">

            </div>
        </div>

    </div>
    <footer class="bg-light text-center text-lg-start position-fixed" style="height: 5%;width: 100%">
        <div class="text-center text-white p-3" style="background-color:#046056 ;">
            © 2022 Phuong Le Ta Ha
        </div>
    </footer>
</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous">var toastTrigger = document.getElementById('liveToastBtn')
var toastLiveExample = document.getElementById('liveToast')
if (toastTrigger) {
    toastTrigger.addEventListener('click', function () {
        var toast = new bootstrap.Toast(toastLiveExample)

        toast.show()
    })
}</script>
<script>
    function idRemove(id) {
        document.getElementById("idInput").value = id;
    }
</script>
<script>
    function disappear() {
        document.getElementById("disappearId").style.display = "none";
        document.getElementById("disappearId1").style.display = "none";
        document.getElementById("disappearId2").style.display = "none";
    }
</script>
</html>
