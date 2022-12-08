package com.example.demo.domain;

import com.example.demo.Calendar.domain.Event;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "course")
@Table(name="course")

public class Course
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(
            name = "course_id"
    )
    private Long courseId;
    public String courseName;
    public int duration;
    public String language;

    LocalDateTime start;

    LocalDateTime finish;

    @OneToOne(mappedBy = "course")
    @JoinColumn(
            name = "event",
            referencedColumnName = "course_id"
    )
    private Event event;

    ////////////////////////////////////////////////////////////////////////
    //Connection with the Course//
    ////////////////////////////////////////////////////////////////////////

    @ManyToMany(mappedBy = "Courses")
    private Set<ScheduleResponse> scheduleResponses = new HashSet<>();
    private Set<ScheduleResponse> getScheduleResponses(){
        return scheduleResponses;
    }


    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getFinish() {
        return finish;
    }

    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }
}