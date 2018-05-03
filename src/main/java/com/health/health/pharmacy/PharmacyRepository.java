package com.health.health.pharmacy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jdms3112 on 5/2/2018.
 */
@Repository
public interface PharmacyRepository extends CrudRepository<Pharmacy, Integer> {

    List<Pharmacy> findByArea_Id(Integer areaId);

    List<Pharmacy> findAll();
}
