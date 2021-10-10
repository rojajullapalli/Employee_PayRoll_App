package com.bridgelabz.employeepayrollapp.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeePayrollService {

    public List<Employee> getEmployeePayrollData() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1,new EmployeePayrollDto("roja", 45000)));
        return employeeList;
    }

    public Employee getEmployeePayRollById(int empId) {
        Employee employee = null;
         employee = new Employee(1,new EmployeePayrollDto("roja", 40000));
         return employee;
    }

    public Employee addEmployee(EmployeePayrollDto employeePayrollDto) {
        Employee employee = null;
        employee = new Employee(1,employeePayrollDto);
        return employee;
    }

    public Employee UpdateEmployeePayroll(EmployeePayrollDto employeePayrollDto) {
        Employee employee = null;
        employee = new Employee(1,employeePayrollDto);
        return employee;
    }

    public void deleteEmployeePayroll(int empid){

    }
}
