/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Utilisateur;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.UtilisateurService;

/**
 *
 * @author Mohamed
 */
public class AfficherUtilisateurController implements Initializable{
    @FXML
    private TableView<Utilisateur> tableUtilisateur;
    @FXML
    private TableColumn<Utilisateur, Integer> fieldIdU;
    @FXML
    private TableColumn<Utilisateur, String> fieldCIN;
    @FXML
    private TableColumn<Utilisateur, String> fieldNom;
    @FXML
    private TableColumn<Utilisateur, String> fieldPrenom;
    @FXML
    private TableColumn<Utilisateur, String> fieldEmail;
    @FXML
    private TableColumn<Utilisateur, String> fieldProfil;
    @FXML
    private TableColumn<Utilisateur, String> fieldTelephone;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        UtilisateurService utService=new UtilisateurService();
        
        List<Utilisateur> list=utService.readAll();
        
        ObservableList<Utilisateur> obs=FXCollections.observableArrayList(list);
        
       fieldIdU.setCellValueFactory(new PropertyValueFactory<>("idU"));
       fieldCIN.setCellValueFactory(new PropertyValueFactory<>("cin"));
       fieldNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
       fieldPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
       fieldEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
       fieldProfil.setCellValueFactory(new PropertyValueFactory<>("profil"));
       fieldTelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
      
       
       
tableUtilisateur.setItems(obs);
}
}
