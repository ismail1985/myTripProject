/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import entite.Hotel;
import entite.Restaurant;
import java.sql.Date;

/**
 *
 * @author wyouness
 */
public class Evenement {
    private int idE;
    private String nom;
    private Date dure_reservation;
    private String destination;
    private Date date_depart;
    private int dure_trip;
    private int promotion;
    private int nbPlace;
    private Hotel htl;
    private Restaurant rest;

    public Evenement(String nom, Date dure_reservation, String destination, Date date_depart, int dure_trip, int promotion,int nbPlace, Hotel htl, Restaurant rest) {
        this.nom = nom;
        this.dure_reservation = dure_reservation;
        this.destination = destination;
        this.date_depart = date_depart;
        this.dure_trip = dure_trip;
        this.promotion = promotion;
        this.nbPlace=nbPlace;
        this.htl = htl;
        this.rest = rest;
    }

    public Evenement(int idE, String nom, Date dure_reservation, String destination, Date date_depart, int dure_trip, int promotion, int nbPlace, Hotel htl, Restaurant rest) {
        this.idE = idE;
        this.nom = nom;
        this.dure_reservation = dure_reservation;
        this.destination = destination;
        this.date_depart = date_depart;
        this.dure_trip = dure_trip;
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

    public Date getDure_reservation() {
        return dure_reservation;
    }

    public void setDure_reservation(Date dure_reservation) {
        this.dure_reservation = dure_reservation;
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

    public int getDure_trip() {
        return dure_trip;
    }

    public void setDure_trip(int dure_trip) {
        this.dure_trip = dure_trip;
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
