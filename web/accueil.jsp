<%-- 
    Document   : login
    Created on : 30 mai 2018, 14:19:45
    Author     : Damien Nevaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container" style="margin-top:30px">
            <div class="col-md-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Login</h3>
                    </div>
                    <div class="panel-body">

                        <form action="Controleur" method="POST">
                            <fieldset>
                                <div class="form-group">
                                    <input type="text" placeholder="Login" name="chLogin" autofocus="">
                                </div>
                                <div class="form-group">
                                    <br />
                                    <input type="password" placeholder="Password" name="chPwd" /><label/>
                                </div>
                                <br />
                                <input type ="submit" name="btnOK" value="OK" class="btn btn-primary"/>
                            </fieldset>
                        </form>
                        <span style="color:red">   
                            <%

                                String erreur = (String) request.getAttribute("cleErreur");
                                if (erreur != null) {

                                    out.println(erreur);
                                }


                            %>
                        </span>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
