package com.farmy.project.farmy.project.dto;

import com.farmy.project.farmy.project.model.entity.Ewe;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
@NoArgsConstructor
@Data
public class PregnancyDto {

    private Long id;

    private Date startDate;

    private Date endDate;

    private Date expectedBirthDate;

    private Long spongeId;

    private Long hormoneId;

    private Long inseminationId;

    private Long eweId;
}
