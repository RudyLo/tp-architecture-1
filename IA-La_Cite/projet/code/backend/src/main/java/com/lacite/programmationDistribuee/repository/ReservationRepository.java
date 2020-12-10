package com.lacite.programmationDistribuee.repository;

import com.lacite.programmationDistribuee.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findAllByUserEquals(String user);
    Reservation findReservationByIdEquals(long id);
}
