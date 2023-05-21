package com.app.citizen.repository;

import com.app.citizen.domain.HouseholdDto;
import com.app.citizen.domain.HouseholdResidentDto;
import com.app.citizen.entity.Household;
import com.app.citizen.entity.HouseholdMovementAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HouseholdRepository extends JpaRepository<Household, Integer> {
  @Query("SELECT new com.app.citizen.domain.HouseholdResidentDto(hr.name, h.householdCompositionDate, h.householdCompositionReasonCode) " +
          "FROM Household h " +
          "join h.householdResident hr " +
          "WHERE h.householdSerialNumber " +
          "IN (" +
          "SELECT h.householdSerialNumber " +
          "FROM Household h " +
          "LEFT JOIN HouseholdCompositionResident hcr2 " +
          "ON hcr2.pk.householdSerialNumber = h.householdSerialNumber " +
          "WHERE hcr2.pk.residentSerialNumber = :id)" +
          "")
  public HouseholdResidentDto findBy(@Param("id") int id);

  @Query("SELECT hma " +
          "FROM HouseholdMovementAddress hma " +
          "join hma.movedHousehold " +
          "WHERE hma.pk.householdSerialNumber " +
          "IN (" +
          "SELECT h.householdSerialNumber " +
          "FROM Household h " +
          "LEFT JOIN HouseholdCompositionResident hcr2 " +
          "ON hcr2.pk.householdSerialNumber = h.householdSerialNumber " +
          "WHERE hcr2.pk.residentSerialNumber = :id)" +
          "")
  public List<HouseholdMovementAddress> findHouseholdBy(@Param("id") int id);

  @Query("SELECT new com.app.citizen.domain.HouseholdDto(hcr.householdRelationshipCode, r.name, r.residentRegistrationNumber, hcr.HouseholdReportDate, hcr.householdCompositionChangeReasonCode) " +
          "FROM HouseholdCompositionResident hcr " +
          "join hcr.householdCompositionResident r " +
          "WHERE hcr.pk.householdSerialNumber " +
          "IN (" +
          "SELECT h.householdSerialNumber " +
          "FROM Household h " +
          "LEFT JOIN HouseholdCompositionResident hcr2 " +
          "ON hcr2.pk.householdSerialNumber = h.householdSerialNumber " +
          "WHERE hcr2.pk.residentSerialNumber = :id)" +
          "")
  public List<HouseholdDto> findAllBy(@Param("id") int id);

}
