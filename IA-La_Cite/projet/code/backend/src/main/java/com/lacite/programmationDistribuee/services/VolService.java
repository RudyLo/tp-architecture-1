package com.lacite.programmationDistribuee.services;

import com.lacite.programmationDistribuee.Vol;
import com.lacite.programmationDistribuee.repository.UserRepository;
import com.lacite.programmationDistribuee.repository.VolRepository;
import com.lacite.programmationDistribuee.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolService {

    @Autowired
    private VolRepository volRepository;

    public List<Vol> getAllVol(String airport) {
        return volRepository.findAllByCodeDepartEquals(airport);
    }

}
