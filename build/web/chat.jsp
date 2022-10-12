<%@ page isErrorPage="true" language="java"
    contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored ="false" %>
<!-- Redirect to index.jsp if no UID -->
<c:if test="${UID == null}">
    <c:redirect url="soporte.jsp" />
</c:if>
<html>
    <head>
        <meta http-equiv="Content-Type" 
            content="text/html; charset=UTF-8"/>
        <title>chat chidito xdxd </title>
        <link href="chat.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="chat.js"></script>
    </head>
    <body>
        <form action="logout.go" method="post">
            <div>CHAT</div>
            <div>jajajajajaja soy el jorjais</div>
            <div>Escriba su mensaje aquí</div>
            <div>Presione Logout para salir</div>
            <div>HOLA:  <span id="uid">${UID}</span></div>
            <div id="content" class="content"></div>
            <div>    
                <textarea class="msg-input" onkeyup="chat.dokeyup(event);"></textarea>
            </div>
            <input type="submit" value="logout" />
        </form>
    </body>
</html>