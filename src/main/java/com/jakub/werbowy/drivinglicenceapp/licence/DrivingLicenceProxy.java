package com.jakub.werbowy.drivinglicenceapp.licence;

import com.jakub.werbowy.drivinglicenceapp.exception.UnexpectedException;
import com.jakub.werbowy.drivinglicenceapp.licence.dto.RegisterDrivingLicenceRequest;
import com.jakub.werbowy.drivinglicenceapp.licence.dto.RegisterDrivingLicenceResponse;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
class DrivingLicenceProxy {

    private final DrivingLicenceFacade drivingLicenceFacade;
    private final DrivingLicenceDtoFactory drivingLicenceDtoFactory;

    public RegisterDrivingLicenceResponse execute(RegisterDrivingLicenceRequest registerDrivingLicenceRequest) {
        return Optional.of(registerDrivingLicenceRequest)
                .map(drivingLicenceDtoFactory::create)
                .map(drivingLicenceFacade::register)
                .map(drivingLicenceDtoFactory::create)
                .orElseThrow(UnexpectedException::new);
    }
}
