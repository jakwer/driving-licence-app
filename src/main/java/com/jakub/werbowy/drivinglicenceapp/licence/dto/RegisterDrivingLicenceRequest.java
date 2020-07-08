package com.jakub.werbowy.drivinglicenceapp.licence.dto;

import lombok.Getter;

import java.util.Set;

@Getter
public class RegisterDrivingLicenceRequest {

    private String issuingAuthority;
    private String number;
    private Set<CategoryDto> categories;
    private String subjectId;

}
