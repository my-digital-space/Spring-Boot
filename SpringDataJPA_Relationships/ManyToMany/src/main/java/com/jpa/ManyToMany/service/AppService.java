package com.jpa.ManyToMany.service;

import com.jpa.ManyToMany.entity.Course;
import com.jpa.ManyToMany.entity.Student;
import com.jpa.ManyToMany.repository.CourseRepository;
import com.jpa.ManyToMany.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    public void saveData() {
        // One Student can enroll to many Course(s)
        // Also, One Course can be enrolled by many Student(s)

        Student student1 = new Student("John Doe", "Street No. 2, Nagar");
        Student student2 = new Student("Lewis Stark", "Park Road, Avenue");

        Course course1 = new Course("My First Course", "Author 1");
        Course course2 = new Course("My Second Course", "Author 2");

        studentRepository.save(student1);
        studentRepository.save(student2);
        courseRepository.save(course1);
        courseRepository.save(course2);
    }

}
