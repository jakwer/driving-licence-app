package com.jakub.werbowy.drivinglicenceapp.licence;

import com.jakub.werbowy.drivinglicenceapp.subject.SubjectFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DrivingLicenceProxyConfiguration {

    @Bean
    DrivingLicenceProxy drivingLicenceProxy(DrivingLicenceFacade drivingLicenceFacade, SubjectFacade subjectFacade) {
        return new DrivingLicenceProxy(drivingLicenceFacade, new DrivingLicenceDtoFactory(new DrivingLicenceCategoryFactory(), subjectFacade));
    }
}
