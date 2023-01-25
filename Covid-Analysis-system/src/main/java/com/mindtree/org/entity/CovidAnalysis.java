package com.mindtree.org.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data //hashCode() and equals()
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "covid_data")
public class CovidAnalysis implements Comparable <CovidAnalysis> {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "state")
    private String state;

    @Column(name = "district")
    private String district;

    @Column(name = "tested")
    private int tested;

    @Column(name = "confirmed")
    private int confirmed;

    @Column(name = "recovered")
    private int recovered;

    @Override
    public int compareTo(CovidAnalysis o) {
        if (getId()>o.getId())
            return 1;
        else
            if (getId()<o.getId())
                return -1;
        else
            return 0;
    }
}
