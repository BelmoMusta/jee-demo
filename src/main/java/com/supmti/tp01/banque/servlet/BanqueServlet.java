package com.supmti.tp01.banque.servlet;

import com.supmti.tp01.banque.entity.Personne;
import com.supmti.tp01.banque.entity.PersonneAvecDateNaissance;
import com.supmti.tp01.banque.service.BanqueService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BanqueServlet extends HttpServlet {
    private BanqueService banqueService;
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (getServletContext().getAttribute("banqueService") instanceof BanqueService) {
            banqueService = (BanqueService) getServletContext().getAttribute("banqueService");
        } else {
            return;
        }
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String dateNaissance = request.getParameter("dateNiassance");
        Personne.PersonneBuilder personneBuilder = new Personne.PersonneBuilder();
        Personne personne = personneBuilder
                .nom(nom)
                .prenom(prenom)
                .build();
        PersonneAvecDateNaissance personneDecoree
                = new PersonneAvecDateNaissance(personne, dateNaissance);
        banqueService.creerCompte(personneDecoree);
        Cookie cookie = new Cookie("Id", "123");
        cookie.setMaxAge(30);
        response.addCookie(cookie);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> BanqueServlet </h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
