package com.farmy.project.farmy.project.dto;

import com.farmy.project.farmy.project.model.entity.Ewe;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
@NoArgsConstructor
@Data
public class SpongeDto {


    private Long id;

    private Long eweId;

    private String type;

    private Date startDate;

    private Date endDate;
}
