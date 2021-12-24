package com.example.web_demo0.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="rents")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="rent_id")
    private int rentId;
    @ManyToOne
    @JoinColumn(name = "owner_username")
    private User owner;
    @OneToOne
    @JoinColumn(name = "renter_username")
    private User renter;
    @Column(name="end_month")
    private int endMonth;
    @Column(name="end_year")
    private int endYear;
    @Column(name="start_month")
    private int startMonth;
    @Column(name="start_year")
    private int startYear;
}
