package com.svalero.cybershop.repository;

import com.svalero.cybershop.domain.Technician;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicianRepository extends CrudRepository<Technician, Long> {

    List<Technician> findAll();

    Technician findByName(String name);
}
