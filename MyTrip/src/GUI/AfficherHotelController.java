/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Hotel;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import service.HotelService;

/**
 *
 * @author Mohamed
 */
public class AfficherHotelController implements Initializable {

    @FXML
    private TableView<Hotel> tablehotel;

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
    private TableColumn<?, ?> NbEtoile;

    @FXML
    private TableColumn<?, ?> description;

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
            Parent root = FXMLLoader.load(getClass().getResource("AjouterHotel.fxml"));
            BtnAjout.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherHotelController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void ActionSupprimer(ActionEvent event) {
        HotelService hs = new HotelService();
        Hotel hotel = hs.readById(Integer.valueOf(idH.getText()));
        if (hotel == null) {
            System.out.println("l'hotel n'existe pas");
        }
        hs.delete(Integer.valueOf(idH.getText()));

    }

    @FXML
    void ActionUpdate(ActionEvent event) {
   try {
            Parent root = FXMLLoader.load(getClass().getResource("UpdateHotel.fxml"));
            BtnAjout.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherHotelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        HotelService hotelservice = new HotelService();
        List<Hotel> list = hotelservice.readAll();
        {

            ObservableList<Hotel> obs = FXCollections.observableArrayList(list);

            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
            adresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
            codePostal.setCellValueFactory(new PropertyValueFactory<>("codePostale"));
            ville.setCellValueFactory(new PropertyValueFactory<>("Ville"));
            email.setCellValueFactory(new PropertyValueFactory<>("Email"));
            telephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
            NbEtoile.setCellValueFactory(new PropertyValueFactory<>("NbEtoile"));
            description.setCellValueFactory(new PropertyValueFactory<>("Description"));

            tablehotel.setItems(obs);

            HotelService hotelService = new HotelService();
            hotelService.readById(2);

            BtnSupprimer.setOnAction(e -> {
                int idH = Integer.parseInt(id.getText());
                hotelService.delete(idH);
            });
        }
    }

}
