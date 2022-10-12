<%-- 
    Document   : ModificarPlatillo
    Created on : 29/04/2016, 03:42:46 PM
    Author     : Alumno
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%          
            String idRest = request.getParameter("Restaurante");
            String nom = request.getParameter("platillo");
            String descrip = request.getParameter("descripcion");
            String prec = request.getParameter("precio");
             if(descrip!=null&&nom!=null&&prec!=null)
            {
                BD.cDatos sql = new BD.cDatos();
                try
                {
                    sql.conectar();
                    ResultSet rsUsr = sql.consulta("call sp_CambioPlatillo('"+nom+"','"+descrip+"','"+prec+"','"+idRest+"');");
                      
                    while(rsUsr.next())
                    {
                       //  out.println("<script>alert('Registro Cambiado.')</script>");
                           out.println("<script>alert('Platillo Modificado.');location.href='menuRestaurante.jsp'</script>");
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
                 out.println("<script>alert('Por favor llene todos los campos');location.href='menuRestaurante.jsp'</script>");
                 // response.sendRedirect("menuRestaurante.jsp");
            }
    %>
