package com.app.citizen.service;

import com.app.citizen.domain.*;
import com.app.citizen.entity.Authority;
import com.app.citizen.entity.Member;
import com.app.citizen.entity.Resident;
import com.app.citizen.repository.BirthDeathReportResidentRepository;
import com.app.citizen.repository.ResidentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

  @Transactional
  public ResidentId registerResident(ResidentRegisterRequest request) {
    Resident resident = new Resident();
    resident.setResidentSerialNumber(request.getResidentSerialNumber());
    resident.setName(request.getName());
    resident.setResidentRegistrationNumber(request.getResidentRegistrationNumber());
    resident.setGenderCode(request.getGenderCode());
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    resident.setBirthDate(LocalDateTime.parse(request.getBirthDate(), formatter));
    resident.setBirthPlaceCode(request.getBirthPlaceCode());
    resident.setRegistrationBaseAddress(request.getRegistrationBaseAddress());

    residentRepository.saveAndFlush(resident);

    ResidentId residentId = new ResidentId();
    residentId.setResidentSerialNumber(resident.getResidentSerialNumber());

    return residentId;
  }
}
