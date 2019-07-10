/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Evenement;
import entite.Participation;
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
 * @author wyouness
 */
public class ParticipationService{
        private DataSource connexion;
        private Statement ste;
        private PreparedStatement pst;
        private ResultSet rs;


    
    public void insertPS(Participation p) {
        try {
            String requete="insert into participation (idE,idU,date_parti) values (?,?,?)";
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setInt(1, p.getEve().getIdE());
            pst.setInt(2, p.getUser().getIdU());
            pst.setDate(3, p.getDate_parti());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void update(Participation p) {
        try {
            String requete="update participation set date_parti=?  where idE=? and idU=?";
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setDate(1, p.getDate_parti());
            pst.setInt(2, p.getEve().getIdE());
            pst.setInt(3, p.getUser().getIdU());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ParticipationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public List<Participation> readAll() {
         List<Participation> list=new ArrayList<>();
        try {
           
            String requete="select * from participation";
            ste=connexion.getCnx().createStatement();
            rs=ste.executeQuery(requete);
            EvenementService eveService = new EvenementService();
            UtilisateurService utilService = new UtilisateurService();
            while(rs.next()){
                Evenement eve = eveService.readById(rs.getInt(1));
                Utilisateur user = utilService.readById(rs.getInt(2));
                Participation parti = new Participation(eve,user,rs.getDate(3));
                list.add(parti);
            }
         
            
        } catch (SQLException ex) {
            Logger.getLogger(ParticipationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    
    public Participation readById(int id1,int id2) {
            
                Participation parti = null;
                
            try {  
                String requete="select * from participation where idE ="+id1+" and idU ="+id2;
                ste=connexion.getCnx().createStatement();
                rs=ste.executeQuery(requete);
                EvenementService eveService = new EvenementService();
                UtilisateurService utilService = new UtilisateurService();
                if(rs.first()) {
                    Evenement eve = eveService.readById(rs.getInt(1));
                    Utilisateur user = utilService.readById(rs.getInt(2));
                    parti = new Participation(eve,user,rs.getDate(3));
                }
                
                
            }catch (SQLException ex) {
                Logger.getLogger(ParticipationService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return parti;
    }

    
    public void delete(Participation p) {
        try {
            String requete="delete from participation where idE ="+p.getEve().getIdE()+" and idU ="+p.getUser().getIdU();
            ste=connexion.getCnx().createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(ParticipationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
