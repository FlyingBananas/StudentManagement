<%@include file="../init.jsp"%>

</head>
<body>


<%session.removeAttribute("username"); %>

	<div
		style="margin-left: auto; margin-right: auto; width: 400px; margin-top: 75px;">
       
            <font color="red"><c:out value='${error}'/></font>
       <br>
		<form:form action="../frontend/login" method="post"
			modelAttribute="loginForm">
			<table>

				<tr>

					<td>User Name:<FONT color="black"><form:errors
								path="username" /></FONT></td>
					<td><form:input path="username" /></td>

				</tr>

				<tr>

					<td>Password:<FONT color="black"><form:errors
								path="password" /></FONT></td>
					<td><form:password path="password" /></td>

				</tr>

				<tr>

					<td><input type="submit" value="Log in" /></td>

				</tr>

			</table>


		</form:form>
	</div>
</body>
</html>


