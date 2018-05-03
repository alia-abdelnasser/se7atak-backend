package com.health.health.pharmacy;

import com.health.health.area.AreaService;
import com.health.health.constants.Constants;
import com.health.health.exceptions.InvalidParameterException;
import com.health.health.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

/**
 * Created by jdms3112 on 5/2/2018.
 */
@Service
public class PharmacyService {

    @Autowired
    private PharmacyRepository pharmacyRepository;
    @Autowired
    private AreaService areaService;
    @Autowired
    private Validator validator;

    public Pharmacy registerPharmacy(PharmacyDto pharmacyDto) throws InvalidParameterException, NotFoundException {
        Pharmacy pharmacy = pharmacyDto.convertToPharmacy();
        Set<ConstraintViolation<Pharmacy>> validate = validator.validate(pharmacy);
        if (!validate.isEmpty()) {
            throw new InvalidParameterException(Constants.INVALID_PARAMETERS);
        }
        pharmacy.setArea(areaService.findAreaById(pharmacyDto.getAreaId()));
        return pharmacyRepository.save(pharmacy);
    }

    public Pharmacy updatePharmacy(Integer id, PharmacyDto pharmacyDto) throws InvalidParameterException, NotFoundException {
        Pharmacy pharmacy = pharmacyDto.convertToPharmacy();
        Pharmacy foundPharmacy = findPharmacyById(id);
        Set<ConstraintViolation<Pharmacy>> validate = validator.validate(pharmacy);
        if (!validate.isEmpty()) {
            throw new InvalidParameterException(Constants.INVALID_PARAMETERS);
        }
        if (foundPharmacy == null) {
            throw new NotFoundException(Constants.PHARMACY_NOT_FOUND);
        }
        pharmacy.setArea(areaService.findAreaById(pharmacyDto.getAreaId()));
        pharmacy.setId(foundPharmacy.getId());
        return pharmacyRepository.save(pharmacy);
    }

    public Pharmacy findPharmacyById(Integer id) throws NotFoundException {
        Pharmacy pharmacy = pharmacyRepository.findOne(id);
        if (pharmacy == null) {
            throw new NotFoundException(Constants.PHARMACY_NOT_FOUND);
        }
        return pharmacy;
    }


    public List<Pharmacy> findPharmacyByAreaId(Integer areaId) throws NotFoundException {
        return pharmacyRepository.findByArea_Id(areaId);
    }

    public List<Pharmacy> findAll() {
        return pharmacyRepository.findAll();
    }

    public void deletePharmacy(Integer id) throws NotFoundException {
        Pharmacy pharmacy = pharmacyRepository.findOne(id);
        if (pharmacy == null) {
            throw new NotFoundException(Constants.PHARMACY_NOT_FOUND);
        }
        pharmacyRepository.delete(id);
    }
}
