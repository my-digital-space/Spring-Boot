package com.jpa.ManyToMany.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    private String studentName;

    private String studentAddress;

    public Student(String studentName, String studentAddress) {
        this.studentName = studentName;
        this.studentAddress = studentAddress;
    }
}
