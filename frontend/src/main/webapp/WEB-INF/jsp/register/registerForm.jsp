<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,java.lang.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>


        <%session.removeAttribute("username");%>

        <div style="margin-left: auto; margin-right: auto; width: 400px; margin-top: 75px;">
            
            <form:form action="../frontend/register" commandName="registerForm">

                <table>

                    <tr>   
                        
                        <td>
                             <form:label path="username">Username</form:label>
                        </td>
                        <td>
                            <form:input path="username"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                        <form:label path="password"> Password </form:label>
                        </td>
                        <td>
                            <form:password path="password" />
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <form:label path="name" >Name 
                            </form:label>
                       </td>
                        <td>
                            <form:input path="name" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="matriculationNumber">Matriculation Number</form:label>
                        </td>
                        <td><form:input path="matriculationNumber"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Register" /></td>
                    </tr>

                </table>


            </form:form>
        </div>
    </body>
</html>

