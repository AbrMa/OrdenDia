<%-- 
    Document   : RegistrarPedido
    Created on : 11/12/2015, 06:25:31 AM
    Author     : Alumno
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String Rest = request.getParameter("idRest");
    String user = request.getParameter("Usr");
    String Plat = request.getParameter("idplat");
    String Precio = request.getParameter("precio");
    String cant  =  request.getParameter("cant");
    if (Rest != null && user != null&& Plat != null&& Precio != null) {
        BD.cDatos sql = new BD.cDatos();
        try {
            sql.conectar();
            ResultSet rsUsr = sql.consulta("call sp_AltaPedido('" + Plat + "','" + Rest + "','" + user + "','" + Precio + "','" + cant + "');");

            while (rsUsr.next()) {
                out.println("<script>alert('Pedido Creado.')</script>");
               // out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/menuPrincipal.jsp'/>");
                response.sendRedirect("menuPrincipal.jsp");
            }
        } catch (SQLException error) {
            out.print(error.toString());
        }

    } else {
        out.println("<script>alert('Por favor llene todos los campos')</script>");
       // out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/menu.jsp'/>");
        response.sendRedirect("menu.jsp");
    }
%>