package com.jpa.ManyToMany.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cs_seq")
    @SequenceGenerator(name = "cs_seq", sequenceName = "course_seq_from_100",
            allocationSize = 1, initialValue = 100)
    private int courseId;

    private String courseName;

    private String courseAuthor;

    public Course(String courseName, String courseAuthor) {
        this.courseName = courseName;
        this.courseAuthor = courseAuthor;
    }
}
