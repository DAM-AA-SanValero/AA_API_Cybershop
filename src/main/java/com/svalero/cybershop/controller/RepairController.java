package com.svalero.cybershop.controller;

import com.svalero.cybershop.domain.Repair;
import com.svalero.cybershop.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RepairController {

    @Autowired
    RepairService repairService;

    @GetMapping("/repairs")
    public List<Repair> getRepair(){
        return repairService.findAll();
    }

    @PostMapping("/repairs")
    public void addRepair(@RequestBody Repair repair){
        repairService.addRepair(repair);
    }
}
