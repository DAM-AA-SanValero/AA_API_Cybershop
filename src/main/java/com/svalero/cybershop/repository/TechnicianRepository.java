package com.svalero.cybershop.repository;

import com.svalero.cybershop.domain.Technician;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianRepository extends CrudRepository<Technician, Long> {

}
