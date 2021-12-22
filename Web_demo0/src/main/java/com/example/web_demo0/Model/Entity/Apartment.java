package com.example.web_demo0.Model.Entity;

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
    private int app_id;
    @ManyToOne
    @JoinColumn(name = "owner_username")
    private User owner;
    private String address;
    private String description;
    private Double price_per_month;
}
