package com.taf.business.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DashboardDto {
    private long id;
    private String name;
    private String description;
    private String owner;
    private Boolean share;
    private List<WidgetsDto> widgets;
}
