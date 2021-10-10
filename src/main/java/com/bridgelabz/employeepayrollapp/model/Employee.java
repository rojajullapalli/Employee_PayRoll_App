package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
@Data
@Entity
public class Employee {
    @Id
    private int empId;
    private String name;
    private long salary;

    public Employee(int empId, EmployeePayrollDto employeePayrollDto) {
        this.empId = empId;
        this.name = employeePayrollDto.getName();
        this.salary = employeePayrollDto.getSalary();
    }

    public Employee() {

    }
}
