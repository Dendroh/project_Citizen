package com.app.citizen.controller;

import com.app.citizen.service.HouseholdService;
import com.app.citizen.service.ResidentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Slf4j
@Controller
public class HouseholdController {

  private ResidentService residentService;
  private HouseholdService householdService;

  public HouseholdController(ResidentService residentService, HouseholdService householdService) {
    this.residentService = residentService;
    this.householdService = householdService;
  }

  @GetMapping("/resident-registration")
  public String homeGet(Model model, Principal principal) {
    model.addAttribute("baseResident",
            residentService.findResidentBy(Integer.parseInt(principal.getName())));
    model.addAttribute("household",
            householdService.findResidentsBy(Integer.parseInt(principal.getName())));
    return "FormResidentRegistration";
  }
}

