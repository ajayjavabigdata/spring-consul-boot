package com.spring.consul.boot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeServiceController {

    private static Map<String, List<Employee>> employeeDb = new HashMap<String, List<Employee>>();

    static {
        employeeDb = new HashMap<String, List<Employee>>();

        List<Employee> lst = new ArrayList<Employee>();
        Employee std = new Employee("Ajay", "XYZAB");
        lst.add(std);
        std = new Employee("Rahgu", "XYZCD");
        lst.add(std);

        employeeDb.put("testProject", lst);

        lst = new ArrayList<Employee>();
        std = new Employee("Denny", "XYZEF");
        lst.add(std);
        std = new Employee("Rama", "XYZGH");
        lst.add(std);

        employeeDb.put("testProject", lst);

    }

    @RequestMapping(value = "/getEmployeeDetails/{employeeId}", method = RequestMethod.GET)
    public List<Employee> getStudents(@PathVariable String employeeId) {
        System.out.println("Getting Student details for " + employeeId);

        List<Employee> studentList = employeeDb.get(employeeId);
        if (studentList == null) {
            studentList = new ArrayList<Employee>();
            Employee std = new Employee("Not Found", "N/A");
            studentList.add(std);
        }
        return studentList;
    }
}
