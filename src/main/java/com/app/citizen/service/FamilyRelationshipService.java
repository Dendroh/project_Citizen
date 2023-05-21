package com.app.citizen.service;

import com.app.citizen.domain.FamilyResidentDto;
import com.app.citizen.repository.FamilyRelationshipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyRelationshipService {

  private FamilyRelationshipRepository familyRelationshipRepository;

  public FamilyRelationshipService(FamilyRelationshipRepository familyRelationshipRepository) {
    this.familyRelationshipRepository = familyRelationshipRepository;
  }
  public List<FamilyResidentDto> findResidentsBy(int serialNumber) {
    return familyRelationshipRepository.findBy(serialNumber);
  }

  public List<FamilyResidentDto> findParentsBy(int serialNumber) {
    return familyRelationshipRepository.getBy(serialNumber);
  }
}
