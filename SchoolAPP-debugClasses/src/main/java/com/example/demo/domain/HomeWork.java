package com.example.demo.domain;


import com.example.demo.domain.Group;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "homework")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "homework")
public class HomeWork {



    @Id
    @SequenceGenerator(
            name = "homework_sequence",
            sequenceName = "homework_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "homework_sequence"
    )
    @Column(
            name = "homework_id"
    )
    Long homeWorkId;
    public Date homeWorkDate;

    @ManyToMany(mappedBy = "assignedHomeWork")
    private Set<Group> group = new HashSet<>();


    private Set<Group> getGroup(){
        return group;
    }


    public String task;


}
