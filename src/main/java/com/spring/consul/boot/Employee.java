package com.spring.consul.boot;

public class Employee {
    private String name;
    private String employeeId;


    public Employee(String name, String employeeId) {
        super();
        this.name = name;
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return employeeId;
    }

    public void setClassName(String className) {
        this.employeeId = className;
    }
}
