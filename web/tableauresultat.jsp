<%@page import="com.employe.EmployeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.employe.UtilisateurBean"%>
<%@page import="com.model.ConnectionDB"%>
<%@page import="com.model.ConnectionDB"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <title>Liste des employés</title>
    </head>
    <body>
        <div class="container" >
            <div class="row col-md-6 col-md-offset-0 custyle">

                <form action="Controleur" method="post">

                    <table  class="table table-striped custab">
                        <thead>
                        <h1>Liste des employés</h1>
                        <tr class="text-center">
                            <td><b>Detail</b></td>
                            <td><b>Nom</b></td>
                            <td><b>Prenom</b></td>
                            <td><b>Teldom</b></td>
                            <td><b>Telport</b></td>
                            <td><b>Telpro</b></td>
                            <td><b>Adresse</b></td>
                            <td><b>Code Postal</b></td>
                            <td><b>Ville</b></td>
                            <td><b>Email</b></td>
                        </tr>
                        </thead>
                        </tr>

                        <%


//                            ArrayList<EmployeBean> listeEmployes = (ArrayList) request.getAttribute("cleListeEmp");
//                            for (int i = 0; i < listeEmployes.size(); i++) {
//                                EmployeBean e;
//                                e = listeEmployes.get(i);

                        %>
                   
                        <c:forEach items="${cleListeEmp}" var="employe">  
                            <tr> 
                              <td><INPUT TYPE="radio" NAME="idClient" value="${employe.id}"  CHECKED > 
         
                              </td>                                
                                <td>${employe.nom}</td>
                                <td> ${employe.prenom}</td>
                                <td>${employe.teldom}</td>
                                <td>${employe.telport}</td>
                                <td>${employe.telpro}</td>
                                <td>${employe.adresse}</td>
                                <td>${employe.codepostal}</td>
                                <td>${employe.ville}</td>
                                <td>${employe.email}</td>

                            </tr>
                        </c:forEach>

                        <% //   }

                        %>

                        <%                    // ECRITURE DU TABLEAU DANS UNE METHODE
                            //                    ConnectionDB cdb = new ConnectionDB();
                            //                    ArrayList<UtilisateurBean> listeUtilisateurs = new ArrayList<UtilisateurBean>();
                            //                    listeUtilisateurs = cdb.getEmployes();
                            //                    for (int i = 0; i < listeUtilisateurs.size(); i++) {
                            //                        UtilisateurBean u;
                            //                        u= listeUtilisateurs.get(i);
                            //                    
                            //                        String str=u.ajouterEntreeUtilisateur();
                            //                        out.print(str);
                            //                    }
%>

                    </table>
                    <br>
                    <input type="submit" value="Details" name="bouton" class="btn btn-primary">
                    <input type="submit" value="Supprimer" name="bouton" class="btn btn-primary">

                    <br>
                </form>
                </body>
                </html>