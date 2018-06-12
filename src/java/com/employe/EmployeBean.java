/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employe;

/**
 *
 * @author esic
 */
public class EmployeBean {

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    private String id;
    private String nom;
    private String prenom;
    private String teldom;
    private String telpro;
    private String telport;
    private String adresse;
    private String codepostal;
    private String ville;
    private String email;

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the teldom
     */
    public String getTeldom() {
        return teldom;
    }

    /**
     * @param teldom the teldom to set
     */
    public void setTeldom(String teldom) {
        this.teldom = teldom;
    }

    /**
     * @return the telpro
     */
    public String getTelpro() {
        return telpro;
    }

    /**
     * @param telpro the telpro to set
     */
    public void setTelpro(String telpro) {
        this.telpro = telpro;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the codepostal
     */
    public String getCodepostal() {
        return codepostal;
    }

    /**
     * @param codepostal the codepostal to set
     */
    public void setCodepostal(String codepostal) {
        this.codepostal = codepostal;
    }

    /**
     * @return the ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * @param ville the ville to set
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telport
     */
    public String getTelport() {
        return telport;
    }

    /**
     * @param telport the telport to set
     */
    public void setTelport(String telport) {
        this.telport = telport;
    }

    public void afficher() {
        System.out.println("Nom=" + nom + ", prenom=" + prenom + ", teldom=" + teldom + ", telpro=" + telpro + ", telport=" + telport + ", adresse=" + adresse + ", codepostal=" + codepostal + ", ville=" + ville + ", email=" + email);
    }

    public String getString() {
        String str = ("Nom : " + nom + "<br/>Prenom : " + prenom + "<br/>Teldom : " + teldom + "<br/>Telpro : " + telpro + "<br/>Telport : " + telport + "<br/>Adresse : " + adresse + " " + codepostal + " " + ville + "<br/>Email : " + email);
        return str;
    }
// PAS BON D'UN POINT DE VUE QUALITE: UN JAVABEAN NE DEVRAIT CONTENIR QUE DES GETTER, DES SETTER ET DES VARIABLES PRIVATE
    public String ajouterEntreeUtilisateur() {

        String str = "<tr><td>  <INPUT TYPE=\"radio\" NAME=\"idClient\" VALUE=" + getId() + " CHECKED ></td>"
                + "<td>" + getNom() + "</td>"
                + "<td> " + getPrenom() + "  </td>"
                + "  <td> " + getTeldom() + " </td>"
                + " <td>"
                + getTelport()
                + " </td>"
                + " <td> "
                + getTelpro()
                + "  </td>"
                + "<td> " + getAdresse() + "</td>"
                + "  <td>" + getCodepostal() + " </td>"
                + "  <td> " + getVille() + " </td>"
                + " <td>" + getEmail() + "</td></tr>";


        return str;
    }
}
