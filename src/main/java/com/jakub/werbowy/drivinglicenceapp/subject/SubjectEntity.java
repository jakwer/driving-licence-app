package com.jakub.werbowy.drivinglicenceapp.subject;

import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SUBJECT")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
class SubjectEntity {

    @Id
    private Long id;

    private String businessId;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @Enumerated(EnumType.STRING)
    private ExamResult examResult;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectEntity that = (SubjectEntity) o;
        return Objects.equal(businessId, that.businessId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(businessId);
    }
}
