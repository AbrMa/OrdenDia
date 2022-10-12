<%-- 
    Document   : BorraRestaurante
    Created on : 03-dic-2015, 20:01:03
    Author     : Alejandro
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
             String nombre = request.getParameter("Restaurante");          
             if(nombre!=null)
            {
                BD.cDatos sql = new BD.cDatos();
                try
                {
                    sql.conectar();
                   ResultSet rsUsr = sql.consulta("call sp_BajaRestaurante('"+nombre+"');");
                      
                    while(rsUsr.next())
                    {
                        out.println("<script>alert('Restaurante Borrado.')</script>");
                       // out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/menu.jsp'/>");
                        response.sendRedirect("menu.jsp");
                    }
                }
               catch (SQLException error) {
                out.print(error.toString());
            }
                        
            }
            else
            {
                out.println("<script>alert('Por favor llene todos los campos')</script>");
                //out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/menu.jsp'/>");
                response.sendRedirect("menu.jsp");
            }
    %>
