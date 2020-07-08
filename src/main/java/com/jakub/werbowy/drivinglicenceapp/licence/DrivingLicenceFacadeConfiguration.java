package com.jakub.werbowy.drivinglicenceapp.licence;

import com.google.common.collect.Lists;
import com.jakub.werbowy.drivinglicenceapp.subject.SubjectFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
class DrivingLicenceFacadeConfiguration {

    private final DrivingLicenceRepository drivingLicenceRepository;
    private final SubjectFacade subjectFacade;

    @Bean
    DrivingLicenceFacade drivingLicenceFacade() {

        final DrivingLicenceEntityFactory drivingLicenceEntityFactory = new DrivingLicenceEntityFactory(new DrivingLicenceCategoryFactory());
        final DrivingLicenceDtoFactory drivingLicenceDtoFactory = new DrivingLicenceDtoFactory(new DrivingLicenceCategoryFactory(), subjectFacade);
        final DrivingLicenceRegistrationService drivingLicenceRegistrationService = new DrivingLicenceRegistrationService(drivingLicenceRepository, drivingLicenceEntityFactory, drivingLicenceDtoFactory);
        final RegisterDrivingLicenceValidator registerDrivingLicenceValidator = new RegisterDrivingLicenceValidator(createRegisterDrivingLicencePredicate());
        final DrivingLicenceRegistration drivingLicenceRegistration = new DrivingLicenceRegistration(drivingLicenceRegistrationService, registerDrivingLicenceValidator);
        return new DrivingLicenceFacade(drivingLicenceRegistration);
    }

    private List<RegisterDrivingLicencePredicate> createRegisterDrivingLicencePredicate() {
        return Lists.newArrayList(
                new RegisterDrivingLicenceRequiredFieldsPredicate(),
                new RegisterDrivingLicenceCategoriesPredicate(),
                new RegisterDrivingLicenceDriverExamPredicate()
        );
    }
}
