package com.jakub.werbowy.drivinglicenceapp.licence;

import com.jakub.werbowy.drivinglicenceapp.licence.dto.CategoryDto;

import java.util.Set;
import java.util.stream.Collectors;

class DrivingLicenceCategoryFactory {

    Set<DrivingLicenceCategoryEntity> createEntities(Set<CategoryDto> categories) {
        return categories.stream()
                .map(this::create)
                .collect(Collectors.toSet());
    }

    Set<CategoryDto> createDtos(Set<DrivingLicenceCategoryEntity> drivingLicenceCategories) {
        return drivingLicenceCategories.stream()
                .map(this::create)
                .collect(Collectors.toSet());
    }

    private DrivingLicenceCategoryEntity create(CategoryDto dto) {
        return DrivingLicenceCategoryEntity.builder()
                .expirationDate(dto.getExpirationDate())
                .number(dto.getCategoryNumber())
                .releaseDate(dto.getReleaseDate())
                .build();
    }

    private CategoryDto create(DrivingLicenceCategoryEntity entity) {
        return CategoryDto.builder()
                .categoryNumber(entity.getNumber())
                .expirationDate(entity.getExpirationDate())
                .releaseDate(entity.getReleaseDate())
                .build();
    }
}
