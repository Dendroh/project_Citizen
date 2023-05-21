package com.app.citizen.service;

import com.app.citizen.domain.BirthDeathReportResidentDto;
import com.app.citizen.domain.Request.BirthDeathId;
import com.app.citizen.domain.Request.BirthDeathRegisterRequest;
import com.app.citizen.domain.Request.ResidentId;
import com.app.citizen.domain.Request.ResidentRegisterRequest;
import com.app.citizen.entity.BirthDeathReportResident;
import com.app.citizen.entity.Resident;
import com.app.citizen.repository.BirthDeathReportResidentRepository;
import com.app.citizen.repository.ResidentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
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

  public Page<Resident> findAllBy(Pageable pageable) {
    return residentRepository.getAllBy(pageable);
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


  @Transactional
  public ResidentId editResident(ResidentRegisterRequest request, String serialNumber) {
    Resident resident = new Resident();
    resident.setResidentSerialNumber(Integer.parseInt(serialNumber));
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



  @Transactional
  public void deleteResident(String serialNumber) {

    residentRepository.deleteById(Integer.parseInt(serialNumber));
  }

  @Transactional
  public BirthDeathId registerBirthDeath(BirthDeathRegisterRequest request, String serialNumber) {
    BirthDeathReportResident birthDeathReportResident = new BirthDeathReportResident();
    BirthDeathReportResident.Pk pk = new BirthDeathReportResident.Pk();
    pk.setResidentSerialNumber(request.getTargetResidentSerialNumber());
    pk.setReportResident(Integer.parseInt(serialNumber));
    pk.setBirthDeathTypeCode(request.getBirthDeathTypeCode());
    birthDeathReportResident.setPk(pk);
    birthDeathReportResident.setBirthDeathResident(findResidentBy(request.getTargetResidentSerialNumber()));
    birthDeathReportResident.setReportResident(findResidentBy(Integer.parseInt(serialNumber)));
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate date = LocalDate.parse(request.getBirthDeathReportDate(), formatter);
    birthDeathReportResident.setBirthDeathReportDate(date.atStartOfDay());
    birthDeathReportResident.setBirthReportQualificationsCode(request.getBirthReportQualificationsCode());
    birthDeathReportResident.setDeathReportQualificationsCode(request.getDeathReportQualificationsCode());
    birthDeathReportResident.setEmailAddress(request.getEmailAddress());
    birthDeathReportResident.setPhoneNumber(request.getPhoneNumber());

    birthDeathReportResidentRepository.saveAndFlush(birthDeathReportResident);

    BirthDeathId birthDeathId = new BirthDeathId();
    birthDeathId.setResidentSerialNumber(request.getTargetResidentSerialNumber());
    birthDeathId.setReportResidentSerialNumber(Integer.parseInt(serialNumber));
    birthDeathId.setBirthDeathTypeCode(request.getBirthDeathTypeCode());

    return birthDeathId;
  }


  @Transactional
  public BirthDeathId editBirthDeath(BirthDeathRegisterRequest request, String serialNumber, String targetSerialNumber) {
    BirthDeathReportResident birthDeathReportResident = new BirthDeathReportResident();
    BirthDeathReportResident.Pk pk = new BirthDeathReportResident.Pk();
    pk.setResidentSerialNumber(Integer.parseInt(targetSerialNumber));
    pk.setReportResident(Integer.parseInt(serialNumber));
    pk.setBirthDeathTypeCode(request.getBirthDeathTypeCode());
    birthDeathReportResident.setPk(pk);
    birthDeathReportResident.setBirthDeathResident(findResidentBy(Integer.parseInt(targetSerialNumber)));
    birthDeathReportResident.setReportResident(findResidentBy(Integer.parseInt(serialNumber)));
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate date = LocalDate.parse(request.getBirthDeathReportDate(), formatter);
    birthDeathReportResident.setBirthDeathReportDate(date.atStartOfDay());
    birthDeathReportResident.setBirthReportQualificationsCode(request.getBirthReportQualificationsCode());
    birthDeathReportResident.setDeathReportQualificationsCode(request.getDeathReportQualificationsCode());
    birthDeathReportResident.setEmailAddress(request.getEmailAddress());
    birthDeathReportResident.setPhoneNumber(request.getPhoneNumber());

    birthDeathReportResidentRepository.saveAndFlush(birthDeathReportResident);

    BirthDeathId birthDeathId = new BirthDeathId();
    birthDeathId.setResidentSerialNumber(Integer.parseInt(targetSerialNumber));
    birthDeathId.setReportResidentSerialNumber(Integer.parseInt(serialNumber));
    birthDeathId.setBirthDeathTypeCode(request.getBirthDeathTypeCode());

    return birthDeathId;
  }


  @Transactional
  public void deleteBirthDeath(BirthDeathRegisterRequest request, String serialNumber, String targetSerialNumber) {
    BirthDeathReportResident.Pk pk = new BirthDeathReportResident.Pk();
    pk.setResidentSerialNumber(Integer.parseInt(targetSerialNumber));
    pk.setReportResident(Integer.parseInt(serialNumber));
    pk.setBirthDeathTypeCode(request.getBirthDeathTypeCode());

    birthDeathReportResidentRepository.deleteById(pk);
  }
}
