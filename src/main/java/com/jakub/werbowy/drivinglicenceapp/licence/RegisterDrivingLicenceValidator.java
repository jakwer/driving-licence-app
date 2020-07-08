package com.jakub.werbowy.drivinglicenceapp.licence;

import com.jakub.werbowy.drivinglicenceapp.licence.dto.RegisterDrivingLicenceDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class RegisterDrivingLicenceValidator {

    private final List<RegisterDrivingLicencePredicate> predicates;

    boolean validate(RegisterDrivingLicenceDto registerDrivingLicenceDto) {
        return predicates.stream()
                .allMatch(predicate -> predicate.test(registerDrivingLicenceDto));
    }
}
