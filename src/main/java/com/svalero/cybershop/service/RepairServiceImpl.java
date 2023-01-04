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
    public Repair findById(long id) {
        return repairRepository.findById(id).orElseThrow();
    }

    @Override
    public Repair addRepair(Repair repair) {
        return repairRepository.save(repair);
    }

    @Override
    public void deleteRepair(long id) {
        Repair repair = repairRepository.findById(id).orElseThrow();
        repairRepository.delete(repair);
    }

    @Override
    public Repair updateRepair(long id, Repair updateRepair) {
        Repair oldRepair = repairRepository.findById(id).orElseThrow();
        oldRepair.setComponent(updateRepair.getComponent());
        oldRepair.setPrice(updateRepair.getPrice());
        oldRepair.setShippingAddress(updateRepair.getShippingAddress());
        oldRepair.setShipmentDate(updateRepair.getShipmentDate());
        oldRepair.setRepairedDate(updateRepair.getRepairedDate());

        return repairRepository.save(oldRepair);
    }
}
