package com.svalero.cybershop.service;

import com.svalero.cybershop.domain.Technician;
import com.svalero.cybershop.exception.TechnicianNotFoundException;

import java.util.List;

public interface TechnicianService {

    List<Technician> findAll();

    Technician findById(long id) throws TechnicianNotFoundException;

    Technician addTechnician(Technician technician);

    void deleteTechnician(long id) throws TechnicianNotFoundException;

    Technician updatedTechnician(long id, Technician technician) throws TechnicianNotFoundException;

}
