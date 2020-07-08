package com.jakub.werbowy.drivinglicenceapp.licence;

import com.jakub.werbowy.drivinglicenceapp.exception.UnexpectedException;
import com.jakub.werbowy.drivinglicenceapp.licence.dto.RegisterDrivingLicenceDto;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
class DrivingLicenceRegistrationService {

    private final DrivingLicenceRepository drivingLicenceRepository;
    private final DrivingLicenceEntityFactory drivingLicenceEntityFactory;
    private final DrivingLicenceDtoFactory drivingLicenceDtoFactory;

    RegisterDrivingLicenceDto save(RegisterDrivingLicenceDto registerDrivingLicenceDto) {
        return Optional.of(registerDrivingLicenceDto)
                .map(drivingLicenceEntityFactory::create)
                .map(drivingLicenceRepository::save)
                .map(drivingLicenceDtoFactory::create)
                .orElseThrow(UnexpectedException::new);
    }
}
