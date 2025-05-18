package com.jpa.OneToMany.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    private String authorName;

    private String authorAddress;

    public Author(String authorName, String authorAddress) {
        this.authorName = authorName;
        this.authorAddress = authorAddress;
    }
}
