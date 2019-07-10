/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.sun.javafx.scene.control.skin.IntegerFieldSkin;
import entite.Evenement;
import entite.Hotel;
import entite.Restaurant;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;
import service.EvenementSelectParItem;
import service.EvenementService;
import service.HotelService;
import service.RestaurantService;

/**
 * FXML Controller class
 *
 * @author wyouness
 */
public class EvenementController implements Initializable {
    
    ObservableList<String> categoriesList=FXCollections.observableArrayList("idE","nom","destination","date_debut","date_fin","promotion","nbPlace","idH","idR");
// La table :
    @FXML
    private TableView<Evenement> TableEvenement;
    @FXML
    private TableColumn<Evenement, Integer> col_IdE;
    @FXML
    private TableColumn<Evenement, String> col_Nom;
    @FXML
    private TableColumn<Evenement, String> col_Destination;
    @FXML
    private TableColumn<Evenement, DatePicker> col_Date_debut;
    @FXML
    private TableColumn<Evenement, DatePicker> col_Date_fin;
    @FXML
    private TableColumn<Evenement, Integer> col_Promotion;
    @FXML
    private TableColumn<Evenement, Integer> col_NbPlace;
    @FXML
    private TableColumn<Evenement, Integer> col_IdH;
    @FXML
    private TableColumn<Evenement, Integer> col_IdR;
    
    // texte field:
    
    @FXML
    private TextField Txt_nom;
    @FXML
    private TextField Txt_destination;
    @FXML
    private DatePicker Txt_date_debut;
    @FXML
    private DatePicker Txt_date_fin;
    @FXML
    private TextField Txt_promotion;
    @FXML
    private TextField Txt_nbplace;
    @FXML
    private TextField Txt_idH;
    @FXML
    private TextField Txt_idR;
    
    @FXML
    private TextField Txt_rech;
    //texte button
    @FXML
    private Button btnAjout;
     @FXML
    private ComboBox<String> btnParCategories;

    @FXML
    private Button btnRecherche;

    @FXML
    private Button btnSupprimer;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnActualiser;
    //Texte
    @FXML
    private Text Trie;
      @FXML
    private Text TxtNomEven;

    @FXML
    private Text TxtDestination;

    @FXML
    private Text TxtDateD;

    @FXML
    private Text TxtDateF;

    @FXML
    private Text TxtPromo;

    @FXML
    private Text TxtNbPlace;

    @FXML
    private Text TxtHotel;

