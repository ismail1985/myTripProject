/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Publication;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.PublicationService;


/**
 * FXML Controller class
 *
 * @author Rihab
 */
public class AfficherPublicationController implements Initializable {
    
    
    @FXML
    private TableView<Publication> TablePublication;
    @FXML
    private TableColumn<Publication, Integer> fieldId;
    @FXML
    private TableColumn<Publication, Date> fieldDateP;
    @FXML
    private TableColumn<Publication, Integer> fieldIdE;
    @FXML
    private TableColumn<Publication, Integer> fieldIdU;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PublicationService pubService=new PublicationService();
        
        List<Publication> list=pubService.readAll();
        
        ObservableList<Publication> obs=FXCollections.observableArrayList(list);
        
       fieldIdU.setCellValueFactory(new PropertyValueFactory<>("idU"));
       fieldDateP.setCellValueFactory(new PropertyValueFactory<>("date_Publication"));
       fieldIdE.setCellValueFactory(new PropertyValueFactory<>("Id_evenement"));
       fieldId.setCellValueFactory(new PropertyValueFactory<>("numero_Pub"));
      
      
       
       
TablePublication.setItems(obs);
        
        // TODO
    }    
    
}
