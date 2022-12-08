package com.example.demo.domain;


import com.example.demo.domain.DaySet;
import com.example.demo.domain.Group;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @SequenceGenerator(
            name = "schedule_sequence",
            sequenceName = "schedule_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "schedule_sequence"
    )
    @Column(
            name = "schedule_id"
    )
    private Long scheduleId;
    int numberOfLessonPerWeek;



    @ManyToOne
    @JoinColumn(
            name = "dayset",
            referencedColumnName = "dayset_id"
    )
    private DaySet daySet;

    @OneToMany(mappedBy = "schedule")
    private List<Group> groups;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schedule")
    private List<DaySet> daySets;

    public Schedule(Long scheduleId,
                    int numberOfLessonPerWeek) {
        this.scheduleId = scheduleId;
        this.numberOfLessonPerWeek = numberOfLessonPerWeek;
    }




    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getNumberOfLessonPerWeek() {
        return numberOfLessonPerWeek;
    }

    public void setNumberOfLessonPerWeek(int numberOfLessonPerWeek) {
        this.numberOfLessonPerWeek = numberOfLessonPerWeek;
    }
}
