package com.bridgelabz.employeepayrollapp.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.model.Employee;

import java.util.List;

public interface IEmployeePayrollService {
    List<Employee> getEmployeePayrollData();

    Employee getEmployeePayRollById(int empId);

    Employee addEmployee(EmployeePayrollDto employeePayrollDto);

    Employee UpdateEmployeePayroll(int empId,EmployeePayrollDto employeePayrollDto);

    void deleteEmployeePayroll(int empid);
}
