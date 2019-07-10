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
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public void insertPS(Evenement t) {
        try {
            String requete="insert into evenement (nom,destination,date_depart,date_fin,promotion,nbPlace,idH,idR) values (?,?,?,?,?,?,?,?);";
            pst=connexion.getCnx().prepareStatement(requete);
            java.sql.Date sqldate1=new java.sql.Date(t.getDate_depart().getDate());
            java.sql.Date sqldate2=new java.sql.Date(t.getDate_fin().getDate());
            pst.setString(1, t.getNom());
            pst.setString(2, t.getDestination());
            pst.setDate(3, sqldate1);
            pst.setDate(4,sqldate2);
            pst.setInt(5, t.getPromotion());
            pst.setInt(6, t.getNbPlace());
            pst.setInt(7, t.getHtl().getIdH());
            pst.setInt(8, t.getRest().getIdR());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Evenement t) {
        try {
            String requete="update evenement set nom=?,destination=?,date_depart=?,date_fin=?,promotion=?,nbPlace=?,idH=?,idR=?  where idE=?";
            pst=connexion.getCnx().prepareStatement(requete);
            java.sql.Date sqldate1=new java.sql.Date(t.getDate_depart().getTime());
            java.sql.Date sqldate2=new java.sql.Date(t.getDate_fin().getTime());
            pst.setString(1, t.getNom());
            pst.setString(2, t.getDestination());
            pst.setDate(3, sqldate1);
            pst.setDate(4, sqldate2);
            pst.setInt(5, t.getPromotion());
            pst.setInt(6, t.getNbPlace());
            pst.setInt(7, t.getHtl().getIdH());
            pst.setInt(8, t.getRest().getIdR());
            pst.setInt(9, t.getIdE());
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
                Evenement event = new Evenement(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6), rs.getInt(7),hotel,resto);
                list.add(event);
            }
         
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Evenement readById(Object id) {
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
                event = new Evenement(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6), rs.getInt(7),hotel,resto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return event;
    }

    @Override
    public void delete(Evenement t) {
        try {
            String requete="delete from evenement where idE ="+t.getIdE();
            ste=connexion.getCnx().createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
