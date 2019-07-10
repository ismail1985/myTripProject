/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Evenement;
import entite.Publication;
import entite.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import service.EvenementService;
import service.PublicationService;
import service.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author Rihab
 */
public class AjouterPublicationController implements Initializable {

    @FXML
    private TextArea contenuPublication;
    @FXML
    private Button btnValid;
    @FXML
    private Button bntModif;
    @FXML
    private Button bntDelet;
    @FXML
    private Button btnBack;
    @FXML
    private TextField fieldNomUser;
    @FXML
    private Label datePubl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnValid.setOnAction(e->{
        Publicatione p=new Publication(Id, contenuP.getText(), dateP, IdEv, IdU);
        PublicationService pubservice=new PublicationService();
        
        pubservice.insert(p);
       });
        
    }    
    @FXML
    private void Ajouter_Publication(ActionEvent event) {
                                                
            EvenementService eventser = new EvenementService();
            Evenement evenement= eventser.readById(IdE);
            UtilisateurService userService = new UtilisateurService();
            Utilisateur user=userService.readById(IdU);
            Date dateP = new Date();
            PublicationService pubservice=new PublicationService();
           
        
       
        Publication pub = new Publication(Integer.valueOf(fieldId.getText()), contenPublication.getText(),dateP,Integer.valueOf(Id_ev.getText()), Integer.valueOf(Id_user.getText()));
        PublicationService pservice=new PublicationService();
        
        pservice.insert(pub);
        System.out.println("Publication ajoutée");
        
        Parent root;
        
        try {
            root=FXMLLoader.load(getClass().getResource("Affichage.fxml"));
            btnValid.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AjouterPublicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    
    }
}
