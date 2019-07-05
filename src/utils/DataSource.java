/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohamed
 */
public class DataSource {
    
    private  String url="jdbc:mysql://localhost:3306/mytrip";
    private  String login="rihab";
    private  String pwd="rahouba;97531";
    private  Connection cnx;
    private static DataSource instance;
    
    private DataSource() {
      
        try {
            cnx=DriverManager.getConnection(url, login, pwd);
            Logger.getLogger(DataSource.class.getName()).log(Level.INFO, "Connected to database");
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, "Connection to database failed", ex);
        }
       
    }
    
    public static DataSource getInstance(){
       if(instance==null)
           instance=new DataSource();
       return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
    
}
