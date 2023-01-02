package com.svalero.cybershop.repository;

import com.svalero.cybershop.domain.Repair;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairRepository extends CrudRepository<Repair, Long> {
}
