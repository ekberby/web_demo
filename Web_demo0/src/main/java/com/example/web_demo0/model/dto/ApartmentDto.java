package com.example.web_demo0.model.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApartmentDto {
    private String owner_username;
    private String address;
    private String description;
    private Double price_per_month;
}
