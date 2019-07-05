/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Publication;
import entite.Evenement;
import entite.Utilisateur;
import java.sql.Date;
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
 * @author Rihab
 */
public class PublicationService  implements IService<Publication>{
    
    private DataSource connexion;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public PublicationService() {
        connexion = DataSource.getInstance();
    }

    @Override
    public void insert(Publication t) {
        try {
            
            
            String requete="insert into publication(date,id_eve,id_user) values (?,?,?)";
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setDate(1, new java.sql.Date(t.getDateP().getTime()));
            pst.setInt(2, t.getIdEv().getIdE());
            pst.setInt(3, t.getIdU().getIdU());
           
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PublicationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public void update(Publication t) {
        try {
            String requete="update publication set date=?,id_ev=?,id_user=? where idE=?";
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setDate(1, new java.sql.Date(t.getDateP().getTime()));
            pst.setInt(2, t.getIdEv().getIdE());
            pst.setInt(3, t.getIdU().getIdU());
           
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PublicationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Publication> readAll() {
        List<Publication> list=new ArrayList<>();
        try {
           
            String requete="select * from publication";
            ste=connexion.getCnx().createStatement();
            rs=ste.executeQuery(requete);
            EvenementService eventService = new EvenementService(); 
            UtilisateurService utilisateurSerice = new UtilisateurService();
            while(rs.next()){
                Evenement event  = eventService.readById(rs.getInt(3));
                Utilisateur utilisateur = utilisateurSerice.readById(rs.getInt(4));
                Publication p = new Publication(rs.getInt(1), rs.getDate(2), event, utilisateur);
                list.add(p);
            }
         
            
        } catch (SQLException ex) {
            Logger.getLogger(PublicationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Publication readById(int id) {
        Publication p = null;
        try {

            String requete = "select * from publication where id =" + id;
            ste = connexion.getCnx().createStatement();
            rs = ste.executeQuery(requete);
            UtilisateurService utilisateurService = new UtilisateurService();
            EvenementService evenementService = new EvenementService();
            if (rs.first()) {
                Utilisateur ut = utilisateurService.readById(3);
                Evenement event = evenementService.readById(4);
                 p = new Publication(rs.getInt(1), rs.getDate(2), event, ut);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PublicationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
        
    }

    @Override
    public void delete(Publication t) {
         
        try {
            String requete="delete from publication where id ="+t.getId();
            ste=connexion.getCnx().createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(PublicationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteById(int id) {
         try {
            String requete="delete from publication where id ="+ id;
            ste=connexion.getCnx().createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(PublicationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    }
 


    