<%-- 
    Document   : index
    Created on : 7/04/2016, 07:03:42 PM
    Author     : Alejandro
--%>

<%@ page isErrorPage="true" language="java"
    contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored ="false" %>
<html>
    <head>
        <meta http-equiv="Content-Type" 
            content="text/html; charset=UTF-8"/>
        <title>Chat</title>
    </head>
    <body>
        <form action="login.go" method="Post" role="form">    
           Correo <input id="nombre" type="text"  name="uid" />
            <br><br><br>
            Pass <input id="pass" type="password"  name="pass" />
             <br><br><br>
            <input type="submit" value="login"/>
        </form>
    </body>
</html>