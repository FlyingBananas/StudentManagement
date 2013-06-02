<%-- 
    Document   : editAssignment
    Created on : Jun 2, 2013, 4:47:36 PM
    Author     : madalina
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<%@include file="../init.jsp"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Assignment</title>
    </head>
    <body>
        <h1>Assignment </h1>
    <c:out value="${assignment.description}" />
    </body>
</html>
