package com.app.citizen.controller;

import com.app.citizen.domain.ResidentId;
import com.app.citizen.domain.ResidentRegisterRequest;
import com.app.citizen.service.ResidentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/residents")
public class ResidentRestController {
  private final ResidentService residentService;

  public ResidentRestController(ResidentService residentService) {
    this.residentService = residentService;
  }

  @PostMapping
  public ResidentId registerResident(@RequestBody ResidentRegisterRequest request) {
    return residentService.registerResident(request);
  }

  @PutMapping
  public ResidentId editResident(@RequestBody ResidentRegisterRequest request) {
    return residentService.registerResident(request);
  }
}
