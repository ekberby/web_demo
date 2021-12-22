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
    private String owner_username;
    private String renter_username;
    private int end_month;
    private int end_year;
    private int start_month;
    private int start_year;
}
