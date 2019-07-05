/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Evenement;
import entite.Reclamation;
import entite.Utilisateur;
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
 * @author Mohamed
 */
public class ReclamationService implements IService<Reclamation>{
 private DataSource connexion;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public ReclamationService() {
        connexion=DataSource.getInstance();
    }
    
    @Override
    public void insert(Reclamation t) {
       try {
            String requete="insert into Reclamation  (nom,prenom) values (?,?)";
           pst=connexion.getCnx().prepareStatement(requete);
            pst.setInt(1, t.getIdrec());
            pst.setDate(2, t.getDate_rec());
            pst.setString(3, t.getTitre());
            pst.setString(4, t.getDescription());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        } 
} 

    @Override
    public void update(Reclamation t) {
        try {
            String requete="update Reclamation set description=?, =? where idrec=?";
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setString(1, t.getDescription());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }}

    @Override
    public List<Reclamation> readAll() {
        List<Reclamation> list=new ArrayList<>();
        try {
           
            String requete="select * from reclamation";
            ste=connexion.getCnx().createStatement();
            rs=ste.executeQuery(requete);
            UtilisateurService utilisateurService = new UtilisateurService();
            EvenementService evenementService = new EvenementService();
            while(rs.next()){
                Utilisateur utilisateur = utilisateurService.readById(6);
                Evenement evenement = evenementService.readById(5);
                Reclamation reclamation = new Reclamation(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), evenement, utilisateur);
                list.add(reclamation);
            }
         
            
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        }

    @Override
    public Reclamation readById(int id) {
        Reclamation reclamation = null;
        try {
           
            String requete="select * from utilisateur where idU ="+id;
            ste=connexion.getCnx().createStatement();
            rs=ste.executeQuery(requete);
            UtilisateurService utilisateurService = new UtilisateurService();
            EvenementService evenementService = new EvenementService();
            if(rs.first()){
                Utilisateur utilisateur = utilisateurService.readById(6);
                Evenement evenement = evenementService.readById(5);
                reclamation = new Reclamation(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), evenement, utilisateur);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reclamation;
    }

    @Override
    public void delete(Reclamation t) {
        try {
            String requete="delete from reclamation where id ="+t.getIdrec();
            ste=connexion.getCnx().createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        } }
}
