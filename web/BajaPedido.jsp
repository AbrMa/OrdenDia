<%-- 
    Document   : BajaPedido
    Created on : 15-dic-2015, 10:33:13
    Author     : Alejandro
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
             String nombre = request.getParameter("nombre");          
             if(nombre!=null)
            {
                BD.cDatos sql = new BD.cDatos();
                try
                {
                    sql.conectar();
                   ResultSet rsUsr = sql.consulta("call sp_BajaPedido('"+nombre+"');");
                      
                    while(rsUsr.next())
                    {
                        out.println("<script>alert('Pedido Borrado.')</script>");
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
               // out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/menu.jsp'/>");}
                response.sendRedirect("menu.jsp");
            }
    %>
