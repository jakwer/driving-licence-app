package com.jakub.werbowy.drivinglicenceapp.subject;

import org.springframework.data.repository.Repository;

import java.util.Optional;

interface SubjectRepository extends Repository<SubjectEntity, Long> {

    Optional<SubjectEntity> findByBusinessId(String id);

}
