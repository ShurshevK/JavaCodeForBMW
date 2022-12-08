package com.example.demo.domain;


import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue()
    @Column(
            name = "status_id"
    )
    private Long statusId;
    public String statusName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "status")
    public Set<Lessons> lessons;

    public Status(Long statusId) {
        this.statusId = statusId;
    }
    public Status(String statusName) {
        this.statusName = statusName;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
