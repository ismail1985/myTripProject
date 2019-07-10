/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.sql.Date;

/**
 *
 * @author wyouness
 */
public class Participation {
    private Evenement eve;
    private Utilisateur user;
    private Date date_parti;

    public Participation(Evenement eve, Utilisateur user, Date date_parti) {
        this.eve = eve;
        this.user = user;
        this.date_parti = date_parti;
    }

    

    public Evenement getEve() {
        return eve;
    }

    public void setEve(Evenement eve) {
        this.eve = eve;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public Date getDate_parti() {
        return date_parti;
    }

    public void setDate_parti(Date date_parti) {
        this.date_parti = date_parti;
    }
    @Override
    public int hashCode() {
        return eve.getIdE()+user.getIdU();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Participation other = (Participation) obj;
        return (this.eve.getIdE()==other.getEve().getIdE()
                && this.user.getIdU()==other.getUser().getIdU());
    }
}
