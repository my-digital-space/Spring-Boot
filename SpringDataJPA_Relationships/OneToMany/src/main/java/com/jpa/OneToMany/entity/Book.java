package com.jpa.OneToMany.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bk_seq")
    @SequenceGenerator(name = "bk_seq", sequenceName = "book_seq_from_100",
            allocationSize = 1, initialValue = 100)
    private int bookId;

    private String bookName;

    private String bookNumber;

    public Book(String bookName, String bookNumber) {
        this.bookName = bookName;
        this.bookNumber = bookNumber;
    }
}
