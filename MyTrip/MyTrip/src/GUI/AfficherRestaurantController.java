/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Restaurant;
import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import service.RestaurantService;

/**
 *
 * @author Mohamed
 */
public class AfficherRestaurantController implements Initializable {

    @FXML
    private TableView<Restaurant> tableRestaurant;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> nom;

    @FXML
    private TableColumn<?, ?> adresse;

    @FXML
    private TableColumn<?, ?> codePostal;

    @FXML
    private TableColumn<?, ?> ville;

    @FXML
    private TableColumn<?, ?> email;

    @FXML
    private TableColumn<?, ?> telephone;

    @FXML
    private TableColumn<?, ?> description;

    @FXML
    private Label idR;

    @FXML
    private TextField idH;

    @FXML
    private Button BtnSupprimer;

    @FXML
    private Button BtnAjout;

    @FXML
    private Button BtnUpdate;

    @FXML
    void ActionAjouter(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AjouterRestaurant.fxml"));
            BtnAjout.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherHotelController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void ActionSupprimer(ActionEvent event) {
        RestaurantService Rs = new RestaurantService();
        Restaurant hotel = Rs.readById(Integer.valueOf(idH.getText()));
        if (hotel == null) {
            System.out.println("le restaurant n'existe pas");
        }
        Rs.delete(Integer.valueOf(idH.getText()));

    }

    @FXML
    void ActionUpdate(ActionEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("UpdateRestaurant.fxml"));
            BtnAjout.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherHotelController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RestaurantService restaurantservice = new RestaurantService();
        List<Restaurant> list = restaurantservice.readAll();
        {

            ObservableList<Restaurant> obs = FXCollections.observableArrayList(list);

            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
            adresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
            codePostal.setCellValueFactory(new PropertyValueFactory<>("codePostale"));
            ville.setCellValueFactory(new PropertyValueFactory<>("Ville"));
            email.setCellValueFactory(new PropertyValueFactory<>("Email"));
            telephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));

            description.setCellValueFactory(new PropertyValueFactory<>("Description"));

            tableRestaurant.setItems(obs);

            RestaurantService restaurantService = new RestaurantService();

            restaurantService.readById(2);

            BtnSupprimer.setOnAction(e -> {
                int idR = Integer.parseInt(id.getText());
                restaurantService.delete(idR);
            });
        }

    }

}
