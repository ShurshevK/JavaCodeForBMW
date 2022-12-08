package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "lessons")

public class Lessons {

    @Id
    @SequenceGenerator(
            name = "lessons_sequence",
            sequenceName = "lessons_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "lessons_sequence"
    )
    @Column(
            name = "lesson_id",
            nullable = false
    )
    private int lessonId;



    public String date;

    @ManyToOne
    @JoinColumn(
            name = "status",
            referencedColumnName = "status_id"
    )
    private Status status;

    public String message;

    @OneToMany(
            mappedBy = "lessons"
    )
    private List<StudentLesson> studentLessons;

}
