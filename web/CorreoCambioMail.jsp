<%-- 
    Document   : CorreoCambioMail
    Created on : 11/12/2015, 11:16:10 AM
    Author     : Alumno
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
            String pass = request.getParameter("pass1");
            String compara=request.getParameter("compara");
             if( pass!=null )
            {
                BD.cDatos sql = new BD.cDatos();
                try
                {
                    sql.conectar();
                    ResultSet rsUsr = sql.consulta("call sp_CambioContraCorreo('"+pass+"','"+compara+"');");
                      
                    while(rsUsr.next())
                    {
                        out.println("<script>alert('Registro Cambiado.')</script>");
                       // out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/'/>");
                        response.sendRedirect("OrdenDia");
                    }
                } 
               catch (SQLException error) {
                out.print(error.toString());
                } 
                        
            }
            else
            {
                out.println("<script>alert('Por favor llene todos los campos')</script>");
               // out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/'/>");
                response.sendRedirect("OrdenDia");
            }
    %>
