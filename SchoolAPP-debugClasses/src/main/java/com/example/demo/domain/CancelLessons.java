package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "cancellesson")
public class CancelLessons {
    @Id
    @SequenceGenerator(
            name = "cancellesson",
            sequenceName = "cancelname"
    )
    @GeneratedValue(
            generator = "cancellesson"
    )
    @Column(
            name = "cancel_lesson_id"
    )
    private Long cancelLessonId;
    public String status;
    public String message;



}
