package com.bridgelabz.employeepayrollapp.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.exception.CustomException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
public class EmployeeService implements IEmployeePayrollService {
    private final List<Employee> employeeList = new ArrayList<>();
    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    public List<Employee> getEmployeePayrollData() {
        return employeeList;
    }

    public Employee getEmployeePayRollById(int empId) {
        return employeeList.stream().filter(id -> id.getEmpId() == empId).findFirst().orElseThrow(() -> new CustomException("Employee id not found"));
    }

    public Employee addEmployee(EmployeePayrollDto employeePayrollDto) {
        Employee employee = null;
        employee = new Employee(employeePayrollDto);
        log.debug("Emp Data" + employee);
        employeeList.add(employee);
        return employeePayrollRepository.save(employee);
    }

    public Employee UpdateEmployeePayroll(int empId, EmployeePayrollDto employeePayrollDto) {
        Employee employee = this.getEmployeePayRollById(empId);
        employee.setName(employeePayrollDto.getName());
        employee.setSalary(employeePayrollDto.getSalary());
        employeeList.set(empId - 1, employee);
        return employee;
    }

    public void deleteEmployeePayroll(int empId) {
        employeeList.stream().filter(id -> id.getEmpId() == empId).findFirst().orElseThrow(() -> new CustomException("Employee id not found"));
        employeeList.remove(empId - 1);
    }
}
