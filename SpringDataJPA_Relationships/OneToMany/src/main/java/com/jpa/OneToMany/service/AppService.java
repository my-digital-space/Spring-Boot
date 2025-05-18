package com.jpa.OneToMany.service;

import com.jpa.OneToMany.entity.Author;
import com.jpa.OneToMany.entity.Book;
import com.jpa.OneToMany.repository.AuthorRepository;
import com.jpa.OneToMany.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public void saveData() {
        // One Author can publish many Books

        Author author1 = new Author("John Doe", "Street No. 2, Nagar");
        Author author2 = new Author("Lewis Stark", "Park Road, Avenue");

        Book book1 = new Book("My First Book", "ISBN-2501-58974623");
        Book book2 = new Book("My Second Book", "ISBN-3001-58974769");

        authorRepository.save(author1);
        authorRepository.save(author2);
        bookRepository.save(book1);
        bookRepository.save(book2);
    }

}
