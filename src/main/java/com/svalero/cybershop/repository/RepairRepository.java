package com.svalero.cybershop.repository;

import com.svalero.cybershop.domain.Repair;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairRepository extends CrudRepository<Repair, Long> {

    List<Repair> findAll();

}
