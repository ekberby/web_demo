package com.example.web_demo0.model.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "apartments")
public class Apartment {
    @Id
    @Column(name="app_id")
    private int appId;
    @ManyToOne
    @JoinColumn(name = "owner_username")
    private User owner;
    private String address;
    private String description;
    @Column(name = "price_per_month")
    private Double pricePerMonth;
}
