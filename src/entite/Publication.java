/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.util.Date;

/**
 *
 * @author Rihab
 */
public class Publication {
    private int id;
    private Date dateP;
    private Evenement IdEv;
    private Utilisateur IdU;

    public Publication() {
    }

    public Publication(Date dateP, Evenement IdEv, Utilisateur IdU) {
        this.dateP = dateP;
        this.IdEv = IdEv;
        this.IdU = IdU;
    }

    public Publication(int id, Date dateP, Evenement IdEv, Utilisateur IdU) {
        this.id = id;
        this.dateP = dateP;
        this.IdEv = IdEv;
        this.IdU = IdU;
    }

    @Override
    public String toString() {
        return "Publication{" + "dateP=" + dateP + ", IdEv=" + IdEv + ", IdU=" + IdU + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateP() {
        return dateP;
    }

    public void setDateP(Date dateP) {
        this.dateP = dateP;
    }

    public Evenement getIdEv() {
        return IdEv;
    }

    public void setIdEv(Evenement IdEv) {
        this.IdEv = IdEv;
    }

    public Utilisateur getIdU() {
        return IdU;
    }

    public void setIdU(Utilisateur IdU) {
        this.IdU = IdU;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
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
        final Publication other = (Publication) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
     
}
