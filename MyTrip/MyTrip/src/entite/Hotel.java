/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author wyouness
 */
public class Hotel {
    private int idH;
    private String nom;
    private String adresse;
    private int nb_etoile;
    private String telephone;
    private String email;
    private int code_postal; 
    private String ville;
    private String description;

    public Hotel() {
    }
    
    public Hotel(String nom, String adresse, int nb_etoile, String telephone) {
        this.nom = nom;
        this.adresse = adresse;
        this.nb_etoile = nb_etoile;
        this.telephone = telephone;
    }

    public Hotel(int idH, String nom, String adresse, int nb_etoile, String telephone) {
        this.idH = idH;
        this.nom = nom;
        this.adresse = adresse;
        this.nb_etoile = nb_etoile;
        this.telephone = telephone;
    }

    public Hotel(int idH, String nom, String adresse, int nb_etoile, String telephone, String email, int code_postal, String ville, String description) {
        this.idH = idH;
        this.nom = nom;
        this.adresse = adresse;
        this.nb_etoile = nb_etoile;
        this.telephone = telephone;
        this.email = email;
        this.code_postal = code_postal;
        this.ville = ville;
        this.description = description;
    }

    public Hotel(String nom, String adresse, int nb_etoile, String telephone, String email, int code_postal, String ville, String description) {
        this.nom = nom;
        this.adresse = adresse;
        this.nb_etoile = nb_etoile;
        this.telephone = telephone;
        this.email = email;
        this.code_postal = code_postal;
        this.ville = ville;
        this.description = description;
    }

    

    
    

    public int getIdH() {
        return idH;
    }

    public void setIdH(int idH) {
        this.idH = idH;
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

    public int getNb_etoile() {
        return nb_etoile;
    }

    public void setNb_etoile(int nb_etoile) {
        this.nb_etoile = nb_etoile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
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
        return idH+nom.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hotel other = (Hotel) obj;
        if (this.idH != other.idH) {
            return false;
        }
        return true;
    }
    
    
    
}
