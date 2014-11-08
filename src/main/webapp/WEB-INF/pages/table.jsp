<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title></title>




</head>
<body>
<div class="tot">
<div class="ErrorMessage" id="ErMes">${Message}</div>


<div class="table" id="table1">
    <c:forEach var="item" items="${list}">
        <div class="row"  >

            <div  id="tabl" class="cell" style="width:300px;"><c:out value="${item.name}"/> </div>
            <div class="cell" style="width:100px;" ><input data-name = "${item.name}" id="delete1" class="delete" type="button" value="Delete user"></div>
            <div class="cell"><input data-id = "${item.name}" class="edit" type="button" value="Edit user"></div>

        </div>
    </c:forEach>
</div>
<div class="circle">
    <c:forEach begin="1" end="${numPages}" var="p">
        <a href="/main/${p}">${p}</a>
    </c:forEach>
</div>
 </div>
</body>
</html>