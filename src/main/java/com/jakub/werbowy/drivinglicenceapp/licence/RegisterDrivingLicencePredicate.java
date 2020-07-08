package com.jakub.werbowy.drivinglicenceapp.licence;

import com.jakub.werbowy.drivinglicenceapp.licence.dto.RegisterDrivingLicenceDto;

interface RegisterDrivingLicencePredicate {

    boolean test(RegisterDrivingLicenceDto registerDrivingLicenceDto);
}
