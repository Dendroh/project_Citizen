package com.app.citizen.controller;

import com.app.citizen.domain.Request.*;
import com.app.citizen.service.FamilyRelationshipService;
import com.app.citizen.service.ResidentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/residents")
public class ResidentRestController {
  private final ResidentService residentService;
  private final FamilyRelationshipService familyRelationshipService;

  public ResidentRestController(ResidentService residentService, FamilyRelationshipService familyRelationshipService) {
    this.residentService = residentService;
    this.familyRelationshipService = familyRelationshipService;
  }

  @PostMapping
  public ResidentId registerResident(@RequestBody ResidentRegisterRequest request) {
    return residentService.registerResident(request);
  }

  @PutMapping("/{serialNumber}")
  public ResidentId editResident(@PathVariable String serialNumber, @RequestBody ResidentRegisterRequest request) {
    return residentService.editResident(request, serialNumber);
  }

  @DeleteMapping("/{serialNumber}")
  public void deleteResident(@PathVariable String serialNumber) {
    residentService.deleteResident(serialNumber);
  }

  @PostMapping("/{serialNumber}/relationship")
  public FamilyId registerFamily(@PathVariable String serialNumber, @RequestBody FamilyRegisterRequest request) {
    return familyRelationshipService.registerFamily(request, serialNumber);
  }

  @PutMapping("/{serialNumber}/relationship/{familySerialNumber}")
  public FamilyId editFamily(@PathVariable String serialNumber, @PathVariable String familySerialNumber, @RequestBody FamilyRegisterRequest request) {
    return familyRelationshipService.editFamily(request, serialNumber, familySerialNumber);
  }

  @DeleteMapping("/{serialNumber}/relationship/{familySerialNumber}")
  public void deleteFamily(@PathVariable String serialNumber, @PathVariable String familySerialNumber, @RequestBody FamilyRegisterRequest request) {
    familyRelationshipService.deleteFamily(serialNumber, familySerialNumber);
  }

  @PostMapping("/{serialNumber}/birth/")
  public BirthDeathId registerBirth(@PathVariable String serialNumber, @RequestBody BirthDeathRegisterRequest request) {
    return residentService.registerBirthDeath(request, serialNumber);
  }

  @PutMapping("/{serialNumber}/birth/{targetSerialNumber}")
  public BirthDeathId editBirth(@PathVariable String serialNumber, @PathVariable String targetSerialNumber, @RequestBody BirthDeathRegisterRequest request) {
    return residentService.editBirthDeath(request, serialNumber, targetSerialNumber);
  }

  @DeleteMapping("/{serialNumber}/birth/{targetSerialNumber}")
  public void deleteBirth(@PathVariable String serialNumber, @PathVariable String targetSerialNumber, @RequestBody BirthDeathRegisterRequest request) {
    residentService.deleteBirthDeath(request, serialNumber, targetSerialNumber);
  }


  @PostMapping("/{serialNumber}/death/")
  public BirthDeathId registerDeath(@PathVariable String serialNumber, @RequestBody BirthDeathRegisterRequest request) {
    return residentService.registerBirthDeath(request, serialNumber);
  }

  @PutMapping("/{serialNumber}/death/{targetSerialNumber}")
  public BirthDeathId editDeath(@PathVariable String serialNumber, @PathVariable String targetSerialNumber, @RequestBody BirthDeathRegisterRequest request) {
    return residentService.editBirthDeath(request, serialNumber, targetSerialNumber);
  }

  @DeleteMapping("/{serialNumber}/death/{targetSerialNumber}")
  public void deleteDeath(@PathVariable String serialNumber, @PathVariable String targetSerialNumber, @RequestBody BirthDeathRegisterRequest request) {
    residentService.deleteBirthDeath(request, serialNumber, targetSerialNumber);
  }
}
