package com.app.citizen.service;

import com.app.citizen.domain.HouseholdDto;
import com.app.citizen.domain.HouseholdResidentDto;
import com.app.citizen.entity.HouseholdMovementAddress;
import com.app.citizen.repository.HouseholdRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseholdService {

  private HouseholdRepository householdRepository;

  public HouseholdService(HouseholdRepository householdRepository) {
    this.householdRepository = householdRepository;
  }
  public HouseholdResidentDto findResidentBy(int serialNumber) {
    return householdRepository.findBy(serialNumber);
  }

  public List<HouseholdDto> findHouseholdBy(int serialNumber) {
    return householdRepository.findAllBy(serialNumber);
  }

  public List<HouseholdMovementAddress> findMovementsBy(int serialNumber) {
    return householdRepository.findHouseholdBy(serialNumber);
  }

}
