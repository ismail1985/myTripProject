package entite;


import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author benamara
 */
public class Utilisateur {

   private int idU; 
   private String cin;
   private String nom;
   private String prenom;
   private String email;
   private String profil;
   private String password;
   private int telephone;

    public int getIdU() {
        return idU;
    }

    public void setIdU(int id) {
        this.idU = id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String role) {
        this.profil = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.idU;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utilisateur other = (Utilisateur) obj;
        if (this.idU != other.idU) {
            return false;
        }
        return true;
    }

    public Utilisateur(String cin, String nom, String prenom, String email, String profil, String password, int telephone) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.profil = profil;
        this.password = password;
        this.telephone = telephone;
    }
    

    public Utilisateur(int id, String cin, String nom, String prenom, String email, String role, String password, int telephone) {
        this.idU = id;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.profil = role;
        this.password = password;
        this.telephone = telephone;
    }

    public Utilisateur() {
    }

    @Override
    public String toString() {
        return "Utilisateurs{" + "id=" + idU + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", role=" + profil + ", password=" + password + ", telephone=" + telephone + '}';
    }
}
