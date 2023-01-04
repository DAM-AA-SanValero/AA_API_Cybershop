package com.svalero.cybershop.controller;

import com.svalero.cybershop.domain.Technician;
import com.svalero.cybershop.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TechnicianController {

    @Autowired
    TechnicianService technicianService;

    @GetMapping("/technicians")
    public List<Technician> getTechnician(){
        return technicianService.findAll();
    }

    @GetMapping("/technicians/{id}")
    public Technician getTechnician(@PathVariable long id){
        return technicianService.findById(id);
    }

    @PostMapping("technicians")
    public void addTechnician(@RequestBody Technician technician){
        technicianService.addTechnician(technician);
    }

    @DeleteMapping("technicians/{id}")
    public void deleteTechnician(@PathVariable long id){
        technicianService.deleteTechnician(id);
    }
    @PutMapping("technicians/{id}")
    public Technician updateTechnician(@PathVariable long id, @RequestBody Technician technician){
        return technicianService.updatedTechnician(id, technician);

    }

}
