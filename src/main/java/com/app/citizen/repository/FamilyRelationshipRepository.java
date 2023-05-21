package com.app.citizen.repository;

import com.app.citizen.domain.FamilyResidentDto;
import com.app.citizen.entity.FamilyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship, FamilyRelationship.Pk> {

  @Query("select new com.app.citizen.domain.FamilyResidentDto(f.familyRelationshipCode, fR.name, fR.birthDate, fR.residentRegistrationNumber, fR.genderCode, fR.registrationBaseAddress) from FamilyRelationship f left join f.baseResident bR join f.familyResident fR where bR.residentSerialNumber = :id")
  public List<FamilyResidentDto> findBy(@Param("id") int id);
}