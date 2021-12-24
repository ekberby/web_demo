package com.example.web_demo0.model.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApartmentDto {
    private String ownerUsername;
    private String address;
    private String description;
    private Double pricePerMonth;
}
