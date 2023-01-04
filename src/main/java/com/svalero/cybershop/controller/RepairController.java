package com.svalero.cybershop.controller;

import com.svalero.cybershop.domain.Repair;
import com.svalero.cybershop.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RepairController {

    @Autowired
    RepairService repairService;

    @GetMapping("/repairs")
    public List<Repair> getRepair(){
        return repairService.findAll();
    }

    @GetMapping("/repairs/{id}")
    public Repair getRepair(@PathVariable long id){
        return repairService.findById(id);
    }

    @PostMapping("/repairs")
    public void addRepair(@RequestBody Repair repair){
        repairService.addRepair(repair);
    }
}
