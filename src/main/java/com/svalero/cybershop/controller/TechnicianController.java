package com.svalero.cybershop.controller;

import com.svalero.cybershop.domain.Technician;
import com.svalero.cybershop.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TechnicianController {

    @Autowired
    TechnicianService technicianService;

    @GetMapping("/technicians")
    public List<Technician> getTechnician(){
        return technicianService.findAll();
    }

    @PostMapping("technicians")
    public void addTechnician(@RequestBody Technician technician){
        technicianService.addTechnician(technician);
    }

}
