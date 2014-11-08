<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <style>
        .error { color: red; font-size: 0.9em; font-weight: bold; }
    </style>
</head>
<body>
<center>

    <div style="color: teal; font-size: 30px">Your profile</div>

    <form:form id="updateForm" modelAttribute="user"
               action="/update/${user.id}">
    <table width="400px" height="150px">
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td>
                <form:input path="name" value="${user.name}" />
                <form:errors path="name" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td><form:label path="age">Age</form:label></td>
            <td>
                <form:input path="age" value="${user.age}"/>
                <form:errors path="age" cssClass="error"/>

            </td>
        </tr>
        <tr>
            <td>Give a admin right? </td>
            <td><form:checkbox path="isAdmin"/></td>

        </tr>

        <tr>
            <td></td>
            <td><input type="submit" value="Update" />
            </td>
        </tr>

    </table>
    </form:form>
