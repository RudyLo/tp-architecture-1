package com.lacite.programmationDistribuee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "reservation")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Reservation {

    @Id
    @GeneratedValue
    private long id;
    private String user;
    private String codeDepart;
    private String codeArrivee;
    private String dateVol;
    private int prixVol;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCodeDepart() {
        return codeDepart;
    }

    public void setCodeDepart(String codeDepart) {
        this.codeDepart = codeDepart;
    }

    public String getCodeArrivee() {
        return codeArrivee;
    }

    public void setCodeArrivee(String codeArrivee) {
        this.codeArrivee = codeArrivee;
    }

    public String getDateVol() {
        return dateVol;
    }

    public void setDateVol(String dateVol) {
        this.dateVol = dateVol;
    }

    public int getPrixVol() {
        return prixVol;
    }

    public void setPrixVol(int prixVol) {
        this.prixVol = prixVol;
    }


}
