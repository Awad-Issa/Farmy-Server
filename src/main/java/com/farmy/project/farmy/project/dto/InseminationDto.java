package com.farmy.project.farmy.project.dto;

import com.farmy.project.farmy.project.model.entity.Ewe;
import com.farmy.project.farmy.project.model.entity.enums.InseminationType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
@SuperBuilder
@NoArgsConstructor
@Data
public class InseminationDto {

    private Long id;

    private InseminationType type;

    private Date date;

    private Long ramId;

    private Long eweId;

}
