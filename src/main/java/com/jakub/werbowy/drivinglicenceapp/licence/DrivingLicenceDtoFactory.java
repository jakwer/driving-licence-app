package com.jakub.werbowy.drivinglicenceapp.licence;

import com.jakub.werbowy.drivinglicenceapp.licence.dto.RegisterDrivingLicenceDto;
import com.jakub.werbowy.drivinglicenceapp.licence.dto.RegisterDrivingLicenceRequest;
import com.jakub.werbowy.drivinglicenceapp.licence.dto.RegisterDrivingLicenceResponse;
import com.jakub.werbowy.drivinglicenceapp.subject.SubjectFacade;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DrivingLicenceDtoFactory {

    private final DrivingLicenceCategoryFactory drivingLicenceCategoryFactory;
    private final SubjectFacade subjectFacade;

    RegisterDrivingLicenceDto create(DrivingLicenceEntity entity) {
        return RegisterDrivingLicenceDto.builder()
                .categories(drivingLicenceCategoryFactory.createDtos(entity.getDrivingLicenceCategories()))
                .issuingAuthority(entity.getIssuingAuthority())
                .number(entity.getNumber())
                .subject(subjectFacade.findById(entity.getSubjectId()))
                .build();
    }

    RegisterDrivingLicenceDto create(RegisterDrivingLicenceRequest registerDrivingLicenceRequest) {
        return RegisterDrivingLicenceDto.builder()
                .issuingAuthority(registerDrivingLicenceRequest.getIssuingAuthority())
                .number(registerDrivingLicenceRequest.getNumber())
                .categories(registerDrivingLicenceRequest.getCategories())
                .subject(subjectFacade.findById(registerDrivingLicenceRequest.getSubjectId()))
                .build();
    }

    public RegisterDrivingLicenceResponse create(RegisterDrivingLicenceDto dto) {
        return RegisterDrivingLicenceResponse.builder()
                .issuingAuthority(dto.getIssuingAuthority())
                .number(dto.getNumber())
                .categories(dto.getCategories())
                .subject(dto.getSubject())
                .build();
    }
}
