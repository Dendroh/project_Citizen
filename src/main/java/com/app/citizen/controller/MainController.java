package com.app.citizen.controller;

import com.app.citizen.service.ResidentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class MainController {
  private ResidentService residentService;

  public MainController(ResidentService residentService) {
    this.residentService = residentService;
  }

  @GetMapping("/main")
  public String homeGet(Model model, @PageableDefault(size = 4, page = 0) Pageable pageable) {
      model.addAttribute("residents", residentService.findAllBy(pageable));
      model.addAttribute("page", pageable.getPageNumber());
      model.addAttribute("size", pageable.getPageSize());
    return "main";
  }
}
