package com.lacite.programmationDistribuee;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class User {


    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String password;
    private String name;
    private String email;

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  void setEmail(String email)
    {
        this.email = email;
    }
    public String getEmail()
    {
        return this.email;
    }

    public void hiddenPassword()
    {
        this.password = "************";
    }
}