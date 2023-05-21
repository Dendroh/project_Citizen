package com.app.citizen.service;

import com.app.citizen.entity.Resident;
import com.app.citizen.repository.ResidentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidentService {

  private ResidentRepository residentRepository;

  public ResidentService(ResidentRepository residentRepository) {
    this.residentRepository = residentRepository;
  }

  public List<Resident> findAllBy() {
    return residentRepository.findAll();
  }
}
