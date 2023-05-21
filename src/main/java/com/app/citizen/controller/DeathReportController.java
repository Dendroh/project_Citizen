package com.app.citizen.controller;

import com.app.citizen.service.ResidentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Slf4j
@Controller
public class DeathReportController {
  private ResidentService residentService;

  public DeathReportController(ResidentService residentService) {
    this.residentService = residentService;
  }

  @GetMapping("/death-register")
  public String homeGet(Model model, Principal principal) {
    model.addAttribute("deathResident",
            residentService.findResidentBy(Integer.parseInt(principal.getName())));
    model.addAttribute("deathReportResident",
            residentService.findDeathReportResident(Integer.parseInt(principal.getName())));
    return "FormDeathRegister";
  }
}