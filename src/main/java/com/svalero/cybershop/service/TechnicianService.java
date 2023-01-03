package com.svalero.cybershop.service;

import com.svalero.cybershop.domain.Technician;

import java.util.List;

public interface TechnicianService {

    List<Technician> findAll();

    Technician findByName(String name);

    Technician addTechnician(Technician technician);

}
