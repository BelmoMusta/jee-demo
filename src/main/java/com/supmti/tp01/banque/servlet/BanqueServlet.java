package com.supmti.tp01.banque.servlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BanqueServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Object banqueService = getServletContext().getAttribute("banqueService");
        Cookie cookie = new Cookie("Id", "123");
        cookie.setMaxAge(30);
        response.addCookie(cookie);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> BanqueServlet </h1>");
        out.println("</body></html>");
    }

}
