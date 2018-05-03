package com.health.health.pharmacy;

import com.health.health.constants.Constants;
import com.health.health.exceptions.InvalidParameterException;
import com.health.health.exceptions.NotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jdms3112 on 5/2/2018.
 */
@Api(tags = "pharmacy")
@RestController
public class PharmacyController {

    @Autowired
    private PharmacyService pharmacyService;

    @ApiOperation(value = "Add new pharmacy", response = PharmacyDto.class)
    @ApiResponses(value = {@ApiResponse(code = 201, message = Constants.SUCCESSFUL_RESPONSE, response = PharmacyDto.class)
            , @ApiResponse(code = 400, message = Constants.INVALID_PARAMETERS, response = Void.class)})
    @RequestMapping(value = "/pharmacy", method = RequestMethod.POST)
    public ResponseEntity<Pharmacy> registerPharmacy(@RequestBody PharmacyDto pharmacyDto) throws InvalidParameterException, NotFoundException {
        return new ResponseEntity<>(pharmacyService.registerPharmacy(pharmacyDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update pharmacy", response = PharmacyDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = Constants.SUCCESSFUL_RESPONSE, response = PharmacyDto.class)
            , @ApiResponse(code = 400, message = Constants.INVALID_PARAMETERS, response = Void.class)
            , @ApiResponse(code = 404, message = Constants.PHARMACY_NOT_FOUND, response = Void.class)})
    @RequestMapping(value = "/pharmacy/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Pharmacy> updatePharmacy(@PathVariable("id") Integer id, @RequestBody PharmacyDto pharmacyDto) throws InvalidParameterException, NotFoundException {
        return new ResponseEntity<>(pharmacyService.updatePharmacy(id, pharmacyDto), HttpStatus.OK);
    }

    @ApiOperation(value = "Find pharmacy by id", response = PharmacyDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = Constants.SUCCESSFUL_RESPONSE, response = PharmacyDto.class)
            , @ApiResponse(code = 400, message = Constants.INVALID_PARAMETERS, response = Void.class)
            , @ApiResponse(code = 404, message = "Not found", response = Void.class)})
    @RequestMapping(value = "/pharmacy/{pharmacy-id}", method = RequestMethod.GET)
    public ResponseEntity<Pharmacy> findPharmacyById(@PathVariable("pharmacy-id") Integer id) throws InvalidParameterException, NotFoundException {
        return new ResponseEntity<>(pharmacyService.findPharmacyById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Find pharmacy by areaId", response = PharmacyDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = Constants.SUCCESSFUL_RESPONSE, response = PharmacyDto.class)
            , @ApiResponse(code = 400, message = Constants.INVALID_PARAMETERS, response = Void.class)
            , @ApiResponse(code = 404, message = "Not found", response = Void.class)})
    @RequestMapping(value = "/pharmacy/area-id/{areaId}", method = RequestMethod.GET)
    public ResponseEntity<List<Pharmacy>> findPharmacyByAreaId(@PathVariable("areaId") Integer areaId) throws InvalidParameterException, NotFoundException {
        return new ResponseEntity<>(pharmacyService.findPharmacyByAreaId(areaId), HttpStatus.OK);
    }

    @ApiOperation(value = "Find all pharmacies", response = PharmacyDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = Constants.SUCCESSFUL_RESPONSE, response = PharmacyDto.class)})
    @RequestMapping(value = "/pharmacy", method = RequestMethod.GET)
    public ResponseEntity<List<Pharmacy>> findAllPharmacies() throws InvalidParameterException, NotFoundException {
        return new ResponseEntity<>(pharmacyService.findAll(), HttpStatus.OK);
    }


    @ApiOperation(value = "Delete pharmacy", response = PharmacyDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = Constants.SUCCESSFUL_RESPONSE, response = PharmacyDto.class)
            , @ApiResponse(code = 404, message = Constants.PHARMACY_NOT_FOUND, response = Void.class)})
    @RequestMapping(value = "/pharmacy/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePharmacy(@PathVariable("id") Integer id) throws InvalidParameterException, NotFoundException {
        pharmacyService.deletePharmacy(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
