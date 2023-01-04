package com.svalero.cybershop.service;

import com.svalero.cybershop.domain.Technician;
import com.svalero.cybershop.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicianServiceImpl implements TechnicianService{

    @Autowired
    TechnicianRepository technicianRepository;

    @Override
    public List<Technician> findAll() {
        return technicianRepository.findAll();
    }

    @Override
    public Technician findById(long id) {
        return technicianRepository.findById(id).orElseThrow();
    }

    @Override
    public Technician addTechnician(Technician technician) {
        return technicianRepository.save(technician);
    }
}
