package com.jakub.werbowy.drivinglicenceapp.subject;

import com.jakub.werbowy.drivinglicenceapp.subject.dto.SubjectDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SubjectFacade {

    private final SubjectFinder subjectFinder;

    public SubjectDto findById(String subjectId) {
        return subjectFinder.findBy(subjectId);
    }
}
