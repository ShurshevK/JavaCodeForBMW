package com.example.demo.domain;


import com.example.demo.domain.Group;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    @Column(
            name = "teacher_id"
    )
    private int teacherId;


    @OneToMany(mappedBy = "teacher")
    private List<Group> groups;

    public  String name;
    public String lastName;
    public String patronymic;


}
