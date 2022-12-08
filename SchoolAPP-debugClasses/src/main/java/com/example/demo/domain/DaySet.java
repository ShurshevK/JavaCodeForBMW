package com.example.demo.domain;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "dayset")
@NoArgsConstructor
@AllArgsConstructor
public class DaySet {

    @Id
    @SequenceGenerator(
            name = "day_set_sequence",
            sequenceName = "day_set_sequence")
    @GeneratedValue(generator = "day_set_sequence")
    @Column(
            name = "dayset_id"
    )
    private Long DaySetId;

    @ManyToOne
    @JoinColumn(
            name = "schedule_id",
            referencedColumnName = "schedule_id"
    )
    private Schedule schedule;


    @ManyToOne
    @JoinColumn(
            name = "days_id",
            referencedColumnName = "days_id"
    )
    private Days days;


}
