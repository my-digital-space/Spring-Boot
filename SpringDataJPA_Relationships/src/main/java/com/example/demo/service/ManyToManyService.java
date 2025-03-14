package com.example.demo.service;

import com.example.demo.entities.Author;
import com.example.demo.entities.Course;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ManyToManyService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private AuthorRepository authorRepository;

    // -------- Course CRUD Operations --------

    // Create a new course (along with its authors if provided)
    public Course createCourse(Course course) {
        // Idempotency check using existsByName to avoid loading the full entity.
        if (courseRepository.existsByName(course.getName())) {
            throw new RuntimeException("Course already exists");
        }

        // Clone the incoming authors and clear the course's authors to avoid modifying the persistent collection.
        Set<Author> incomingAuthors = course.getAuthors() != null
                ? new HashSet<>(course.getAuthors())
                : new HashSet<>();
        course.setAuthors(new HashSet<>());

        Set<Author> attachedAuthors = new HashSet<>();
        for (Author author : incomingAuthors) {
            Author attachedAuthor;
            if (author.getId() != null) {
                // Try to find an existing author by ID.
                Optional<Author> existingAuthor = authorRepository.findById(author.getId());
                if (existingAuthor.isPresent()) {
                    System.out.println("Author with id " + author.getId() + " already exists. Ignoring creation.");
                    attachedAuthor = existingAuthor.get();
                } else {
                    // Not found by ID, create new.
                    attachedAuthor = authorRepository.save(author);
                }
            } else {
                // No ID provided: check by name.
                Optional<Author> existingAuthor = authorRepository.findByName(author.getName());
                if (existingAuthor.isPresent()) {
                    System.out.println("Author with name " + author.getName() + " already exists. Ignoring creation.");
                    attachedAuthor = existingAuthor.get();
                } else {
                    attachedAuthor = authorRepository.save(author);
                }
            }
            attachedAuthors.add(attachedAuthor);
        }

        // Assign the processed authors to the course and save.
        course.setAuthors(attachedAuthors);
        return courseRepository.save(course);
    }

    // Retrieve all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Retrieve a course by id
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    // Update course details
    @Transactional
    public Course updateCourse(Long id, Course updatedCourse) {
        return courseRepository.findById(id).map(course -> {
            course.setName(updatedCourse.getName());
            course.getAuthors().clear();
            updatedCourse.getAuthors().forEach(author -> {
                // If author exists in DB, use it; otherwise, persist new author.
                Author existingAuthor = (author.getId() != null)
                        ? authorRepository.findById(author.getId()).orElse(author)
                        : author;
                course.addAuthor(existingAuthor);
            });
            return courseRepository.save(course);
        }).orElse(null);
    }

    // Delete a course by id
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    // -------- Author CRUD Operations --------

    // Create a new author
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    // Retrieve all authors
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // Retrieve an author by id
    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    // Update author details
    public Author updateAuthor(Long id, Author updatedAuthor) {
        return authorRepository.findById(id).map(author -> {
            author.setName(updatedAuthor.getName());
            return authorRepository.save(author);
        }).orElse(null);
    }

    // Delete an author by id
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