    @FXML
    private Text TxtResto;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnParCategories.setValue("idE");
        btnParCategories.setItems(categoriesList);
        
        
    }
    
        @FXML 
        public void table(){
            
            EvenementService evenservice=new EvenementService();
            List<Evenement> list=evenservice.readAll();
        
            ObservableList<Evenement> obs=FXCollections.observableArrayList(list);
        
        col_IdE.setCellValueFactory(new PropertyValueFactory<>("idE"));
        col_Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_Destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        col_Date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        col_Date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
        col_Promotion.setCellValueFactory(new PropertyValueFactory<>("promotion"));
        col_NbPlace.setCellValueFactory(new PropertyValueFactory<>("nbPlace"));
        col_IdH.setCellValueFactory(new PropertyValueFactory<>("idH"));
        col_IdR.setCellValueFactory(new PropertyValueFactory<>("idR"));
        TableEvenement.setItems(obs);
        }
        
        @FXML
        public void actualiser() {
        Txt_nom.setText("");
        Txt_destination.setText("");
        Txt_date_debut.setValue(null);
        Txt_date_fin.setValue(null);
        Txt_promotion.setText(null);
        Txt_nbplace.setText(null);
        Txt_idH.setText(null);
        Txt_idR.setText(null);
        }
        @FXML
        public void Supprimer() {
        int id = TableEvenement.getSelectionModel().getSelectedIndex();
        TableEvenement.getItems().remove(id);
        }
        @FXML
        public void ButtonAjouter(ActionEvent evt) {                                         
            HotelService hotelser = new HotelService();
            Hotel hotel= hotelser.readById(Txt_idH);
            RestaurantService restoService = new RestaurantService();
            Restaurant resto=restoService.readById(Txt_idR);
            LocalDate dateD=Txt_date_debut.getValue();
            LocalDate dateF=Txt_date_fin.getValue();
            Instant instant1 = Instant.from(dateD.atStartOfDay(ZoneId.systemDefault()));
            Instant instant2 = Instant.from(dateF.atStartOfDay(ZoneId.systemDefault()));
            Date date1 = Date.from(instant1);
            Date date2 = Date.from(instant2);
            
            
            EvenementService evenservice=new EvenementService();
            Evenement even=new Evenement(Txt_nom.getText(),Txt_destination.getText(),date1
                    ,date2,Integer.valueOf(Txt_promotion.getText()),Integer.valueOf(Txt_nbplace.getText()),
                    hotel,resto);
            evenservice.insertPS(even);
            table();
            actualiser();
        }
        
        @FXML
        private void ButtnRecherche(ActionEvent event){
            EvenementSelectParItem selectservice=new EvenementSelectParItem();
            Evenement even=null;
            List<Evenement> list=null;
            if (Txt_rech.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "SVP entrer quelque chose");
            } else {
                if (btnParCategories.getValue().equals("idE")) {
                    even=selectservice.readById(Integer.valueOf(Txt_rech.getText()));
                    
                    list=(List<Evenement>) selectservice.readById(Integer.valueOf(Txt_rech.getText()));
                    ObservableList<Evenement> obs=FXCollections.observableArrayList(list);
        
                    col_IdE.setCellValueFactory(new PropertyValueFactory<>("idE"));
                    col_Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                    col_Destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
                    col_Date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
                    col_Date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
                    col_Promotion.setCellValueFactory(new PropertyValueFactory<>("promotion"));
                    col_NbPlace.setCellValueFactory(new PropertyValueFactory<>("nbPlace"));
                    col_IdH.setCellValueFactory(new PropertyValueFactory<>("idH"));
                    col_IdR.setCellValueFactory(new PropertyValueFactory<>("idR"));
                    TableEvenement.setItems(obs);
                    
                } else if (btnParCategories.getValue().equals("nom")) {
                    even=selectservice.readByNom(Txt_rech.getText());
                    list=(List<Evenement>) even;
                    ObservableList<Evenement> obs=FXCollections.observableArrayList(list);
        
                    col_IdE.setCellValueFactory(new PropertyValueFactory<>("idE"));
                    col_Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                    col_Destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
                    col_Date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
                    col_Date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
                    col_Promotion.setCellValueFactory(new PropertyValueFactory<>("promotion"));
                    col_NbPlace.setCellValueFactory(new PropertyValueFactory<>("nbPlace"));
                    col_IdH.setCellValueFactory(new PropertyValueFactory<>("idH"));
                    col_IdR.setCellValueFactory(new PropertyValueFactory<>("idR"));
                    TableEvenement.setItems(obs);
                } else if (btnParCategories.getValue().equals("destination")) {
                    even=selectservice.readByDestination(Txt_rech.getText());
                    list=(List<Evenement>) even;
                    ObservableList<Evenement> obs=FXCollections.observableArrayList(list);
        
                    col_IdE.setCellValueFactory(new PropertyValueFactory<>("idE"));
                    col_Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                    col_Destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
                    col_Date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
                    col_Date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
                    col_Promotion.setCellValueFactory(new PropertyValueFactory<>("promotion"));
                    col_NbPlace.setCellValueFactory(new PropertyValueFactory<>("nbPlace"));
                    col_IdH.setCellValueFactory(new PropertyValueFactory<>("idH"));
                    col_IdR.setCellValueFactory(new PropertyValueFactory<>("idR"));
                    TableEvenement.setItems(obs);
                } else if (btnParCategories.getValue().equals("promotion")) {
                    even=selectservice.readByPromotion(Integer.valueOf(Txt_rech.getText()));
                    list=(List<Evenement>) even;
                    ObservableList<Evenement> obs=FXCollections.observableArrayList(list);
        
                    col_IdE.setCellValueFactory(new PropertyValueFactory<>("idE"));
                    col_Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                    col_Destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
                    col_Date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
                    col_Date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
                    col_Promotion.setCellValueFactory(new PropertyValueFactory<>("promotion"));
                    col_NbPlace.setCellValueFactory(new PropertyValueFactory<>("nbPlace"));
                    col_IdH.setCellValueFactory(new PropertyValueFactory<>("idH"));
                    col_IdR.setCellValueFactory(new PropertyValueFactory<>("idR"));
                    TableEvenement.setItems(obs);
                } else if (btnParCategories.getValue().equals("nbPlace")) {
                    even=selectservice.readBynbPlace(Integer.valueOf(Txt_rech.getText()));
                    list=(List<Evenement>) even;
                    ObservableList<Evenement> obs=FXCollections.observableArrayList(list);
        
                    col_IdE.setCellValueFactory(new PropertyValueFactory<>("idE"));
                    col_Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                    col_Destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
                    col_Date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
                    col_Date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
                    col_Promotion.setCellValueFactory(new PropertyValueFactory<>("promotion"));
                    col_NbPlace.setCellValueFactory(new PropertyValueFactory<>("nbPlace"));
                    col_IdH.setCellValueFactory(new PropertyValueFactory<>("idH"));
                    col_IdR.setCellValueFactory(new PropertyValueFactory<>("idR"));
                    TableEvenement.setItems(obs);
                } else if (btnParCategories.getValue().equals("idH")) {
                    even=selectservice.readByhotel(Integer.valueOf(Txt_rech.getText()));
                    list=(List<Evenement>) even;
                    ObservableList<Evenement> obs=FXCollections.observableArrayList(list);
        
                    col_IdE.setCellValueFactory(new PropertyValueFactory<>("idE"));
                    col_Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                    col_Destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
                    col_Date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
                    col_Date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
                    col_Promotion.setCellValueFactory(new PropertyValueFactory<>("promotion"));
                    col_NbPlace.setCellValueFactory(new PropertyValueFactory<>("nbPlace"));
                    col_IdH.setCellValueFactory(new PropertyValueFactory<>("idH"));
                    col_IdR.setCellValueFactory(new PropertyValueFactory<>("idR"));
                    TableEvenement.setItems(obs);

                } else if (btnParCategories.getValue().equals("idR")) {
                    even=selectservice.readByResto(Integer.valueOf(Txt_rech.getText()));
                    list=(List<Evenement>) even;
                    ObservableList<Evenement> obs=FXCollections.observableArrayList(list);
        
                    col_IdE.setCellValueFactory(new PropertyValueFactory<>("idE"));
                    col_Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                    col_Destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
                    col_Date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
                    col_Date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
                    col_Promotion.setCellValueFactory(new PropertyValueFactory<>("promotion"));
                    col_NbPlace.setCellValueFactory(new PropertyValueFactory<>("nbPlace"));
                    col_IdH.setCellValueFactory(new PropertyValueFactory<>("idH"));
                    col_IdR.setCellValueFactory(new PropertyValueFactory<>("idR"));
                    TableEvenement.setItems(obs);
                }
            }    
        }
        public static final LocalDate LOCAL_DATE (String dateString){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(dateString, formatter);
            return localDate;
        }  
        @FXML
        private void tbl_prodMouseClicked(MouseEvent evt) {  
            Evenement evenementSelectionne=TableEvenement.getSelectionModel().getSelectedItem();
            Txt_nom.setText(evenementSelectionne.getNom());
            Txt_destination.setText(evenementSelectionne.getDestination());
            Txt_date_debut.setValue(LOCAL_DATE(String.valueOf(evenementSelectionne.getDate_depart())));
            Txt_date_fin.setValue(LOCAL_DATE(String.valueOf(evenementSelectionne.getDate_fin())));
            Txt_promotion.setText(String.valueOf(evenementSelectionne.getPromotion()));
            Txt_nbplace.setText(String.valueOf(evenementSelectionne.getNbPlace()));
            Txt_idH.setText(String.valueOf(evenementSelectionne.getHtl().getIdH()));
            Txt_idR.setText(String.valueOf(evenementSelectionne.getRest().getIdR()));

       
        }                                     
    }
    

    

