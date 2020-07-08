package com.jakub.werbowy.drivinglicenceapp.licence;

import com.jakub.werbowy.drivinglicenceapp.licence.dto.RegisterDrivingLicenceDto;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
class DrivingLicenceEntityFactory {

    private final DrivingLicenceCategoryFactory drivingLicenceCategoryFactory;

    DrivingLicenceEntity create(RegisterDrivingLicenceDto dto) {
        return DrivingLicenceEntity.builder()
                .issuingAuthority(dto.getIssuingAuthority())
                .businessId(UUID.randomUUID().toString())
                .number(dto.getNumber())
                .subjectId(dto.getSubject().getSubjectId())
                .drivingLicenceCategories(drivingLicenceCategoryFactory.createEntities(dto.getCategories()))
                .build();
    }
}
