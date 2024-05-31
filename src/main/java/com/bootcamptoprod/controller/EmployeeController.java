package com.bootcamptoprod.controller;

import com.bootcamptoprod.request.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping("/employee")
    public Employee echoEmployeeDetails(HttpServletRequest request) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        // Reading request body for the first time
        Employee employee = objectMapper.readValue(request.getInputStream(), Employee.class);

        // Reading request body one more time
        Employee employee2 = objectMapper.readValue(request.getInputStream(), Employee.class);


        log.info("Employee object 1: {}", employee);
        log.info("Employee object 2: {}", employee2);

        return employee;
    }
}
