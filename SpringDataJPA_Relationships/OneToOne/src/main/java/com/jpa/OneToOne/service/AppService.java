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

        Passport passport1 = new Passport("WB12YP7954", 568);
        Passport passport2 = new Passport("UK1254LK45", 179);

        Employee employee1 = new Employee("John Doe",
                "Ed Media Pvt Ltd", passport1);
        Employee employee2 = new Employee("Lewis Stark",
                "Private Consultancy Services", passport2);

//        passportRepository.save(passport1);
//        passportRepository.save(passport2);
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);

        System.out.println("\n\n===   SaveData is done!   \n\n");
    }

    @Transactional
    public void fetchData() {
        // One Employee can have only one Passport

//        Employee employeeData = employeeRepository.findById(1).get();
//        System.out.println(employeeData);
//        System.out.println(employeeData.getPassport());

        Passport passportData = passportRepository.findById(100).get();
        System.out.println(passportData);
        System.out.println(passportData.getEmployee());

        System.out.println("\n\n===   FetchData is done!   \n\n");
    }

}
