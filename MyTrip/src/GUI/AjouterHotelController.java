/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Hotel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import service.HotelService;

/**
 * FXML Controller class
 *
 * @author benamara
 */
public class AjouterHotelController implements Initializable {

    @FXML
    private Button btnAjout;
    @FXML
    private TextField nom;

    @FXML
    private TextField adresse;

    @FXML
    private TextField codePostal;

    @FXML
    private TextField NbEtoile;

    @FXML
    private TextField ville;

    @FXML
    private TextField email;

    @FXML
    private TextField telephone;

    @FXML
    private TextArea description;

    @FXML
    void ActionAjout(ActionEvent event) {
        Hotel hotel = new Hotel(
                nom.getText(),
                adresse.getText(),
                Integer.parseInt(NbEtoile.getText()),
                telephone.getText(),
                email.getText(),
                Integer.parseInt(codePostal.getText()),
                ville.getText(),
                description.getText()
        );
        HotelService hotelService = new HotelService();
        hotelService.insert(hotel);

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
