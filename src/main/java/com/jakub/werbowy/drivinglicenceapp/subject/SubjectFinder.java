package com.jakub.werbowy.drivinglicenceapp.subject;

import com.jakub.werbowy.drivinglicenceapp.subject.dto.SubjectDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class SubjectFinder {

    private final SubjectRepository subjectRepository;
    private final SubjectFactory subjectFactory;

    SubjectDto findBy(String id) {
        return subjectRepository.findByBusinessId(id)
                .map(subjectFactory::create)
                .orElseThrow(() -> new FindSubjectException("Subject not found"));
    }
}
