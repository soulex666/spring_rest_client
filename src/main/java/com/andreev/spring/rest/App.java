package com.andreev.spring.rest;

import com.andreev.spring.rest.configuration.MyConfig;
import com.andreev.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication", Communication.class);
        List<Employee> allEmployees = communication.getAllEmployees();
        allEmployees.forEach(System.out::println);

        System.out.println();
        System.out.println(communication.getEmployee(1));
        Employee employee = new Employee("Sveta", "Sokolova", "HR", 1900);
        employee.setId(9);
        employee.setDepartment("IT");
        communication.saveEmployee(employee);

        communication.deleteEmployee(9);
    }
}
