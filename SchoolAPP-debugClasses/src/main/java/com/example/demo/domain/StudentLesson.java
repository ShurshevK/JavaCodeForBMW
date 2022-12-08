package com.example.demo.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "student_class")
public class StudentLesson {

    @Id
    @SequenceGenerator(
            name = "student_class_sequence",
            sequenceName = "student_class_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_class_sequence"
    )
    private int studentClassId;

    private String status;
    private String message;


    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "student_id"
    )
    private Student student;

    @ManyToOne
    @JoinColumn(
            name = "lesson_id",
            referencedColumnName = "lesson_id"
    )
    private Lessons lessons;



    public StudentLesson(int studentClassId,
                         String status,
                         String message,
                         Student student,
                         Lessons lessons) {
        this.studentClassId = studentClassId;
        this.status = status;
        this.message = message;

    }

    public StudentLesson(String status, String message, Student student, Lessons lessons) {
        this.status = status;
        this.message = message;
        this.student = student;
        this.lessons = lessons;
    }
}
