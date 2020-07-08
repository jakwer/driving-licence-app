package com.jakub.werbowy.drivinglicenceapp.licence;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class InMemoryDrivingLicenceRepository implements DrivingLicenceRepository {

    private final Map<Long, DrivingLicenceEntity> drivingLicences = new HashMap<>();

    @Override
    public DrivingLicenceEntity save(DrivingLicenceEntity entity) {
        long id = new Random().nextLong();
        drivingLicences.put(id, entity.withId(id));
        return drivingLicences.get(id);
    }
}
