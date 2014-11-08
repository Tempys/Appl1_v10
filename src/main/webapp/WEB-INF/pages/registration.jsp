<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<%--<form:form action="registration" modelAttribute="user">--%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <style>
        .error { color: red; font-size: 0.9em; font-weight: bold; }
    </style>
</head>
<body>
<div align="center">
    <h2>Registration</h2>
    <table border="0" width="90%">
        <form:form action="registration" modelAttribute="user">
            <tr>
                <td align="left" width="20%">Name: </td>
                <td align="left" width="40%">
                    <form:input path="name" size="30"/>
                    <form:errors path="name" cssClass="error" />
                </td>

            </tr>
            <tr>
                <td>Age: </td>
                <td>
                    <form:input path="age" size="30"/>
                    <form:errors path="age" cssClass="error"/>
               </td>

            </tr>
            <tr>
                <td></td>
                <td align="center"><input type="submit" value="Register"/></td>
                <td></td>
            </tr>
        </form:form>
    </table>
</div>
</body>
</html>