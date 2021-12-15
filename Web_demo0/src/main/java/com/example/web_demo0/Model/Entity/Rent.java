package com.example.web_demo0.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="rents")
public class Rent {
    @Id
    private int app_id;
    private int renter_id;
    private int end_month;
    private int end_year;
    private int start_month;
    private int start_year;
}
