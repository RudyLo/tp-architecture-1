package com.lacite.programmationDistribuee.repository;

import com.lacite.programmationDistribuee.Vol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VolRepository extends JpaRepository<Vol, Integer> {
    List<Vol> findAllByCodeDepartEquals(String airport);
    Vol findByIdEquals(long id);
}