package com.example.demo.domain;



import com.example.demo.Calendar.domain.Event;


import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;

import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @SequenceGenerator(
            name = "group_sequence",
            sequenceName = "group_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "group_sequence"
    )
    @Column(
            name = "group_id"
    )
    private Long groupId;

    public String groupName;



    @ManyToOne()
    @JoinColumn(
            name = "teacher",
            referencedColumnName = "teacher_id"
    )
    public Teacher teacher;

    @ManyToOne
    @JoinColumn(
            name = "language",
            referencedColumnName = "language_id"
    )
    public Language language;



    @ManyToOne
    @JoinColumn(
            name = "schedule",
            referencedColumnName = "schedule_id"
    )
    public Schedule schedule;

    // StudentsGroups
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "students_group",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    public Set<Student> students = new HashSet<>();




    @ManyToMany
    @JoinTable(
            name = "group_homework",
            joinColumns = @JoinColumn(name = "homework_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )

    private Set<HomeWork> assignedHomeWork = new HashSet<>();
    public Set<HomeWork> getAssigned(){
        return assignedHomeWork;
    }


    ////////////////////////////////////////////////////////////////////////
    //It was created to connect event and groups together, so that event could be assigned to groups//
    ////////////////////////////////////////////////////////////////////////


    @ManyToMany
    @JoinTable(
            name = "group_event",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )

    private Set<Event> assignedEvent = new HashSet<>();
    public Set<Event> getAssignedEvent(){
        return assignedEvent;
    }


    ////////////////////////////////////////////////////////////////////////
    //Connection with the Schedule//
    ////////////////////////////////////////////////////////////////////////

    @ManyToMany(mappedBy = "assignedGroups")
    private Set<ScheduleResponse> scheduleResponses = new HashSet<>();
    private Set<ScheduleResponse> getScheduleResponses(){
        return scheduleResponses;
    }

    public Group(Long groupId) {
        this.groupId = groupId;
    }

    public void assignedHomeWork(HomeWork homeWork) {
        assignedHomeWork.add(homeWork);
    }


    public Group(Long groupId, String groupName, Set<HomeWork> assignedHomeWork) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.assignedHomeWork = assignedHomeWork;

    }

    public Group(String groupName) {
        this.groupName = groupName;

    }

    public void assignedEvent(Event event) { assignedEvent.add(event);
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
