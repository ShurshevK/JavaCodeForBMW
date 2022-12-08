package com.example.demo.domain;

import com.example.demo.domain.DaySet;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "days")

public class Days {

    @Id
    @SequenceGenerator(
            name = "days_sequence",
            sequenceName = "days_sequence"
    )
    @GeneratedValue(
            generator = "days_sequence"
    )
    @Column(
            name = "days_id"
    )

    private Long daysId;
    public String name;
    @OneToMany(mappedBy = "days")
    private List<DaySet> daySets;

    public Days(String name) {

        this.name = name;
    }

    public Days(Long daysId,
                String name) {
        this.daysId = daysId;
        this.name = name;
    }
}
