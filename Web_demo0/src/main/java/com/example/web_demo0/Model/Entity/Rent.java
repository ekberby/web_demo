package com.example.web_demo0.Model.Entity;

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
    private int rent_id;
    @ManyToOne
    @JoinColumn(name = "owner_username")
    private User owner;
    @OneToOne
    @JoinColumn(name = "renter_username")
    private User renter;
    private int end_month;
    private int end_year;
    private int start_month;
    private int start_year;
}
