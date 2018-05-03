package com.health.health.area;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jdms3112 on 3/8/2018.
 */
@Repository
public interface AreaRepository extends CrudRepository<Area, Integer> {

    Area findByName(String name);

    List<Area> findAll();
}
