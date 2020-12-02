package com.progdistribuee.springboot.repository;

import com.progdistribuee.springboot.model.Vol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolRepository extends JpaRepository <Vol, Long > {

}