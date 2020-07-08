package com.jakub.werbowy.drivinglicenceapp.licence.dto;

import com.jakub.werbowy.drivinglicenceapp.subject.dto.SubjectDto;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
@Builder
public class RegisterDrivingLicenceResponse {

    private final String issuingAuthority;
    private final String number;
    private final Set<CategoryDto> categories;
    private final SubjectDto subject;

}
