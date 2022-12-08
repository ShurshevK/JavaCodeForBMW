package com.example.demo.domain;


import com.example.demo.domain.Group;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "language")
public class Language {

    @Id
    @SequenceGenerator(
            name= "language_sequence",
            sequenceName = "language_sequence"
    )
    @GeneratedValue(
            generator = "language_sequence"
    )
    @Column(
            name= "language_id"
    )
    private Long languageId;
    public String name;

    @OneToMany(mappedBy = "language")
    private List<Group> groups;
}
