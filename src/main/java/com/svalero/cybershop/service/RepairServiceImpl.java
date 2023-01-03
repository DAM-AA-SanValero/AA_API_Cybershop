package com.svalero.cybershop.service;

import com.svalero.cybershop.domain.Repair;
import com.svalero.cybershop.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairServiceImpl implements RepairService {

    @Autowired
    RepairRepository repairRepository;


    @Override
    public List<Repair> findAll() {
        return repairRepository.findAll();
    }

    @Override
    public Repair findByProduct(String product) {
        return repairRepository.findByProduct(product);
    }

    @Override
    public Repair addRepair(Repair repair) {
        return repairRepository.save(repair);
    }
}
