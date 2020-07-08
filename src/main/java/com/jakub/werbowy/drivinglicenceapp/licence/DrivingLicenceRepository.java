package com.jakub.werbowy.drivinglicenceapp.licence;


import org.springframework.data.repository.Repository;

public interface DrivingLicenceRepository extends Repository<DrivingLicenceEntity, Long> {

    DrivingLicenceEntity save(DrivingLicenceEntity entity);
}
