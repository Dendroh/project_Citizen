package com.app.citizen.repository;

import com.app.citizen.domain.BirthDeathReportResidentDto;
import com.app.citizen.entity.BirthDeathReportResident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BirthDeathReportResidentRepository extends JpaRepository<BirthDeathReportResident, BirthDeathReportResident.Pk> {
  @Query("select new com.app.citizen.domain.BirthDeathReportResidentDto(brR.birthReportQualificationsCode, rR.name, rR.residentRegistrationNumber, brR.phoneNumber, brR.emailAddress) from BirthDeathReportResident brR join brR.reportResident rR where (brR.pk.residentSerialNumber = :id and brR.pk.birthDeathTypeCode = '출생')")
  public List<BirthDeathReportResidentDto> findBirthDtoBy(@Param("id") int id);


  @Query("select new com.app.citizen.domain.BirthDeathReportResidentDto(brR.deathReportQualificationsCode, rR.name, rR.residentRegistrationNumber, brR.phoneNumber, brR.emailAddress) from BirthDeathReportResident brR join brR.reportResident rR where (brR.pk.residentSerialNumber = :id and brR.pk.birthDeathTypeCode = '사망')")
  public List<BirthDeathReportResidentDto> findDeathDtoBy(@Param("id") int id);
}
