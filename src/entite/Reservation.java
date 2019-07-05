/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author benamara
 */
public class Reservation {
    
    
    
    private int id;
    private Date dateArrive;
    private Date dateDepart;
    private int idUser;
    private int idHotel;
    private int idRestaurant;

    public Reservation(Date dateArrive, Date dateDepart, int idUser, int idHotel, int idRestaurant) {
        this.dateArrive = dateArrive;
        this.dateDepart = dateDepart;
        this.idUser = idUser;
        this.idHotel = idHotel;
        this.idRestaurant = idRestaurant;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateArrive() {
        return dateArrive;
    }

    public void setDateArrive(Date dateArrive) {
        this.dateArrive = dateArrive;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

  

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public int getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(int idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.dateArrive);
        hash = 89 * hash + Objects.hashCode(this.dateDepart);
        hash = 89 * hash + this.idUser;
        hash = 89 * hash + this.idHotel;
        hash = 89 * hash + this.idRestaurant;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reservation other = (Reservation) obj;
        if (this.idUser != other.idUser) {
            return false;
        }
        if (this.idHotel != other.idHotel) {
            return false;
        }
        if (this.idRestaurant != other.idRestaurant) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", dateArrive=" + dateArrive + ", dateDepart=" + dateDepart + ", idUser=" + idUser + ", idHotel=" + idHotel + ", idRestaurant=" + idRestaurant + '}';
    }

}

