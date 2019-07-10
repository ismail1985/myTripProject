/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.util.Date;

/**
 *
 * @author wyouness
 */
public class Evenement {
    private int idE;
    private String nom;
    private String destination;
    private Date date_depart;
    private Date date_fin;
    private int promotion;
    private int nbPlace;
    private Hotel htl;
    private Restaurant rest;

    public Evenement() {
    }
    

    public Evenement(String nom, String destination, Date date_depart, Date date_fin, int promotion, int nbPlace, Hotel htl, Restaurant rest) {
        this.nom = nom;
        this.destination = destination;
        this.date_depart = date_depart;
        this.date_fin = date_fin;
        this.promotion = promotion;
        this.nbPlace = nbPlace;
        this.htl = htl;
        this.rest = rest;
    }

    public Evenement(int idE, String nom, String destination, Date date_depart, Date date_fin, int promotion, int nbPlace, Hotel htl, Restaurant rest) {
        this.idE = idE;
        this.nom = nom;
        this.destination = destination;
        this.date_depart = date_depart;
        this.date_fin = date_fin;
        this.promotion = promotion;
        this.nbPlace = nbPlace;
        this.htl = htl;
        this.rest = rest;
    }

    

    

    public int getIdE() {
        return idE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(Date date_depart) {
        this.date_depart = date_depart;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }
    
    

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }

    public Hotel getHtl() {
        return htl;
    }

    public void setHtl(Hotel htl) {
        this.htl = htl;
    }

    public Restaurant getRest() {
        return rest;
    }

    public void setRest(Restaurant rest) {
        this.rest = rest;
    }

    
    
    
    @Override
    public int hashCode() {
        return idE+nom.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evenement other = (Evenement) obj;
        if (this.idE != other.idE) {
            return false;
        }
        return true;
    }
    
    
    
    
}
