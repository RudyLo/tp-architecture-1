package com.lacite.programmationDistribuee;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    List<User> users = new ArrayList<User>();
    List<Vol> vols = new ArrayList<Vol>();


    @PostMapping("/login")
    public List<Vol> addUser(@RequestParam String email)
    {
        vols.add(new Vol("JFK","CDG","20"));
        vols.add(new Vol("CDG","JFK","200"));
        vols.add(new Vol("DTW","CDG","140"));
        vols.add(new Vol("JFK","DTW","180"));
        vols.add(new Vol("DTW","JFK","1000000"));
        vols.add(new Vol("CDG","DTW","4747"));
        vols.add(new Vol("JFK","CDG","10"));

        users.add(new User(1,email));

        for(User user : users)
        {
            if(user.getEmail().equals(email))
            {
                return user.getReservation();
            }
        }
        return null;
    }

    @GetMapping("/flight")
    public List<Vol> getFlight()
    {
        return vols;
    }


    @PostMapping("/addReservation")
    public boolean ajouterReservation(@RequestParam String codeD, @RequestParam String codeA, @RequestParam String prix, @RequestParam String email)
    {
        for(User user : users)
        {
            if(user.getEmail().equals(email))
            {
                Vol vol = new Vol(codeD,codeA,prix);
                user.ajouterVol(vol);
                vols.add(vol);
                return true;
            }
        }
        return false;
    }
}
