<%-- 
    Document   : CambiaFranquicia
    Created on : 16-nov-2015, 21:39:51
    Author     : Alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%
            String nom = request.getParameter("franquicia");
            String descrip = request.getParameter("descripcionFranquicia");
             if(descrip!=null&&nom!=null)
            {
                BD.cDatos sql = new BD.cDatos();
                try
                {
                    sql.conectar();
                    ResultSet rsUsr = sql.consulta("call sp_CambioFranquicia('"+nom+"','"+descrip+"');");
                      
                    while(rsUsr.next())
                    {
                        out.println("<script>alert('Registro Cambiado.')</script>");
                        //out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/menu.jsp'/>");
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
