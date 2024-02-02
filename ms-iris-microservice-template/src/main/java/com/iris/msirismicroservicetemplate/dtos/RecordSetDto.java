package com.iris.msirismicroservicetemplate.dtos;

import lombok.Builder;
import lombok.Data;

@Data
public class RecordSetDto {
    private String name;
    private String gender;
    private String description;
}
