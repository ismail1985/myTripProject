/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Utilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import service.UtilisateurService;

/**
 *
 * @author Mohamed
 */
public class AjouterUtilisateurController implements Initializable{
    
    @FXML
    private TextField fieldCIN;
    
    @FXML
    private TextField fieldNom;
    
    @FXML
    private TextField fieldPrenom;
    
    @FXML
    private TextField fieldEmail;
    
    @FXML
    private PasswordField fieldPassword;
    
    @FXML
    private TextField fieldProfil;
    
    @FXML
    private TextField fieldTelephone;
    
    @FXML
    private Button btnAjout;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnAjout.setOnAction(e -> {
        Utilisateur ut = new Utilisateur(
                fieldCIN.getText(),
                fieldNom.getText(),
                fieldPrenom.getText(),
                fieldEmail.getText(),
                fieldProfil.getText(),
                fieldPassword.getText(),
                Integer.parseInt(fieldTelephone.getText())
        );
        UtilisateurService utilisateuService = new UtilisateurService();
        utilisateuService.insert(ut);
        });
    }

}
