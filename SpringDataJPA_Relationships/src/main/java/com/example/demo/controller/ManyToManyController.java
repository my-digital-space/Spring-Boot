package com.example.demo.controller;

import com.example.demo.entities.Author;
import com.example.demo.entities.Course;
import com.example.demo.service.ManyToManyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ManyToManyController {
    @Autowired
    private ManyToManyService manyToManyService;

    // ------- Course Endpoints -------

    // Create a new course
    @PostMapping("/courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course createdCourse = manyToManyService.createCourse(course);
        return ResponseEntity.ok(createdCourse);
    }

    // Retrieve all courses
    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = manyToManyService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    // Retrieve a course by id
    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Optional<Course> course = manyToManyService.getCourseById(id);
        return course.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update an existing course
    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        Course updatedCourse = manyToManyService.updateCourse(id, course);
        if (updatedCourse != null) {
            return ResponseEntity.ok(updatedCourse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a course
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        manyToManyService.deleteCourse(id);
        return ResponseEntity.ok().build();
    }

    // ------- Author Endpoints -------

    // Create a new author
    @PostMapping("/authors")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        Author createdAuthor = manyToManyService.createAuthor(author);
        return ResponseEntity.ok(createdAuthor);
    }

    // Retrieve all authors
    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = manyToManyService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }

    // Retrieve an author by id
    @GetMapping("/authors/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        Optional<Author> author = manyToManyService.getAuthorById(id);
        return author.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update an existing author
    @PutMapping("/authors/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        Author updatedAuthor = manyToManyService.updateAuthor(id, author);
        if (updatedAuthor != null) {
            return ResponseEntity.ok(updatedAuthor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an author
    @DeleteMapping("/authors/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        manyToManyService.deleteAuthor(id);
        return ResponseEntity.ok().build();
    }
}
