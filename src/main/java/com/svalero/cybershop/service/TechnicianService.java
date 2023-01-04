package com.svalero.cybershop.service;

import com.svalero.cybershop.domain.Technician;

import java.util.List;

public interface TechnicianService {

    List<Technician> findAll();

    Technician findById(long id);

    Technician addTechnician(Technician technician);

    void deleteTechnician(long id);

    Technician updatedTechnician(long id, Technician technician);

}
