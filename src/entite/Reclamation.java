/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Mohamed
 */
public class Reclamation {
     private int idrec;
   
    private Date date_rec;
    private String Titre;
    private String description;
    private Evenement idE;
    private Utilisateur idU;

    public Reclamation(int idrec, Date date_rec, String Titre, String description, Evenement idE, Utilisateur idU) {
        this.idrec = idrec;
        this.date_rec = date_rec;
        this.Titre = Titre;
        this.description = description;
        this.idE = idE;
        this.idU = idU;
    }

    public int getIdrec() {
        return idrec;
    }

    public void setIdrec(int idrec) {
        this.idrec = idrec;
    }

    public Date getDate_rec() {
        return date_rec;
    }

    public void setDate_rec(Date date_rec) {
        this.date_rec = date_rec;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Evenement getIdE() {
        return idE;
    }

    public void setIdE(Evenement idE) {
        this.idE = idE;
    }

    public Utilisateur getIdU() {
        return idU;
    }

    public void setIdU(Utilisateur idU) {
        this.idU = idU;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idrec;
        hash = 53 * hash + Objects.hashCode(this.date_rec);
        hash = 53 * hash + Objects.hashCode(this.Titre);
        hash = 53 * hash + Objects.hashCode(this.description);
        hash = 53 * hash + Objects.hashCode(this.idE);
        hash = 53 * hash + Objects.hashCode(this.idU);
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
        final Reclamation other = (Reclamation) obj;
        if (this.idrec != other.idrec) {
            return false;
        }
        if (this.idE != other.idE) {
            return false;
        }
        if (this.idU != other.idU) {
            return false;
        }
        if (!Objects.equals(this.Titre, other.Titre)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.date_rec, other.date_rec)) {
            return false;
        }
        return true;
    }
}
