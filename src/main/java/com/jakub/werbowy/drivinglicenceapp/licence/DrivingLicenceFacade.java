package com.jakub.werbowy.drivinglicenceapp.licence;

import com.jakub.werbowy.drivinglicenceapp.licence.dto.RegisterDrivingLicenceDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DrivingLicenceFacade {

    private final DrivingLicenceRegistration drivingLicenceRegistration;

    public RegisterDrivingLicenceDto register(RegisterDrivingLicenceDto dto) {
        return drivingLicenceRegistration.register(dto);
    }
}
