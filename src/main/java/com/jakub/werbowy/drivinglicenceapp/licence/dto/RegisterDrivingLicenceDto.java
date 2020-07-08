package com.jakub.werbowy.drivinglicenceapp.licence.dto;

import com.jakub.werbowy.drivinglicenceapp.subject.dto.SubjectDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Getter
@RequiredArgsConstructor
@Builder
public class RegisterDrivingLicenceDto {

    private final String issuingAuthority;
    private final String number;
    private final Set<CategoryDto> categories;
    private final SubjectDto subject;
}
