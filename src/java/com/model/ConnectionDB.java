/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.employe.UtilisateurBean;
import com.employe.EmployeBean;
import static com.utils.EmployesConstantes.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author esic
 */
public class ConnectionDB {

    //Initialisation des attributs
    private Statement stmt;
    private ResultSet rs;
    private Connection conn;
    private PreparedStatement pstmt;
    private Properties prop;
    private ClassLoader classLoader;
    private String dbUrl;
    private String dbUser;
    private String dbPwd;
    private InputStream input;

    //Constructeur de l'objet
    public ConnectionDB() {
        classLoader = Thread.currentThread().getContextClassLoader();
        input = classLoader.getResourceAsStream(CHEMIN_FICHIER_PROPERTIES);

        prop = new Properties();

        try {
            prop.load(input);
            this.dbUrl = prop.getProperty(DB_URL);
            this.dbUser = prop.getProperty(DB_USER);
            this.dbPwd = prop.getProperty(DB_PWD);
            // Code ci-dessous uniquement pour le serveur d'application TomEE ou WildFly
//            Class.forName("org.apache.derby.jdbc.ClientDriver");
//            conn=DriverManager.getConnection(this.dbUrl,this.dbUser,this.dbPwd);
        } catch (IOException  ex) {
            System.out.println(ex.getMessage());
        }
    }
// Cette méthode renvoie une liste contenant les objets correspondants
// aux entrées de la table Identifiants de la DB

    public ArrayList<UtilisateurBean> getIdentifiants() {
        ArrayList<UtilisateurBean> liste = genererListeUtilisateurs("SELECT * FROM IDENTIFIANTS", dbUrl, dbUser, dbPwd);
        return liste;
    }

    public ArrayList<EmployeBean> getEmployes() {
        ArrayList<EmployeBean> liste = genererListeEmployes("SELECT * FROM EMPLOYES", dbUrl, dbUser, dbPwd);
        return liste;
    }

    public EmployeBean getSpecificEmploye(String id) {
        String query = "SELECT * FROM EMPLOYES WHERE ID=?";
        EmployeBean u = new EmployeBean();

        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                u.setAdresse(rs.getString("ADRESSE"));
                u.setCodepostal(rs.getString("CODEPOSTAL"));
                u.setNom(rs.getString("NOM"));
                u.setPrenom(rs.getString("PRENOM"));
                u.setTeldom(rs.getString("TELDOM"));
                u.setTelport(rs.getString("TELPORT"));
                u.setTelpro(rs.getString("TELPRO"));
                u.setVille(rs.getString("VILLE"));
                u.setEmail(rs.getString("EMAIL"));
                u.setId(rs.getString("ID"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    public int supprimerEntree(String id) {
        String query = "DELETE FROM EMPLOYES WHERE ID= ?";
        int i = 0;
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            i = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public void modifierEmploye(ArrayList<String> liste, String id) {
        String query = "UPDATE EMPLOYES SET NOM= ?, PRENOM=?, TELDOM=?, TELPORT=?, TELPRO=?, ADRESSE= ?, CODEPOSTAL= ?, VILLE=?,EMAIL=? WHERE ID=?";
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
            pstmt = conn.prepareStatement(query);
            //Initialisation de la preparedstatement avec le contenu de la liste envoyée
//            for (int i=0;i<9;i++){
//                int j=i+1;
//                    pstmt.setString(j, liste.get(i));
// 
//            }
//TEST SANS LA BOUCLE FOR

            pstmt.setString(1, liste.get(0));
            pstmt.setString(2, liste.get(1));
            pstmt.setString(3, liste.get(2));
            pstmt.setString(4, liste.get(3));
            pstmt.setString(5, liste.get(4));
            pstmt.setString(6, liste.get(5));
            pstmt.setString(7, liste.get(6));
            pstmt.setString(8, liste.get(7));
            pstmt.setString(9, liste.get(8));

            pstmt.setString(10, id);

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ArrayList<UtilisateurBean> genererListeUtilisateurs(String query, String url, String user, String password) {

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        ArrayList<UtilisateurBean> liste = new ArrayList<>();

        try {
            stmt = conn.createStatement();

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                UtilisateurBean e = new UtilisateurBean();
                e.setLogin(rs.getString("LOGIN"));
                e.setPassword(rs.getString("MDP"));
                liste.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste;
    }

    private ArrayList<EmployeBean> genererListeEmployes(String query, String url, String user, String password) {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        ArrayList<EmployeBean> liste = new ArrayList<>();

        try {
            stmt = conn.createStatement();

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                EmployeBean u = new EmployeBean();
                u.setAdresse(rs.getString("ADRESSE"));
                u.setCodepostal(rs.getString("CODEPOSTAL"));
                u.setNom(rs.getString("NOM"));
                u.setPrenom(rs.getString("PRENOM"));
                u.setTeldom(rs.getString("TELDOM"));
                u.setTelport(rs.getString("TELPORT"));
                u.setTelpro(rs.getString("TELPRO"));
                u.setVille(rs.getString("VILLE"));
                u.setEmail(rs.getString("EMAIL"));
                u.setId(rs.getString("ID"));
                liste.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return liste;

    }
}
