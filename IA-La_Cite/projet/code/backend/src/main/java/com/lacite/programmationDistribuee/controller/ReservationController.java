package com.lacite.programmationDistribuee.controller;

import com.lacite.programmationDistribuee.Reservation;
import com.lacite.programmationDistribuee.services.ReservationService;
import com.lacite.programmationDistribuee.services.VolService;
import com.lacite.programmationDistribuee.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @Autowired
    private JwtUtil TokenUtil;

    @GetMapping("/reservation/all")
    public List<Reservation> getAllReservation(@RequestHeader Map<String, String> requestHeader) {
        String username = this.getUsernameFromToken(requestHeader.get("authorization"));
        return reservationService.getAllVol(username);
    }

    @PostMapping("/reservation/add")
    public boolean AddReservation(@RequestHeader Map<String, String> requestHeader, @RequestBody Map<String, String> requestsBody) {
        String id = requestsBody.get("id");
        long idParse = (long)Integer.parseInt(id);
        String username = this.getUsernameFromToken(requestHeader.get("authorization"));
        return reservationService.reservationAccept(username, idParse);
    }

    @PostMapping("/reservation/delete")
    public boolean deleteReservation(@RequestHeader Map<String, String> requestHeader) {
        String id = requestHeader.get("id");
        long idParse = (long)Integer.parseInt(id);
        return reservationService.deleteReservation(idParse);
    }

    public String getUsernameFromToken(String token)
    {
        token = token.substring(7);
        return TokenUtil.extractUsername(token);
    }

}
