package com.jakub.werbowy.drivinglicenceapp.licence.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CategoryDto {

    private final CategoryNumber categoryNumber;
    private final LocalDateTime releaseDate;
    private final LocalDateTime expirationDate;
}
