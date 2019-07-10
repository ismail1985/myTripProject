
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetMyTrip;

import entite.Evenement;
import entite.Hotel;
import entite.Restaurant;
//import java.sql.Date;
import service.EvenementService;
import service.HotelService;
import service.IService;
import service.RestaurantService;
import utils.DataSource;
import java.util.Date;

/**
 *
 * @author wyouness
 */
public class ProjetMyTrip {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataSource ds1=DataSource.getInstance();
        IService hotelService = new HotelService();
        IService restoService = new RestaurantService();
        IService evenService = new EvenementService();
        Hotel hotel=new Hotel(3,"Africajad", "adresse", 5, "telephone");
        Restaurant resto= new Restaurant(2,"yamii", "adresse", 456678, "email", 3456, "ville", "description");
        java.util.Date utilDate = new java.util.Date();
        System.out.println("java.util.Date is : " + utilDate);
        Evenement even=new Evenement("voyage","Paris",new Date(2010,1,3),new Date(2010,10,3),50,50,hotel,resto);
        //Insert
        //hotelService.insertPS(hotel);
        //restoService.insertPS(resto);
        //evenService.insertPS(even);
        //evenService.update(even);
        System.out.println(evenService.readAll());
    }
    
    
}
