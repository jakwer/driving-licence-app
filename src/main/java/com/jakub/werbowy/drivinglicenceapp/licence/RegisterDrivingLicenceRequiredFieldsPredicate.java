package com.jakub.werbowy.drivinglicenceapp.licence;

import com.jakub.werbowy.drivinglicenceapp.licence.dto.RegisterDrivingLicenceDto;

import java.util.Optional;

import static java.util.Objects.nonNull;

class RegisterDrivingLicenceRequiredFieldsPredicate implements RegisterDrivingLicencePredicate {

    @Override
    public boolean test(RegisterDrivingLicenceDto registerDrivingLicenceDto) {
        return Optional.of(registerDrivingLicenceDto)
                .filter(dto -> nonNull(dto.getSubject()))
                .filter(dto -> nonNull(dto.getIssuingAuthority()))
                .filter(dto -> nonNull(dto.getNumber()))
                .filter(dto -> nonNull(dto.getCategories()))
                .filter(dto -> nonNull(dto.getSubject()))
                .filter(dto -> dto.getCategories().size() > 0)
                .isPresent();
    }
}
