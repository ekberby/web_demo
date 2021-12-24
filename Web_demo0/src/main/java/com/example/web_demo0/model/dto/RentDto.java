package com.example.web_demo0.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentDto {
    private String ownerUsername;
    private String renterUsername;
    private int endMonth;
    private int endYear;
    private int startMonth;
    private int startYear;
}
