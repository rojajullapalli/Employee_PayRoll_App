package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Receive data Object
 *
 * @author roja julapalli
 * @version 0.0.1
 * @since 10-10-2021
 */
@Data
@Entity
@Table(name = "Employee")
public class EmployeePayRollData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_Id")
    private int empId;

    @Column(name = "name")
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> departments;

    public EmployeePayRollData(EmployeePayrollDto employeePayrollDto) {
        this.updateEmployeePayrollData(employeePayrollDto);
    }

    public EmployeePayRollData() {
    }

    public void updateEmployeePayrollData(EmployeePayrollDto employeePayrollDto) {
        this.name = employeePayrollDto.name;
        this.salary = employeePayrollDto.salary;
        this.gender = employeePayrollDto.gender;
        this.startDate = employeePayrollDto.startDate;
        this.note = employeePayrollDto.note;
        this.profilePic = employeePayrollDto.profilePic;
        this.departments = employeePayrollDto.department;
    }


}
