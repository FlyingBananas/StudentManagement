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
        <!-- <link rel="stylesheet" href="css/styles.css" />-->
    </head>
    <body>
        <h1>Assignment </h1>
        <header>
            <h1>HTML5 Upload to MongoDB demo</h1>
        </header>

        <div id="dropbox">
            <span class="message">Drop images here to upload. <br /><i>(they will only be visible to you)</i></span>
        </div>


        <c:out value="${assignment.description}" />

        <!-- Including The jQuery Library -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

        <!-- Including the HTML5 Uploader plugin -->
       <!-- <script src="js/jquery.filedrop.js"></script>-->

        <!-- The main script file -->
        <!-- <script src="js/script.js"></script>-->
    </body>
</html>
