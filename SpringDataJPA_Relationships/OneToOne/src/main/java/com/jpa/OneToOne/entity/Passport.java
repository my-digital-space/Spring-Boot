package com.jpa.OneToOne.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "passport")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pass_seq")
    @SequenceGenerator(name = "pass_seq", sequenceName = "passport_seq_from_100",
            allocationSize = 1, initialValue = 100)
    private int passportId;

    private String passportNumber;

    private int fileNumber;

    public Passport(String passportNumber, int fileNumber) {
        this.passportNumber = passportNumber;
        this.fileNumber = fileNumber;
    }
}
