<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link  href= " <c:url value= "../../resources/css/main.css" />" rel="stylesheet" type="text/css" >
    <%-- <link  href= " <c:url value= "../../resources/css/simplePagination.css" />" rel="stylesheet" type="text/css" >--%>
    <%-- <link  href= " <c:url value= "../../resources/css/bootstrap.css" />" rel="stylesheet" type="text/css" >--%>
    <link  href= " <c:url value= "../../resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" >
    <script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js'></script>
    <script type='text/javascript' src='../../resources/js/main.js'></script>



</head>
<body>

<div class="sear">
    <input class=" int datasearch" type="search"  id="dataSearch">
    <input class="int search" type="button" value="Search" id="search">
    <input class="int create"  type="button" id="err" value="Create user">
</div>
<h1>List of users: </h1>

<jsp:include page="table.jsp" />

</body>
</html>