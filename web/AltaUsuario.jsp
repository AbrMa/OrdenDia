<%-- 
    Document   : AltaUsuario
    Created on : 10-dic-2015, 18:48:56
    Author     : Alejandro
--%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@ page import="net.tanesha.recaptcha.ReCaptchaImpl" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaResponse" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String remoteAddr = request.getRemoteAddr();
    ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
    reCaptcha.setPrivateKey("6Lcp1RITAAAAAAPEqLCddJ424rJ0Q8ZlKn3JGwq0");

    String challenge = request.getParameter("recaptcha_challenge_field");
    String uresponse = request.getParameter("recaptcha_response_field");
    ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);

    if (reCaptchaResponse.isValid()) {
        
        String usuario = request.getParameter("nombre");
        String pass = request.getParameter("pass");
        String tel = request.getParameter("telefono");
        String direc = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String tipo = request.getParameter("tipo");
        if (usuario != null && pass != null && tel != null && direc != null && tipo != null && correo != null) {
            BD.cDatos sql = new BD.cDatos();
            try {
                sql.conectar();
                ResultSet rsUsr = sql.consulta("call sp_AltaUsuario('" + usuario + "','" + direc + "','" + correo + "','" + pass + "','" + tel + "','" + tipo + "');");

                while (rsUsr.next()) {

                     out.println("<script>alert('Registro Dado de Alta Exitosamente');location.href='index.html';</script>");
                   // out.print("<META HTTP-EQUIV='REFRESH' document.location.href = 'http://OrdenDia/index.html'/>");
                   //response.sendRedirect("index.html");
                }
            } catch (SQLException error) {
                out.print(error.toString());
            }

        } else {
             out.println("<script>alert('Por favor llene todos los campos');location.href='registrar.jsp';</script>");
            //out.print("<META HTTP-EQUIV='REFRESH' document.location.href = 'http://index.html'/>");
             //response.sendRedirect("index.html");
        }
    } else {
          out.println("<script>alert('El Captcha es incorrecto');location.href='registrar.jsp';</script>");
            //out.print("<META HTTP-EQUIV='REFRESH' document.location.href = 'http://OrdenDia/index.html'/>");
            //response.sendRedirect("index.html");
    }

%>