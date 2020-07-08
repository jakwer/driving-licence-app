package com.jakub.werbowy.drivinglicenceapp.licence;

import com.jakub.werbowy.drivinglicenceapp.licence.dto.RegisterDrivingLicenceDto;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
class DrivingLicenceRegistration {

    private final DrivingLicenceRegistrationService drivingLicenceRegistrationService;
    private final RegisterDrivingLicenceValidator registerDrivingLicenceValidator;

    RegisterDrivingLicenceDto register(RegisterDrivingLicenceDto dto) {
        return Optional.of(dto)
                .filter(registerDrivingLicenceValidator::validate)
                .map(drivingLicenceRegistrationService::save)
                .orElseThrow(() -> new DrivingLicenceRegistrationException("Registration licence error."));
    }
}
