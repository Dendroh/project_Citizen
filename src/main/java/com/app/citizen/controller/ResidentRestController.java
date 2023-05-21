package com.app.citizen.controller;

import com.app.citizen.domain.Request.FamilyId;
import com.app.citizen.domain.Request.FamilyRegisterRequest;
import com.app.citizen.domain.Request.ResidentId;
import com.app.citizen.domain.Request.ResidentRegisterRequest;
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
  }
}
