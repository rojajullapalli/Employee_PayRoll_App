package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;
/**
 * creates and maintains employee payroll as object (DTO)
 *
 * @author roja julapalli
 * @version 0.0.1
 * @since 10-10-2021
 */
@Data
public class EmployeePayrollDto {
    private String name;
    private long salary;

    public EmployeePayrollDto(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }
}
