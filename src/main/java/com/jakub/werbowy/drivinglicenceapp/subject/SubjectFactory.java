package com.jakub.werbowy.drivinglicenceapp.subject;

import com.jakub.werbowy.drivinglicenceapp.subject.dto.SubjectDto;

class SubjectFactory {

    SubjectDto create(SubjectEntity entity) {
        return SubjectDto.builder()
                .examResult(entity.getExamResult())
                .name(entity.getName())
                .surname(entity.getSurname())
                .build();
    }
}
