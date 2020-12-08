package com.lacite.programmationDistribuee;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private int id;
    private String email;
    private List<Vol> reservation;

    public User(int id, String email) {
        this.id = id;
        this.email = email;
        this.reservation = new ArrayList<Vol>();
    }
    public void ajouterVol(Vol vol)
    {
        this.getReservation().add(vol);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Vol> getReservation() {
        return reservation;
    }

    public void setReservation(List<Vol> reservation) {
        this.reservation = reservation;
    }


}
