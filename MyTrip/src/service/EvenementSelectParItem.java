/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Evenement;
import entite.Hotel;
import entite.Restaurant;
import entite.Utilisateur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author wyouness
 */
public class EvenementSelectParItem {
    private DataSource connexion;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public EvenementSelectParItem() {
        connexion=DataSource.getInstance();
    }
    public Evenement readById(Object idE) {
        Evenement event = null;
        try {
           
            String requete="select * from evenement where idE ="+idE;
            ste=connexion.getCnx().createStatement();
            rs=ste.executeQuery(requete);
            RestaurantService restaurantService = new RestaurantService();
            HotelService hotelService = new HotelService();
            if(rs.first()) {
                Restaurant resto = restaurantService.readById(rs.getInt(8));
                Hotel hotel = hotelService.readById(rs.getInt(9));
                event = new Evenement(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6), rs.getInt(7),hotel,resto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return event;
    }
    public Evenement readByNom(Object nom) {
        Evenement event = null;
        try {
           
            String requete="select * from evenement where nom ="+nom;
            ste=connexion.getCnx().createStatement();
            rs=ste.executeQuery(requete);
            RestaurantService restaurantService = new RestaurantService();
            HotelService hotelService = new HotelService();
            if(rs.first()) {
                Restaurant resto = restaurantService.readById(rs.getInt(8));
                Hotel hotel = hotelService.readById(rs.getInt(9));
                event = new Evenement(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6), rs.getInt(7),hotel,resto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return event;
    }
    public Evenement readByDestination(Object destination) {
        Evenement event = null;
        try {
           
            String requete="select * from evenement where destination ="+destination;
            ste=connexion.getCnx().createStatement();
            rs=ste.executeQuery(requete);
            RestaurantService restaurantService = new RestaurantService();
            HotelService hotelService = new HotelService();
            if(rs.first()) {
                Restaurant resto = restaurantService.readById(rs.getInt(8));
                Hotel hotel = hotelService.readById(rs.getInt(9));
                event = new Evenement(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6), rs.getInt(7),hotel,resto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return event;
    }
    public Evenement readBynbPlace(Object nbPlace) {
        Evenement event = null;
        try {
           
            String requete="select * from evenement where nbPlace ="+nbPlace;
            ste=connexion.getCnx().createStatement();
            rs=ste.executeQuery(requete);
            RestaurantService restaurantService = new RestaurantService();
            HotelService hotelService = new HotelService();
            if(rs.first()) {
                Restaurant resto = restaurantService.readById(rs.getInt(8));
                Hotel hotel = hotelService.readById(rs.getInt(9));
                event = new Evenement(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6), rs.getInt(7),hotel,resto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return event;
    }
    public Evenement readByPromotion(Object promotion) {
        Evenement event = null;
        try {
           
            String requete="select * from evenement where promotion ="+promotion;
            ste=connexion.getCnx().createStatement();
            rs=ste.executeQuery(requete);
            RestaurantService restaurantService = new RestaurantService();
            HotelService hotelService = new HotelService();
            if(rs.first()) {
                Restaurant resto = restaurantService.readById(rs.getInt(8));
                Hotel hotel = hotelService.readById(rs.getInt(9));
                event = new Evenement(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6), rs.getInt(7),hotel,resto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return event;
    }
    public Evenement readByhotel(Object idH) {
        Evenement event = null;
        try {
           
            String requete="select * from evenement where idH ="+idH;
            ste=connexion.getCnx().createStatement();
            rs=ste.executeQuery(requete);
            RestaurantService restaurantService = new RestaurantService();
            HotelService hotelService = new HotelService();
            if(rs.first()) {
                Restaurant resto = restaurantService.readById(rs.getInt(8));
                Hotel hotel = hotelService.readById(rs.getInt(9));
                event = new Evenement(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6), rs.getInt(7),hotel,resto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return event;
    }
    public Evenement readByResto(Object idR) {
        Evenement event = null;
        try {
           
            String requete="select * from evenement where idR ="+idR;
            ste=connexion.getCnx().createStatement();
            rs=ste.executeQuery(requete);
            RestaurantService restaurantService = new RestaurantService();
            HotelService hotelService = new HotelService();
            if(rs.first()) {
                Restaurant resto = restaurantService.readById(rs.getInt(8));
                Hotel hotel = hotelService.readById(rs.getInt(9));
                event = new Evenement(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6), rs.getInt(7),hotel,resto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return event;
    }
    
    
}
