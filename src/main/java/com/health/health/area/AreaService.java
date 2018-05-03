package com.health.health.area;


import com.health.health.exceptions.AlreadyExistException;
import com.health.health.exceptions.InvalidParameterException;
import com.health.health.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

/**
 * Created by jdms3112 on 3/8/2018.
 */
@Service
public class AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private Validator validator;

    public Area addNewArea(@Valid Area area) throws InvalidParameterException, AlreadyExistException {
        Set<ConstraintViolation<Area>> validate = validator.validate(area);
        if (!validate.isEmpty()) {
            throw new InvalidParameterException("Area mustn't be null");
        }
        if (areaRepository.findByName(area.getName()) != null) {
            throw new AlreadyExistException("Area already exists");
        }
        return areaRepository.save(area);
    }

    public Area findAreaById(int id) throws NotFoundException {
        Area area = areaRepository.findOne(id);
        if (area == null) {
            throw new NotFoundException("Area doesn't exist");
        }
        return area;
    }

    public List<Area> findAllAreas() {
        return areaRepository.findAll();
    }
}
