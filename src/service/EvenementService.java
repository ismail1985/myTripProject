/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Evenement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.IService;
import entite.Hotel;
import entite.Restaurant;
import entite.Utilisateur;
import utils.DataSource;

/**
 *
 * @author wyouness
 */
public class EvenementService implements IService<Evenement>{
    private DataSource connexion;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public EvenementService() {
        connexion=DataSource.getInstance();
       
    }
   
    @Override
    public void insert(Evenement t) {
        try {
            String requete="insert into evenement (nom,dure_reservation,destination,date_depart,dure_trip,promotion,htl,rest) values (?,?,?,?,?,?,?,?,?)";
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setString(1, t.getNom());
            pst.setDate(2, t.getDure_reservation());
            pst.setString(3, t.getDestination());
            pst.setDate(4, t.getDate_depart());
            pst.setInt(5, t.getDure_trip());
            pst.setInt(6, t.getPromotion());
            pst.setInt(7, t.getNbPlace());
            pst.setInt(8, t.getHtl().getId());
            pst.setInt(9, t.getRest().getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Evenement t) {
        try {
            String requete="update evenement set nom=?,dure_reservation=?,destination,date_depart=?,dure_trip,promotion=?,htl=?,rest=?  where idE=?";
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setString(1, t.getNom());
            pst.setDate(2, t.getDure_reservation());
            pst.setString(3, t.getDestination());
            pst.setDate(4, t.getDate_depart());
            pst.setInt(5, t.getDure_trip());
            pst.setInt(6, t.getPromotion());
            pst.setInt(7, t.getNbPlace());
            pst.setInt(8, t.getHtl().getId());
            pst.setInt(9, t.getRest().getId());
            pst.setInt(10, t.getIdE());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Evenement> readAll() {
         List<Evenement> list=new ArrayList<>();
        try {
           
            String requete="select * from evenement";
            ste=connexion.getCnx().createStatement();
            rs=ste.executeQuery(requete);
            RestaurantService restaurantService = new RestaurantService();
            HotelService hotelService = new HotelService();
            while(rs.next()){
                Hotel hotel = hotelService.readById(rs.getInt(9));
                Restaurant resto = restaurantService.readById(rs.getInt(8));
                Evenement event = new Evenement(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getDate(5), rs.getInt(6), rs.getInt(7), rs.getInt(10),hotel,resto);
                list.add(event);
            }
         
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Evenement readById(int id) {
         Evenement event = null;
        try {
           
            String requete="select * from evenement where idE ="+id;
            ste=connexion.getCnx().createStatement();
            rs=ste.executeQuery(requete);
            RestaurantService restaurantService = new RestaurantService();
            HotelService hotelService = new HotelService();
            if(rs.first()) {
                Restaurant resto = restaurantService.readById(rs.getInt(8));
                Hotel hotel = hotelService.readById(rs.getInt(9));
                event = new Evenement(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getDate(5), rs.getInt(6), rs.getInt(7), rs.getInt(10),hotel,resto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return event;
    }

    @Override
    public void delete(Evenement t) {
        try {
            String requete="delete from evenement where id ="+t.getIdE();
            ste=connexion.getCnx().createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
