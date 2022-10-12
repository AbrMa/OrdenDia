/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login.go"},
        loadOnStartup = 1)
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String uid = new String(request.getParameter("uid").getBytes("ISO-8859-1"), "UTF-8");
            String correo = request.getParameter("uid");
            String pass = request.getParameter("pass");
            if (pass != null && correo != null) {

                BD.cDatos sql = new BD.cDatos();
                try {
                    sql.conectar();
                    ResultSet rsUsr = sql.consulta("call st_consultasUsuario('" + correo + "','" + pass + "');");

                    while (rsUsr.next()) {

                        if (Integer.parseInt(rsUsr.getString("idPersona")) > 0) {
                            String newUid = uid;
                            int i = 2;
                            Map chat = Chat.getChatMap();
                            synchronized (chat) {
                             
                                if ("you".equalsIgnoreCase(newUid)) {
                                    newUid = uid + i++;
                                }
                                while (chat.containsKey(newUid)) {
                                    newUid = uid + i++;
                                }
                                uid = newUid;
                                chat.put(uid, new ArrayList());
                            }
                            request.getSession().setAttribute("UID", uid);
                            response.sendRedirect("chat.jsp");
                            out.println("<script>alert('Bienvenido al Sistema!.')</script>");
                        } else {
                            out.println("<script>alert('aoc')</script>");
                            response.sendRedirect("soporte.jsp");
                        }

                    }

                } catch (SQLException error) {
                    out.println("<script>alert('Sting')</script>");
                    response.sendRedirect("soporte.jsp");
                }
            } else {
                out.println("<script>alert('Por favor llene todos los campos')</script>");
                response.sendRedirect("soporte.jsp");

            }
        }
    }
}
//eyes with out a face 
