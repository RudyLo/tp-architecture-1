package com.progdistribuee.springboot.model;

import javax.persistence.*;

@Entity
@Table(name="vol")
public class Vol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String codeDepart;
    private String codeArrivee;


    public Vol() {}

    public Vol(String codeDepart, String codeArrivee) {
        this.codeDepart = codeDepart;
        this.codeArrivee = codeArrivee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Vol{" +
                "id=" + id +
                ", codeDepart='" + codeDepart + '\'' +
                ", codeArrivee='" + codeArrivee + '\'' +
                '}';
    }
}