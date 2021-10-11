package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * Receive data Object
 *
 * @author roja julapalli
 * @version 0.0.1
 * @since 10-10-2021
 */
@Data
@Entity
@NoArgsConstructor
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


}
