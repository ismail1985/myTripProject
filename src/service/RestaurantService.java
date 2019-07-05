/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Restaurant;
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
public class RestaurantService implements IService<Restaurant> {

    private DataSource connexion;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public RestaurantService() {
        connexion = DataSource.getInstance();
    }
  
@Override
    public void insert(Restaurant r) {
        try {
            
            String requete = "insert into restaurant (nom,adresse,email,code_postal,telephone,ville,description) values (?,?,?,?,?,?,?)";
            pst = connexion.getCnx().prepareStatement(requete);
            pst.setString(1, r.getNom());
            pst.setString(2, r.getAdresse());
            pst.setString(3, r.getEmail());
            pst.setInt(4, r.getCodePostal());
            pst.setInt(5,r.getTelephone());
            pst.setString(6, r.getVille());
            pst.setString(7, r.getDescription());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Restaurant r) {
        try {
            String requete = "update restaurant set nom=?, adresse =?, email =?, nb_etoile =?, code_postal =?, telephone =?, ville =?, description =? where id=?";
            pst = connexion.getCnx().prepareStatement(requete);
             pst.setString(1, r.getNom());
            pst.setString(2, r.getAdresse());
            pst.setString(3, r.getEmail());
            pst.setInt(4, r.getCodePostal());
            pst.setInt(5,r.getTelephone());
            pst.setString(6, r.getVille());
            pst.setString(7, r.getDescription());
            pst.setInt(8, r.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Restaurant> readAll() {
        List<Restaurant> list = new ArrayList<>();
        try {

            String requete = "select * from hotel";
            ste = connexion.getCnx().createStatement();
            rs = ste.executeQuery(requete);
            while (rs.next()) {
                Restaurant r = new Restaurant(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7));
                list.add(r);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
        public Restaurant readById(int id) {
        Restaurant r = null;
        try {

            String requete = "select * from restaurant where id =" + id;
            ste = connexion.getCnx().createStatement();
            rs = ste.executeQuery(requete);
            if (rs.first()) {
                 r = new Restaurant(rs.getString(1), rs.getString(2), rs.getInt(4), rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    @Override
    public void delete(Restaurant r) {
        try {
            String requete = "delete from restaurant where id =" + r.getId();
            ste = connexion.getCnx().createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
