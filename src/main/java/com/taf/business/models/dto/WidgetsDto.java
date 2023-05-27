package com.taf.business.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WidgetsDto {
    private double widgetId;
    private String widgetName;
}
