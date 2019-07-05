/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetmytrip;

import entite.Evenement;
import entite.Hotel;
import entite.Publication;
import entite.Restaurant;
import entite.Utilisateur;
import java.util.Date;
import java.util.List;
import service.HotelService;
import service.IService;
import service.UtilisateurService;
import utils.DataSource;

/**
 *
 * @author Mohamed
 */
public class ProjetMyTrip {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
   DataSource ds1=DataSource.getInstance();
  
   Utilisateur utilisateur = new Utilisateur(2, "06960258", "Kalboussi", "wassim", "wass@domail.com", "user", "1995", 52676157);
   IService utilisateurService = new UtilisateurService();
   Hotel htl = new Hotel("laico", "20 rue palestine", 72355145, 55, "laico@laico.tn", 0, "tunis", "5 etoiles");
   Restaurant rest = new Restaurant("grand bleu", "20 rue egypte", 72366987, "gb@grandbleu.tn", 8300, "hammamet", "3 fourchettes");
   Date date = new Date(2019,12,31);
   Evenement event  = new Evenement(1,"trip", new java.sql.Date(date.getTime()),"hammamet",new java.sql.Date(date.getTime()), 7,20, 50, htl.getId(), rest.getId());
   IService hotelService = new HotelService(); 
   Publication publication;
   publication = new Publication(1, new Date(), event, utilisateur);
   //INSERT
   utilisateurService.insert(utilisateur); 
   
   //UPDATE
   //utilisateur.setIdU(2);
   //utilisateur.setEmail("wass@domain.com");
   //utilisateurService.update(utilisateur);
   
   //READ BY ID
   //Utilisateur ut = (Utilisateur) utilisateurService.readById(2);
   //System.out.println(ut.toString());
   
   //READ ALL
   //List<Utilisateur> utList =  utilisateurService.readAll();
   //System.out.println(utList.toString());
   
   //DELETE
   //utilisateur.setIdU(1);
   //utilisateurService.delete(utilisateur);
   
   //INSERT
  Hotel hotel = new Hotel("3ayechi", "Tuis", 5, 25457898, "hotelayachi@localhost", 2525, "Tunis", "Matjiwech");
  hotelService.insert(hotel);
    }
    
}
