<%-- 
    Document   : CambiaRestaurante
    Created on : 07-dic-2015, 20:19:06
    Author     : Alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%
            String nom = request.getParameter("Restaurante");
            String descrip = request.getParameter("descrestaurante");
            String direc = request.getParameter("direccion");
             if(descrip!=null&&nom!=null&&direc!=null)
            {
                BD.cDatos sql = new BD.cDatos();
                try
                {
                    sql.conectar();
                    ResultSet rsUsr = sql.consulta("call sp_CambioRestaurante('"+nom+"','"+descrip+"','"+direc+"');");
                      
                    while(rsUsr.next())
                    {
                       //  out.println("<script>alert('Registro Cambiado.')</script>");
                           out.println("<script>alert('Restaurante Modificado.');location.href='menuFranquicia.jsp'</script>");
                       //  response.sendRedirect("menuRestaurante.jsp");
                    }
                }
               catch (SQLException error) {
                out.print(error.toString());
            }
                        
            }
            else
            {
                // out.println("<script>alert('')</script>");
                 out.println("<script>alert('Por favor llene todos los campos');location.href='menuFranquicia.jsp'</script>");
                 // response.sendRedirect("menuRestaurante.jsp");
            }
    %>
