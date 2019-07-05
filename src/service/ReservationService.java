/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Reservation;
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
 * @author benamara
 */
public class ReservationService implements IService<Reservation> {

    private DataSource connexion;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public ReservationService() {
        connexion = DataSource.getInstance();
    }
  
    @Override
    public void insert(Reservation r) {
        try {
    
            String requete = "insert into reservation (date_arrive,date_depart,id_user,id_hotel,id_restaurant) values (?,?,?,?,?)";
            pst = connexion.getCnx().prepareStatement(requete);
            pst.setDate(1, r.getDateArrive());
            pst.setDate(2, r.getDateDepart());
            pst.setInt(3, r.getId());
            pst.setInt(4, r.getIdHotel());
            pst.setInt(5,r.getIdRestaurant());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Reservation r) {
        try {
            String requete = "update reservation set date_arrive=?, date_depart =?, id_user =?, id_hotel =?, id_restaurant =? where id=?";
            pst = connexion.getCnx().prepareStatement(requete);
            pst.setDate(1, r.getDateArrive());
            pst.setDate(2, r.getDateDepart());
            pst.setInt(3, r.getId());
            pst.setInt(4, r.getIdHotel());
            pst.setInt(5,r.getIdRestaurant());
            pst.setInt(6, r.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Reservation> readAll() {
        List<Reservation> list = new ArrayList<>();
        try {

            String requete = "select * from reservation";
            ste = connexion.getCnx().createStatement();
            rs = ste.executeQuery(requete);
            while (rs.next()) {
                Reservation r = new Reservation(rs.getDate(1), rs.getDate(2), rs.getInt(3), rs.getInt(4),rs.getInt(5));
                list.add(r);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
        public Reservation readById(int id) {
        Reservation r = null;
        try {

            String requete = "select * from reservation where id =" + id;
            ste = connexion.getCnx().createStatement();
            rs = ste.executeQuery(requete);
            if (rs.first()) {
                r = new Reservation(rs.getDate(1), rs.getDate(2), rs.getInt(3), rs.getInt(4),rs.getInt(5));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    @Override
    public void delete(Reservation r) {
        try {
            String requete = "delete from reservation where id =" + r.getId();
            ste = connexion.getCnx().createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

