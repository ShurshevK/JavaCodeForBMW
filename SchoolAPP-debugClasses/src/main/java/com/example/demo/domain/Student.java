package com.example.demo.domain;

import com.example.demo.SecurityConfig.domains.User;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "student_id"
    )
    private Long studentId;

    private String studentName;
    private String age;
    private String dob;
    private String phoneNumber;
    private String Email;


    @OneToOne(fetch = FetchType.LAZY, cascade = ALL)
    @JoinColumn(name="id")
    private User user;

    @ManyToMany(fetch = FetchType.LAZY, cascade = ALL, mappedBy = "students")
    public Set<Group> groups = new HashSet<>();

    @ManyToMany(mappedBy = "student")
    public Set<StudentLesson> studentLessons = new HashSet<>();

    public Student() {
    }

    public Student(Long studentId,
                   String name,
                   String age,
                   String dob,
                   String phoneNumber,
                   String email

                   ) {
        this.studentId = studentId;
        this.studentName = name;
        this.age = age;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.Email = email;

    }

    public Student(String name,
                   String age,
                   String dob,
                   String phoneNumber,
                   String email

                   ) {
        this.studentName = name;
        this.age = age;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.Email = email;

    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAge() {return age;}

    public void setAge(String age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }


    public Set<StudentLesson> getStudentLessons() {
        return studentLessons;
    }

    public void setStudentLessons(Set<StudentLesson> studentLessons) {
        this.studentLessons = studentLessons;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", Age=" + age +
                ", dob=" + dob +
                ", PhoneNumber=" + phoneNumber +
                ", Email='" + Email + '\'' +
                '}';
    }
}
