package com.jakub.werbowy.drivinglicenceapp.subject.dto;

import com.jakub.werbowy.drivinglicenceapp.subject.ExamResult;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SubjectDto {

    private final String subjectId;
    private final String name;
    private final String surname;
    private final ExamResult examResult;
}
