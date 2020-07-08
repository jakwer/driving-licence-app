package com.jakub.werbowy.drivinglicenceapp.licence;

import com.jakub.werbowy.drivinglicenceapp.licence.dto.RegisterDrivingLicenceRequest;
import com.jakub.werbowy.drivinglicenceapp.licence.dto.RegisterDrivingLicenceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/licence")
@RequiredArgsConstructor
class DrivingLicenceController {

    private final DrivingLicenceProxy drivingLicenceProxy;

    @PostMapping("/register")
    ResponseEntity<RegisterDrivingLicenceResponse> registerDrivingLicence(@RequestBody RegisterDrivingLicenceRequest registerDrivingLicenceRequest) {
        return new ResponseEntity<>(drivingLicenceProxy.execute(registerDrivingLicenceRequest), HttpStatus.NOT_IMPLEMENTED);
    }
}
