<%-- 
    Document   : details.jsp
    Created on : 1 juin 2018, 13:47:37
    Author     : esic
--%>

<%@page import="com.employe.EmployeBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% EmployeBean e = (EmployeBean) request.getAttribute("cleUtilisateur");
    String id = (String) request.getAttribute("cleIdModifier");

    session.setAttribute("cleIdModifier", id);
%>
<!DOCTYPE html>

<html><head>
        <meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <title></title>

    </head>
    <body>
        <div class="row">
            <div class="col-md-4 col-md-offset-2">
                <form class="form-horizontal" action="Controleur" >
                    <fieldset>
                        <legend>Détails du membre <% out.println(e.getPrenom() + " " + e.getNom());%></legend>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Nom</label>
                            <div class="col-sm-10">
                                <input type="text" name="nom" value=<%= e.getNom()%>  class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Prénom</label>
                            <div class="col-sm-10">
                                <input type="text" name="prenom"  value=<%= e.getPrenom()%> class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Tél dom</label>
                            <div class="col-sm-10">
                                <input type="text" name="teldom" value=<%= e.getTeldom()%>  class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Tél mob</label>
                            <div class="col-sm-10">
                                <input type="text" name="telpor" value=<%= e.getTelport()%>  class="form-control">
                            </div>
                        </div>                      

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Tél pro</label>
                            <div class="col-sm-10">
                                <input type="text" name="telpro" value=<%= e.getTelpro()%>  class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Adresse</label>
                            <div class="col-sm-4">
                                <input type="text" name="adresse" value=<%= e.getAdresse()%>   class="form-control">
                            </div>

                            <label class="col-sm-2 control-label" for="textinput">Code postal</label>
                            <div class="col-sm-4">
                                <input type="text" name="cp" value=<%= e.getCodepostal()%>  class="form-control">
                            </div>
                        </div>

                        <label class="col-sm-2 control-label" for="textinput">Ville</label>
                        <div class="col-sm-4">
                            <input type="text" name="ville" value=<%= e.getVille()%> class="form-control">
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Adresse e-mail</label>
                            <div class="col-sm-4">
                                <input type="text" name="mail" value=<%= e.getEmail()%>  class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="pull-right">
                            <input type="submit" value="Voir liste" name="bouton">
                            <input type="submit" value="Modifier" name="bouton">
                            </div>
                            </div>
                        </div>

                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</body>
</html>