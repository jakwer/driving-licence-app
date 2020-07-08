package com.jakub.werbowy.drivinglicenceapp.licence

import com.google.common.collect.Sets
import com.jakub.werbowy.drivinglicenceapp.licence.dto.CategoryDto
import com.jakub.werbowy.drivinglicenceapp.licence.dto.CategoryNumber
import com.jakub.werbowy.drivinglicenceapp.licence.dto.RegisterDrivingLicenceDto
import com.jakub.werbowy.drivinglicenceapp.subject.ExamResult
import com.jakub.werbowy.drivinglicenceapp.subject.SubjectFacade
import com.jakub.werbowy.drivinglicenceapp.subject.dto.SubjectDto
import spock.lang.Specification

import java.time.LocalDateTime

class DrivingLicenceFacadeTest extends Specification {

    SubjectFacade subjectFacade = Mock()
    DrivingLicenceFacade sut = new DrivingLicenceFacadeConfiguration(new InMemoryDrivingLicenceRepository(), subjectFacade).drivingLicenceFacade()

    def "should throw exception when register and not passed required data"() {
        setup:
        RegisterDrivingLicenceDto dto = RegisterDrivingLicenceDto.builder().build()

        when:
        sut.register(dto)

        then:
        thrown(DrivingLicenceRegistrationException)
    }

    def "should throw exception when register and expiration date before release date"() {
        setup:
        LocalDateTime now = LocalDateTime.now()
        RegisterDrivingLicenceDto dto = createRegisterDrivingLicenceDto(
                createCategories(now, now.minusDays(3L)),
                createSubject("c43eaca9-9626-4ebb-8dc2-7d81b77b82f1", ExamResult.PASSED)
        )

        when:
        sut.register(dto)

        then:
        thrown(DrivingLicenceRegistrationException)
    }

    def "should throw exception when register and exam failed"() {
        setup:
        LocalDateTime now = LocalDateTime.now()
        RegisterDrivingLicenceDto dto = createRegisterDrivingLicenceDto(
                createCategories(now, null),
                createSubject("c43eaca9-9626-4ebb-8dc2-7d81b77b82f1", ExamResult.FAILED)
        )

        when:
        sut.register(dto)

        then:
        thrown(DrivingLicenceRegistrationException)
    }

    def "should register driving licence"() {
        setup:
        LocalDateTime now = LocalDateTime.now()
        def subject = createSubject("c43eaca9-9626-4ebb-8dc2-7d81b77b82f1", ExamResult.PASSED)
        RegisterDrivingLicenceDto dto = createRegisterDrivingLicenceDto(
                createCategories(now, null),
                subject
        )

        when:
        subjectFacade.findById(subject.getSubjectId()) >> subject
        def result = sut.register(dto)

        then:
        result.getIssuingAuthority() == dto.getIssuingAuthority()
        result.getNumber() == dto.getNumber()
        result.getSubject().getExamResult() == result.getSubject().getExamResult()
        result.getSubject().getName() == result.getSubject().getName()
        result.getSubject().getSurname() == result.getSubject().getSurname()
        result.getSubject().getSubjectId() == subject.getSubjectId()
    }

    private static RegisterDrivingLicenceDto createRegisterDrivingLicenceDto(Set<CategoryDto> categories, SubjectDto subjectDto) {
        RegisterDrivingLicenceDto.builder()
                .issuingAuthority("URZĄD MIASTA WARSZAWA")
                .number("123123123")
                .categories(categories)
                .subject(subjectDto)
                .build()
    }


    static Set<CategoryDto> createCategories(LocalDateTime releaseDate, LocalDateTime expirationDate) {
        Sets.newHashSet(createCategory(CategoryNumber.A, releaseDate, expirationDate))
    }

    static SubjectDto createSubject(String id, ExamResult examResult) {
        SubjectDto.builder()
                .subjectId(id)
                .examResult(examResult)
                .name("Marcin")
                .surname("Kowal")
                .build()
    }

    static CategoryDto createCategory(CategoryNumber categoryNumber, LocalDateTime releaseDate, expirationDate) {
        CategoryDto.builder()
                .categoryNumber(categoryNumber)
                .releaseDate(releaseDate)
                .expirationDate(expirationDate)
                .build()
    }
}
