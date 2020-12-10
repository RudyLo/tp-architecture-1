package com.lacite.programmationDistribuee.services;

import com.lacite.programmationDistribuee.Reservation;
import com.lacite.programmationDistribuee.Vol;
import com.lacite.programmationDistribuee.repository.ReservationRepository;
import com.lacite.programmationDistribuee.repository.VolRepository;
import com.lacite.programmationDistribuee.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private JwtUtil TokenUtil;

    @Autowired
    private VolRepository volRepository;

    public String getUsernameFromToken(String token)
    {
        token = token.substring(7);
        return TokenUtil.extractUsername(token);
    }

    public List<Reservation> getAllVol(String username) {
        return reservationRepository.findAllByUserEquals(username);
    }

    public boolean reservationAccept(String token, long id) {
        Reservation reservation = new Reservation();

        Vol vol = volRepository.findByIdEquals(id);
        reservation.setCodeArrivee(vol.getCodeArrivee());
        reservation.setCodeDepart(vol.getCodeDepart());
        reservation.setDateVol(vol.getDateVol());
        reservation.setPrixVol(vol.getPrixVol());
        reservation.setUser(token);

        reservationRepository.save(reservation);
        return true;
    }

    public boolean deleteReservation(long id) {
        Reservation reservation = reservationRepository.findReservationByIdEquals(id);
        reservationRepository.delete(reservation);
        return true;
    }

}
