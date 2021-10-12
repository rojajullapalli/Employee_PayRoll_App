package com.bridgelabz.employeepayrollapp.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.exception.CustomException;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * class implements all the methods of business logic from interface
 *
 * @author roja julapalli
 * @version 0.0.1
 * @since 10-10-2021
 */
@Service
public class EmployeeService implements IEmployeePayrollService {
    private final List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getEmployeePayrollData() {
        return employeeList;
    }

    public Employee getEmployeePayRollById(int empId) {
        return employeeList.stream().filter(id->id.getEmpId() == empId).findFirst().orElseThrow(()->new CustomException("Employee id not found"));
    }

    public Employee addEmployee(EmployeePayrollDto employeePayrollDto) {
        Employee employee = null;
        employee = new Employee(employeeList.size() + 1, employeePayrollDto);
        employeeList.add(employee);
        return employee;
    }

    public Employee UpdateEmployeePayroll(int empId, EmployeePayrollDto employeePayrollDto) {
        Employee employee = this.getEmployeePayRollById(empId);
        employee.setName(employeePayrollDto.getName());
        employee.setSalary(employeePayrollDto.getSalary());
        employeeList.set(empId - 1, employee);
        return employee;
    }

    public void deleteEmployeePayroll(int empId) {
        employeeList.stream().filter(id->id.getEmpId() == empId).findFirst().orElseThrow(()->new CustomException("Employee id not found"));
        employeeList.remove(empId-1);
    }
}
