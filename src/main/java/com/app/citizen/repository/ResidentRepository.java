package com.app.citizen.repository;

import com.app.citizen.entity.Resident;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentRepository extends JpaRepository<Resident, Integer> {
  public Resident findResidentByResidentSerialNumber(int serialNumber);

  Page<Resident> getAllBy(Pageable pageable);
}
