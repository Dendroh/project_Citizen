package com.app.citizen.service;

import com.app.citizen.domain.FamilyResidentDto;
import com.app.citizen.domain.Request.FamilyId;
import com.app.citizen.domain.Request.FamilyRegisterRequest;
import com.app.citizen.entity.FamilyRelationship;
import com.app.citizen.repository.FamilyRelationshipRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FamilyRelationshipService {

  private FamilyRelationshipRepository familyRelationshipRepository;
  private ResidentService residentService;

  public FamilyRelationshipService(FamilyRelationshipRepository familyRelationshipRepository, ResidentService residentService) {
    this.familyRelationshipRepository = familyRelationshipRepository;
    this.residentService = residentService;
  }

  public List<FamilyResidentDto> findResidentsBy(int serialNumber) {
    return familyRelationshipRepository.findBy(serialNumber);
  }

  public List<FamilyResidentDto> findParentsBy(int serialNumber) {
    return familyRelationshipRepository.getBy(serialNumber);
  }

  @Transactional
  public FamilyId registerFamily(FamilyRegisterRequest request, String baseResidentSerialNumber) {
    FamilyRelationship familyRelationship = new FamilyRelationship();
    FamilyRelationship.Pk pk = new FamilyRelationship.Pk();
    pk.setBaseResidentSerialNumber(Integer.parseInt(baseResidentSerialNumber));
    pk.setFamilyResidentSerialNumber(request.getFamilyResidentSerialNumber());
    familyRelationship.setPk(pk);
    familyRelationship.setBaseResident(residentService.findResidentBy(Integer.parseInt(baseResidentSerialNumber)));
    familyRelationship.setFamilyResident(residentService.findResidentBy(request.getFamilyResidentSerialNumber()));
    familyRelationship.setFamilyRelationshipCode(request.getFamilyRelationshipCode());

    familyRelationshipRepository.saveAndFlush(familyRelationship);

    FamilyId familyId = new FamilyId();
    familyId.setFamilyResidentSerialNumber(familyRelationship.getPk().getFamilyResidentSerialNumber());
    familyId.setRelationship(familyRelationship.getFamilyRelationshipCode());

    return familyId;
  }

  @Transactional
  public FamilyId editFamily(FamilyRegisterRequest request, String baseResidentSerialNumber, String familyResidentSerialNumber) {
    FamilyRelationship familyRelationship = new FamilyRelationship();
    FamilyRelationship.Pk pk = new FamilyRelationship.Pk();
    pk.setBaseResidentSerialNumber(Integer.parseInt(baseResidentSerialNumber));
    pk.setFamilyResidentSerialNumber(Integer.parseInt(familyResidentSerialNumber));
    familyRelationship.setPk(pk);
    familyRelationship.setBaseResident(residentService.findResidentBy(Integer.parseInt(baseResidentSerialNumber)));
    familyRelationship.setFamilyResident(residentService.findResidentBy(Integer.parseInt(familyResidentSerialNumber)));
    familyRelationship.setFamilyRelationshipCode(request.getFamilyRelationshipCode());

    familyRelationshipRepository.saveAndFlush(familyRelationship);

    FamilyId familyId = new FamilyId();
    familyId.setFamilyResidentSerialNumber(familyRelationship.getPk().getFamilyResidentSerialNumber());
    familyId.setRelationship(familyRelationship.getFamilyRelationshipCode());

    return familyId;
  }

  @Transactional
  public void deleteFamily(String baseResidentSerialNumber, String familyResidentSerialNumber) {
    FamilyRelationship.Pk pk = new FamilyRelationship.Pk();
    pk.setBaseResidentSerialNumber(Integer.parseInt(baseResidentSerialNumber));
    pk.setFamilyResidentSerialNumber(Integer.parseInt(familyResidentSerialNumber));

    familyRelationshipRepository.deleteById(pk);
  }
}
