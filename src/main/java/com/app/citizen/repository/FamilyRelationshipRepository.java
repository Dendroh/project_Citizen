package com.app.citizen.repository;

import com.app.citizen.entity.FamilyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship, FamilyRelationship.Pk> {

  @Query("select f from FamilyRelationship f left join fetch f.baseResident r where r.residentSerialNumber = 4")
  public List<FamilyRelationship> findBy();
}
