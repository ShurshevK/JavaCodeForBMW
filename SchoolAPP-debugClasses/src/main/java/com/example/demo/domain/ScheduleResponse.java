package com.example.demo.domain;




import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor

public class ScheduleResponse {

    @Id
    @SequenceGenerator(
            name = "sr_sequence",
            sequenceName = "sr_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sr_sequence"
    )
    @Column(
            name = "schedule_response_id"
    )
    private Long scheduleResponseId;
    public String status;
    public String title;
    public String message;
    public String date;
    public String duration;

    @OneToOne
    @JoinColumn(
            referencedColumnName = "days_id"
    )
    public Days days;


    @ManyToMany
    @JoinTable(
            name = "schedule_group",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "schedule_id")
    )

    private Set<Group> assignedGroups = new HashSet<>();

    public Set<Group> getAssignedGroups(){
        return assignedGroups;
    }


    @ManyToMany
    @JoinTable(
            name = "schedule_course",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "schedule_id")
    )

    private Set<Course> Courses = new HashSet<>();

    public Set<Course> getCourses(){
        return Courses;
    }


    public void assignedGroups(Group groups) {
        assignedGroups.add(groups);

    }
    public void assignedCourses(Course course) {
        Courses.add(course);

    }

    // DateTimeFormatter inBuiltFormatter1 = DateTimeFormatter.ISO_DATE_TIME;


    public ScheduleResponse(Long scheduleResponseId, String status, String title, String message, String date, String duration) {
        this.scheduleResponseId = scheduleResponseId;
        this.status = status;
        this.title = title;
        this.message = message;
        this.date = date;
        this.duration = duration;
    }

    public Long getScheduleResponseId() {
        return scheduleResponseId;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }

    public String getDuration() {
        return duration;
    }





}
