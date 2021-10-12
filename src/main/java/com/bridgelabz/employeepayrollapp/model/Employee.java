package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Receive data Object
 *
 * @author roja julapalli
 * @version 0.0.1
 * @since 10-10-2021
 */
@Data
@NoArgsConstructor
public class Employee {
    private int empId;
    private String name;
    private long salary;
    private String gender;
    private String startDate;
    private String note;
    private String profilePic;
    private List<String> departments;

    public Employee(int empId, EmployeePayrollDto employeePayrollDto) {
        this.empId = empId;
        this.name = employeePayrollDto.name;
        this.salary = employeePayrollDto.salary;
        this.gender = employeePayrollDto.gender;
        this.startDate = employeePayrollDto.startDate;
        this.note = employeePayrollDto.note;
        this.profilePic = employeePayrollDto.profilePic;
        this.departments = employeePayrollDto.department;
    }


}
