package com.lacite.programmationDistribuee.controller;

import com.lacite.programmationDistribuee.Vol;
import com.lacite.programmationDistribuee.services.VolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class VolController {

    @Autowired
    VolService volService;

    @GetMapping("/flight/all")
    public List<Vol> createUser(@RequestHeader Map<String, String> requestsBody)
    {
        String airport = requestsBody.get("airport");
        return volService.getAllVol(airport);
    }

}
