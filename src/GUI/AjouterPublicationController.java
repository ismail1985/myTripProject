/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Publication;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import service.PublicationService;

/**
 * FXML Controller class
 *
 * @author Rihab
 */
public class AjouterPublicationController implements Initializable {

    @FXML
    private TextArea fieldtext;
    @FXML
    private Button ajout;
    @FXML
    private TextField fieldtitre;
    @FXML
    private TextField fieldDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ajout.setOnAction(e -> {
            Publication pub = new Publication(
                fieldtext.getText(),
                fieldDate.getText(),
                fieldtitre.getText(),
                
                
            );
            PublicationService pubService = new PublicationService();
        pubService.insert(pub);
        });
        // TODO
    }    
    
}
