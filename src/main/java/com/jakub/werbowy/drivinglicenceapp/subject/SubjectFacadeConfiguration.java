package com.jakub.werbowy.drivinglicenceapp.subject;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
class SubjectFacadeConfiguration {

    private final SubjectRepository subjectRepository;

    @Bean
    SubjectFacade subjectFacade() {
        return new SubjectFacade(new SubjectFinder(subjectRepository, new SubjectFactory()));
    }
}
