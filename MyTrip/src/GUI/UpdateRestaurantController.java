/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Restaurant;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import service.RestaurantService;

/**
 * FXML Controller class
 *
 * @author benamara
 */
public class UpdateRestaurantController implements Initializable {

    @FXML
    private Button btnUpdate;

    @FXML
    private TextField nom;

    @FXML
    private TextField adresse;

    @FXML
    private TextField codePostal;

    @FXML
    private TextField ville;

    @FXML
    private TextField email;

    @FXML
    private TextField telephone;

    @FXML
    private TextArea description;

    @FXML
    private Label idRestaurant;

    @FXML
    private void ActionUpdate(ActionEvent event) {
        Restaurant resto = new Restaurant(
                Integer.parseInt(idRestaurant.getText()),
                nom.getText(),
                adresse.getText(),
                Integer.parseInt(telephone.getText()),
                email.getText(),
                Integer.parseInt(codePostal.getText()),
                ville.getText(),
                description.getText()
        );
        RestaurantService Rs = new RestaurantService();
        Rs.update(resto);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}

/**
 * Initializes the controller class.
 */

