package com.jakub.werbowy.drivinglicenceapp.licence;

import com.google.common.base.Objects;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "DRIVING_LICENCE")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
class DrivingLicenceEntity {

    @Id
    @With
    private Long id;

    private String businessId;

    @NotNull
    private String issuingAuthority;

    @NotNull
    private String number;

    @NotNull
    private String subjectId;

    @OneToMany(mappedBy = "drivingLicence")
    private Set<DrivingLicenceCategoryEntity> drivingLicenceCategories;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrivingLicenceEntity that = (DrivingLicenceEntity) o;
        return Objects.equal(businessId, that.businessId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(businessId);
    }
}
