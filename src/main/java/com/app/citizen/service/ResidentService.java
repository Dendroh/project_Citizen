package com.app.citizen.service;

import com.app.citizen.domain.BirthDeathReportResidentDto;
import com.app.citizen.entity.Resident;
import com.app.citizen.repository.BirthDeathReportResidentRepository;
import com.app.citizen.repository.ResidentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidentService {

  private ResidentRepository residentRepository;

  private BirthDeathReportResidentRepository birthDeathReportResidentRepository;

  public ResidentService(ResidentRepository residentRepository, BirthDeathReportResidentRepository birthDeathReportResidentRepository) {
    this.residentRepository = residentRepository;
    this.birthDeathReportResidentRepository = birthDeathReportResidentRepository;
  }

  public List<Resident> findAllBy() {
    return residentRepository.findAll();
  }

  public Resident findResidentBy(int serialNumber) {
    return residentRepository.findResidentByResidentSerialNumber(serialNumber);
  }

  public List<BirthDeathReportResidentDto> findBirthReportResident(int serialNumber) {
    return birthDeathReportResidentRepository.findBirthDtoBy(serialNumber);
  }

  public List<BirthDeathReportResidentDto> findDeathReportResident(int serialNumber) {
    return birthDeathReportResidentRepository.findDeathDtoBy(serialNumber);
  }
}
