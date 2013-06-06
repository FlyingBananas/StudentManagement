<%-- 
    Document   : viewAssignments
    Created on : Jun 2, 2013, 2:12:55 PM
    Author     : madalina
--%>
<%@include file="../init.jsp"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Assignments</title>
    </head>
    <body>
       <div
	style="margin-left: auto; margin-right: auto; width: 400px; margin-top: 75px;">

	<table id="assignView" width="400" align="center" border="1">
		<thead>
			<tr id="header">

				<th>Name</th>
				<th><font color="black">Description</font></th>
				<th><font color="black">Deadline</font></th>
		</thead>

		<c:forEach var="assign" items='${assignments}'>

			<TR>

				<td><a style="color: #000"
					href="/Frontend/assignments/upload/${assign.id}"><font
						color="black"><c:out value="${assign.name}" /></font></a></td>
				<td><font color="black"><c:out value="${assign.description}" /></font></td>
				<td><font color="black"><c:out value="${assign.deadline}" /></font></td>

			</TR>

		</c:forEach>

	</table>

</div>
    </body>
</html>
