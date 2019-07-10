/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Hotel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.IService;
import service.IService;
import utils.DataSource;

/**
 *
 * @author benamara
 */
public class HotelService implements IService<Hotel> {

    private DataSource connexion;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public HotelService() {
        connexion = DataSource.getInstance();

    }
  
    @Override
    public void insertPS(Hotel h) {
        try {
            String requete = "insert into hotel (nom,adresse,nb_etoile,telephone,email,code_postal,ville,description) values (?,?,?,?,?,?,?,?)";
            pst = connexion.getCnx().prepareStatement(requete);
            pst.setString(1, h.getNom());
            pst.setString(2, h.getAdresse());
            pst.setInt(3, h.getNb_etoile());
            pst.setString(4, h.getTelephone());
            pst.setString(5, h.getEmail());
            pst.setInt(6,h.getCode_postal());
            pst.setString(7, h.getVille());
            pst.setString(8, h.getDescription());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HotelService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Hotel h) {
        try {
            String requete = "update hotel set nom=?, adresse =?,nb_etoile=?,telephone=?,email=?,code_postal=?, ville =?, description =? where idH=?";
            pst = connexion.getCnx().prepareStatement(requete);
            pst.setString(1, h.getNom());
            pst.setString(2, h.getAdresse());
            pst.setInt(3, h.getNb_etoile());
            pst.setString(4, h.getTelephone());
            pst.setString(5, h.getEmail());
            pst.setInt(6,h.getCode_postal());
            pst.setString(7, h.getVille());
            pst.setString(8, h.getDescription());
            pst.setInt(9, h.getIdH());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HotelService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Hotel> readAll() {
        List<Hotel> list = new ArrayList<>();
        try {

            String requete = "select * from hotel";
            ste = connexion.getCnx().createStatement();
            rs = ste.executeQuery(requete);
            while (rs.next()) {
                Hotel h = new Hotel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9));
                list.add(h);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HotelService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
        public Hotel readById(Object id) {
        Hotel h = null;
        try {

            String requete = "select * from hotel where idH =" + id;
            ste = connexion.getCnx().createStatement();
            rs = ste.executeQuery(requete);
            if (rs.first()) {
                h=new Hotel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9));
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(HotelService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return h;
    }

    @Override
    public void delete(Hotel h) {
        try {
            String requete = "delete from hotel where idH =" + h.getIdH();
            ste = connexion.getCnx().createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(HotelService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}