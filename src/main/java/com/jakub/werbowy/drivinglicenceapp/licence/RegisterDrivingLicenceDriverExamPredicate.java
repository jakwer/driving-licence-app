package com.jakub.werbowy.drivinglicenceapp.licence;

import com.jakub.werbowy.drivinglicenceapp.licence.dto.RegisterDrivingLicenceDto;
import com.jakub.werbowy.drivinglicenceapp.subject.ExamResult;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
class RegisterDrivingLicenceDriverExamPredicate implements RegisterDrivingLicencePredicate {

    @Override
    public boolean test(RegisterDrivingLicenceDto registerDrivingLicenceDto) {
        return Optional.of(registerDrivingLicenceDto)
                .map(dto -> registerDrivingLicenceDto.getSubject())
                .filter(dto -> ExamResult.PASSED == dto.getExamResult())
                .isPresent();
    }
}
