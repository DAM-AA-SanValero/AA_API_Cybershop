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

    @Override
    public void deleteTechnician(long id) {
        Technician technician = technicianRepository.findById(id).orElseThrow();
        technicianRepository.delete(technician);
    }

    @Override
    public Technician updatedTechnician(long id, Technician updateTechnician) {
        Technician oldTechnician = technicianRepository.findById(id).orElseThrow();
        oldTechnician.setName(updateTechnician.getName());
        oldTechnician.setSurname(updateTechnician.getSurname());
        oldTechnician.setNumber(updateTechnician.getNumber());
        oldTechnician.setDepartment(updateTechnician.getDepartment());
        oldTechnician.setAvailable(updateTechnician.isAvailable());

        return technicianRepository.save(oldTechnician);
    }


}
