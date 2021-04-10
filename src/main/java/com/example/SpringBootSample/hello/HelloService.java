package com.example.SpringBootSample.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Autowired
    private HelloRepository repository;

    public Employee getEmployee(String id) {
        var map = repository.findById(id);

        var employee = new Employee();
        employee.setEmployeeId((String) map.get("id"));
        employee.setEmployeeName((String) map.get("name"));
        employee.setEmployeeAge((Integer) map.get("age"));

        return employee;
    }

}

