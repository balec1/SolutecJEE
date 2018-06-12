/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solutec;

import com.employe.EmployeBean;
import com.employe.UtilisateurBean;
import com.model.ConnectionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author esic
 */
public class Controleur extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            String messageErreur;
            System.out.println("dans controleur"); // TEST A ENLEVER
            ArrayList<UtilisateurBean> listeId = new ArrayList<UtilisateurBean>();
            String status = (String) session.getAttribute("cleConnecte");
            if (status != "isConnected") {
                System.out.println("boucle connectee"); // TEST A ENLEVER
                String entreeLogin = request.getParameter("chLogin");
                String entreePwd = request.getParameter("chPwd");
                if (entreeLogin != null && entreePwd != null) {
                    ConnectionDB cdb = new ConnectionDB();
System.out.println("dans bloucle non null"); // TEST A ENELVER
                    listeId = cdb.getIdentifiants(); //on recupère le contenu de la table identifiants dans une ArrayList

                    //pour chaque entrée de la table Identifiants, on compare avec les entrées de l'utilisateur
                    for (UtilisateurBean e : listeId) {
                        System.out.println("dans boucle liste id"); // TEST A ENELVER
                        if (e.getLogin().equals(entreeLogin) && e.getPassword().equals(entreePwd)) {

                            session.setAttribute("cleConnecte", "isConnected");
                            request.getRequestDispatcher("tableauresultat.jsp").forward(request, response);

                        }

                    }
                    if (request.getParameter("chLogin").isEmpty() || request.getParameter("chPwd").isEmpty()) {
                        messageErreur = "Renseignez les deux champs";
                        request.setAttribute("cleErreur", messageErreur);
                    } else {
                        messageErreur = "Les champs renseignés ne sont pas corrects";
                        request.setAttribute("cleErreur", messageErreur);
                    }
                    //on indique que l'user n'a pas réussi à se connecter,
                    //l'info est lise dans accueil.jsp

                    request.getRequestDispatcher("accueil.jsp").forward(request, response);
                }

            }
            ConnectionDB cdb2 = new ConnectionDB();
            String idm = (String) session.getAttribute("cleIdModifier");

            String btn = request.getParameter("bouton");
            String id = request.getParameter("idClient");

            if (btn != null) {
                if (btn.equals("Supprimer")) {
                    int nbSuppr = cdb2.supprimerEntree(id);

                } else if (btn.equals("Details")) {
                    EmployeBean u = new EmployeBean();

                    u = cdb2.getSpecificEmploye(id);
                    request.setAttribute("cleUtilisateur", u);
                    request.setAttribute("cleIdModifier", id);
                    request.getRequestDispatcher("details.jsp").forward(request, response);
                } else if (btn.equals("Voir liste")) {
                    request.getRequestDispatcher("tableauresultat.jsp").forward(request, response);
                } else if (btn.equals("Modifier")) {
                    //extraction des données de la page details.jsp

                    ArrayList<String> listeModif = new ArrayList<String>();
                    listeModif.add(request.getParameter("nom"));
                    listeModif.add(request.getParameter("prenom"));
                    listeModif.add(request.getParameter("teldom"));
                    listeModif.add(request.getParameter("telpor"));
                    listeModif.add(request.getParameter("telpro"));
                    listeModif.add(request.getParameter("adresse"));
                    listeModif.add(request.getParameter("cp"));
                    listeModif.add(request.getParameter("ville"));
                    listeModif.add(request.getParameter("mail"));

                    cdb2.modifierEmploye(listeModif, idm);
                    request.getRequestDispatcher("tableauresultat.jsp").forward(request, response);
                }

            }

            request.getRequestDispatcher("tableauresultat.jsp").forward(request, response);

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
