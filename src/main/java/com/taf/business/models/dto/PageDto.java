package com.taf.business.models.dto;

import lombok.Data;

@Data
public class PageDto {
    private double number;
    private double size;
    private String totalElements;
    private String totalPages;
}
