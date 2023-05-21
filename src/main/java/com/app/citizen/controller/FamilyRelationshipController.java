package com.app.citizen.controller;

import com.app.citizen.service.FamilyRelationshipService;
import com.app.citizen.service.ResidentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Slf4j
@Controller
public class FamilyRelationshipController {

  private ResidentService residentService;
  private FamilyRelationshipService familyRelationshipService;

  public FamilyRelationshipController(ResidentService residentService, FamilyRelationshipService familyRelationshipService) {
    this.residentService = residentService;
    this.familyRelationshipService = familyRelationshipService;
  }

  @GetMapping("/family-relationship")
  public String homeGet(Model model, Principal principal) {
    model.addAttribute("baseResident",
            residentService.findResidentBy(Integer.parseInt(principal.getName())));
    model.addAttribute("familyResident",
            familyRelationshipService.findResidentsBy(Integer.parseInt(principal.getName())));
    return "FormFamilyRelationship";
  }
}
