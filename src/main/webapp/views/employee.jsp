<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Employee</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <style>
        .table_wrap {
            padding-top: 30px;
            padding-left: 10%;
            padding-right: 10%
        }

        .table_wrap table {
            text-align: center;
        }
    </style>
</head>
<body>
<div align="center" class="table_wrap">

    <c:if test="${not empty msg}">
        ${msg}
    </c:if>

    <c:choose>
        <c:when test="${employee != null}">
            <h1 class="display-4">Employee List</h1>
            <div id="table_wrap" class="table_wrap">
                <table class="table table-bordered">
                    <thead class="thead-light">
                    <tr>
                        <th class="h5">ID</th>
                        <th class="h5">Name</th>
                        <th class="h5">Email</th>
                        <th class="h5">Age</th>
                        <th class="h5">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="employee" items="${employee}">
                        <tr>
                            <td class="h6">${employee.id}</td>
                            <td class="h6">${employee.name}</td>
                            <td class="h6">${employee.email}</td>
                            <td class="h6">${employee.age}</td>
                            <td class="h6"><a
                                    href="<%=request.getContextPath()%>/edit/${employee.id}">Edit</a>
                                &nbsp; <a
                                        href="<%=request.getContextPath()%>/delete/${employee.id}"
                                        onclick="return confirm('Do you really want to delete?')">Delete</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:when>

        <c:otherwise>
            No User found in the DB!
        </c:otherwise>
    </c:choose>
    <h4>
        New Employee Register <a href="addEmployee">here</a>
    </h4>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
        integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
        integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
        crossorigin="anonymous"></script>

</body>
</html>