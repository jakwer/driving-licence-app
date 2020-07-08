package com.jakub.werbowy.drivinglicenceapp.licence;

import com.jakub.werbowy.drivinglicenceapp.licence.dto.CategoryDto;
import com.jakub.werbowy.drivinglicenceapp.licence.dto.RegisterDrivingLicenceDto;

import java.util.Optional;
import java.util.Set;

import static java.util.Objects.nonNull;

class RegisterDrivingLicenceCategoriesPredicate implements RegisterDrivingLicencePredicate {

    @Override
    public boolean test(RegisterDrivingLicenceDto registerDrivingLicenceDto) {
        return Optional.ofNullable(registerDrivingLicenceDto.getCategories())
                .filter(this::validate)
                .isPresent();
    }

    private boolean validate(Set<CategoryDto> categories) {
        return categories.stream()
                .allMatch(this::validate);
    }

    private boolean validate(CategoryDto category) {
        return Optional.of(category)
                .filter(cat -> nonNull(cat.getCategoryNumber()))
                .filter(this::validateDates)
                .isPresent();
    }

    private boolean validateDates(CategoryDto category) {
        return !Optional.of(category)
                .filter(cat -> nonNull(cat.getExpirationDate()))
                .filter(cat -> nonNull(cat.getReleaseDate()))
                .filter(cat -> cat.getReleaseDate().isAfter(cat.getExpirationDate()))
                .isPresent();

    }
}
