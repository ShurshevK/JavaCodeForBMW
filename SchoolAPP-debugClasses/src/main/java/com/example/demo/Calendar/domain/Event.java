package com.example.demo.Calendar.domain;

import com.example.demo.domain.Course;
import com.example.demo.domain.Group;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Event {

    private @Id

    @GeneratedValue(strategy=GenerationType.IDENTITY,
    generator = "event_sequence")
    @Column(
            name = "event_id"
    )
    Long eventId;

    @OneToOne
    @JoinColumn(
            name = "group_id",
            referencedColumnName = "group_id"
    )
    private Group group;

    @ManyToMany(mappedBy = "assignedEvent")
    private Set<Group> groups = new HashSet<>();


    LocalDateTime start;

    LocalDateTime finish;

    String color;

    @OneToOne
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "course_id"
    )
    private Course course;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }
}
