package com.lacite.programmationDistribuee;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vol {
    private String codeD;
    private String codeA;
    private String prix;

    public Vol(String codeD, String codeA, String prix) {
        this.codeD = codeD;
        this.codeA = codeA;
        this.prix = prix;
    }

    public String getCodeD() {
        return codeD;
    }

    public void setCodeD(String codeD) {
        this.codeD = codeD;
    }

    public String getCodeA() {
        return codeA;
    }

    public void setCodeA(String codeA) {
        this.codeA = codeA;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;

    }
}
