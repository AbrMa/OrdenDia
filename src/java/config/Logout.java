/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Logout", urlPatterns={"/logout.go"},
        loadOnStartup=1)
// Invalida la sesión
public class Logout extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = -6175876557872938832L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("soporte.jsp");
    }
}