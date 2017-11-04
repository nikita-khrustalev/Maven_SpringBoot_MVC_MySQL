<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New/Edit Contact</title>
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
<div align="center">
    <h1 class="display-4">Edit Employee</h1>
    <form method="POST" name="/edit" action="<%=request.getContextPath()%>/edit">
        <div class="table_wrap">
            <table class="table">
                <thead class="thead-light">

                <input hidden="hidden" name="id" value="${id}" type="text"/>

                <tr>
                    <td class="h5"> Name :</td>
                    <td><input name="name" value="${employee.name}" type="text"/></td>
                </tr>
                <tr>
                    <td class="h5"> Email :</td>
                    <td><input name="email" value="${employee.email}" type="text"/></td>
                </tr>
                <tr>
                    <td class="h5"> Age :</td>
                    <td><input name="age" value="${employee.age}" type="text"/></td>
                </tr>

            </table>
            <tr>
                <td class="h5" colspan="2" align="center">
                <td><input value="Save" type="submit"/></td>
            </tr>
        </div>
    </form>
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