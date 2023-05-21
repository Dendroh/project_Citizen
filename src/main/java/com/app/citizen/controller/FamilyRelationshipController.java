package com.app.citizen.controller;

import com.app.citizen.service.ResidentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class FamilyRelationshipController {

  private ResidentService residentService;

  public FamilyRelationshipController(ResidentService residentService) {
    this.residentService = residentService;
  }

  @GetMapping("/main")
  public String homeGet(Model model) {
    model.addAttribute("residentList", residentService.findAllBy());
    return "main";
  }
}
