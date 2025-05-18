package com.jpa.OneToOne.service;

import com.jpa.OneToOne.entity.Employee;
import com.jpa.OneToOne.entity.Passport;
import com.jpa.OneToOne.repository.EmployeeRepository;
import com.jpa.OneToOne.repository.PassportRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PassportRepository passportRepository;

    @Transactional
    public void saveData() {
        // One Employee can have only one Passport

        Employee employee1 = new Employee("John Doe", "Ed Media Pvt Ltd");
        Employee employee2 = new Employee("Lewis Stark", "Private Consultancy Services");

        Passport passport1 = new Passport("WB12YP7954", 568);
        Passport passport2 = new Passport("UK1254LK45", 179);

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        passportRepository.save(passport1);
        passportRepository.save(passport2);
    }

}
