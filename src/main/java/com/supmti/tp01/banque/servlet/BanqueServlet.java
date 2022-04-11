package com.supmti.tp01.banque.servlet;

import com.supmti.tp01.banque.entity.Personne;
import com.supmti.tp01.banque.service.api.BanqueServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BanqueServlet extends HttpServlet {
    private BanqueServiceInterface banqueService;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (getServletContext().getAttribute("banqueService") instanceof BanqueServiceInterface) {
            banqueService = (BanqueServiceInterface) getServletContext().getAttribute("banqueService");
        } else {
            return;
        }
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String dateNaissance = request.getParameter("dateNiassance");
        String depotInitial = request.getParameter("depotInitial");
        Personne.PersonneBuilder personneBuilder = new Personne.PersonneBuilder();
        Personne personne = personneBuilder
                .nom(nom)
                .prenom(prenom)
                .dateNaissance(dateNaissance)
                .build();

        banqueService.creerCompte(personne);

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
