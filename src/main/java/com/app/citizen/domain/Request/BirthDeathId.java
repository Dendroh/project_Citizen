package com.app.citizen.domain.Request;

import lombok.Data;

@Data
public class BirthDeathId {
    private int residentSerialNumber;
    private String birthDeathTypeCode;
    private int reportResidentSerialNumber;
}
