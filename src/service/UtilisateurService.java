/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

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
 * @author wiemhjiri
 */
public class UtilisateurService implements IService<Utilisateur> {
 private DataSource connexion;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public UtilisateurService() {
        connexion=DataSource.getInstance();
    }

    @Override
    public void insert(Utilisateur t) {
        try {
            String requete="insert into utilisateur(cin,nom, prenom, email, profil, password,telephone) values ("+t.getCin()+","+t.getNom()+","+t.getPrenom()+","+t.getEmail()+","+t.getProfil()+","+t.getPassword()+","+t.getTelephone()+")";
            ste=connexion.getCnx().createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
           Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//public void insertPS(Utilisateur t) {
//        try {
//            String requete="insert into personne idU,cin,nom, prenom, email,profil, password,telephone) values (?,?,?,?,?,?,?,?)";
//           pst=connexion.getCnx().prepareStatement(requete);
//            pst.setInt(1, t.getIdU());
//            pst.setString(2, t.getCin());
//            pst.setString(3, t.getNom());
//            pst.setString(4, t.getPrenom());
//            pst.setString(5, t.getEmail());
//            pst.setString(6, t.getProfil());
//            pst.setString(7, t.getPassword());
//            pst.setInt(8, t.getTelephone());
//            pst.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(UtilisateurServiceImp.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    @Override
    public void update(Utilisateur t) {
         try {
            String requete="update utilisateur set cin=?, nom=?, prenom =?, email=?, profil=?, password=?, telephone=? where idU=?";
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setString(1, t.getCin());
            pst.setString(2, t.getNom());
            pst.setString(3, t.getPrenom());
            pst.setString(4, t.getEmail());
            pst.setString(5, t.getProfil());
            pst.setString(6, t.getPassword());
            pst.setInt(7, t.getTelephone());
            pst.setInt(8, t.getIdU());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<Utilisateur> readAll() {
      List<Utilisateur> list=new ArrayList<>();
        try {
           
            String requete="select * from utilisateur";
            ste=connexion.getCnx().createStatement();
            rs=ste.executeQuery(requete);
            while(rs.next()){
                Utilisateur ut =new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                list.add(ut);
            }
         
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Utilisateur readById(int id) {
      Utilisateur ut = null;
        try {
           
            String requete="select * from utilisateur where idU ="+id;
            ste=connexion.getCnx().createStatement();
            rs=ste.executeQuery(requete);
            if(rs.first())
                ut = new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
              
        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ut;
    }

    @Override
    public void delete(Utilisateur t) {
        //Pourquoi on ne passe pas directement en parametre l'id à la place de l'utilisateur
          try {
            String requete="delete from utilisateur where idU ="+t.getIdU();
            ste=connexion.getCnx().createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
