package com.jakub.werbowy.drivinglicenceapp.licence;


import com.google.common.base.Objects;
import com.jakub.werbowy.drivinglicenceapp.licence.dto.CategoryNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "DRIVING_LICENCE_CATEGORY")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
class DrivingLicenceCategoryEntity {

    @Id
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CategoryNumber number;

    @NotNull
    private LocalDateTime releaseDate;

    @NotNull
    private LocalDateTime expirationDate;

    @ManyToOne
    @JoinColumn(name="driving_licence_id")
    private DrivingLicenceEntity drivingLicence;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrivingLicenceCategoryEntity that = (DrivingLicenceCategoryEntity) o;
        return number == that.number &&
                Objects.equal(releaseDate, that.releaseDate) &&
                Objects.equal(expirationDate, that.expirationDate) &&
                Objects.equal(drivingLicence, that.drivingLicence);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number, releaseDate, expirationDate, drivingLicence);
    }
}
