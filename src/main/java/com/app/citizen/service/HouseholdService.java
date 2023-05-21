package com.app.citizen.service;

import com.app.citizen.domain.HouseholdDto;
import com.app.citizen.repository.HouseholdRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseholdService {

  private HouseholdRepository householdRepository;

  public HouseholdService(HouseholdRepository householdRepository) {
    this.householdRepository = householdRepository;
  }
  public List<HouseholdDto> findResidentsBy(int serialNumber) {
    return householdRepository.findBy(serialNumber);
  }

}
