/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Hotel;
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
import service.HotelService;
import service.RestaurantService;

/**
 * FXML Controller class
 *
 * @author benamara
 */
public class AjouterRestaurantController implements Initializable {

    @FXML
    private Button btnAjout;

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
    private Label description;

    @FXML
    void ActionAjout(ActionEvent event) {
        Restaurant restaurant = new Restaurant(
                nom.getText(),
                adresse.getText(),
                Integer.parseInt(telephone.getText()),
                email.getText(),
                Integer.parseInt(codePostal.getText()),
                ville.getText(),
                description.getText()
        );
        RestaurantService restaurantService = new RestaurantService();
        restaurantService.insert(restaurant);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
