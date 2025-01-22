package com.farmy.project.farmy.project.dto;

import com.farmy.project.farmy.project.model.entity.Ewe;
import com.farmy.project.farmy.project.model.entity.Lamb;
import com.farmy.project.farmy.project.model.entity.Pregnancy;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@SuperBuilder
@NoArgsConstructor
@Data
public class BirthDto {

    @NotNull
    private Long eweId;

    private List<LambDto> lambs;

    private Date date;

    private Long pregnancyId;

}
