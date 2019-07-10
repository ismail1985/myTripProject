/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Publication;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import service.PublicationService;

/**
 * FXML Controller class
 *
 * @author Rihab
 */
public class AfficherPublicationController implements Initializable {

    private TableView<Publication> TablePublication;
    private TableColumn<Publication, Integer> fieldId;
    private TableColumn<Publication, String> fieldContenuP;
    private TableColumn<Publication, Date> fieldDateP;
    private TableColumn<Publication, Integer> fieldIdE;
    private TableColumn<Publication, Integer> fieldIdU;
    private Button btnPublier;
    private Button btn_retour;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        PublicationService pubService=new PublicationService();
        
        List<Publication> list=pubService.readAll();
        
        ObservableList<Publication> obs=FXCollections.observableArrayList(list);
        
       fieldIdU.setCellValueFactory(new PropertyValueFactory<>("idU"));
       fieldContenuP.setCellValueFactory(new PropertyValueFactory<>("contenu_publication"));
       fieldDateP.setCellValueFactory(new PropertyValueFactory<>("date_Publication"));
       fieldIdE.setCellValueFactory(new PropertyValueFactory<>("Id_evenement"));
       fieldId.setCellValueFactory(new PropertyValueFactory<>("numero_Pub"));
       
      
       
       
TablePublication.setItems(obs);
    } 
    private void AjouterPublication(ActionEvent event) {
        Parent root;
        
        try {
            root=FXMLLoader.load(getClass().getResource("AjouterPublication.fxml"));
            btnPublier.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherPublicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void retour_utilisateur(ActionEvent event) {
        Parent root;
        
        try {
            root=FXMLLoader.load(getClass().getResource("AfficherEvenement.fxml"));
            btn_retour.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherPublicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
