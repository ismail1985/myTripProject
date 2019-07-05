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
public class Hotel {
  private int id;
  private String nom;
  private String adresse;
  private int NbEtoile;
  private int telephone;
  private String email;
  private int codePostal;
  private String ville;
  private String description;

    public Hotel(String nom, String adresse, int NbEtoile, int telephone, String email, int codePostal, String ville, String description) {
        this.nom = nom;
        this.adresse = adresse;
        this.NbEtoile = NbEtoile;
        this.telephone = telephone;
        this.email = email;
        this.codePostal = codePostal;
        this.ville = ville;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNbEtoile() {
        return NbEtoile;
    }

    public void setNbEtoile(int NbEtoile) {
        this.NbEtoile = NbEtoile;
    }


    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.email);
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
        final Hotel other = (Hotel) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Hotel{" + "id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", NEtoile=" + NbEtoile + ", telephone=" + telephone + ", email=" + email + ", codePostal=" + codePostal + ", ville=" + ville + ", description=" + description + '}';
    }
}
