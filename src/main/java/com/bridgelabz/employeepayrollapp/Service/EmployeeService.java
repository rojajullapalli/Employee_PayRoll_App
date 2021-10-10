package com.bridgelabz.employeepayrollapp.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeePayrollService {
    private List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getEmployeePayrollData() {
        return employeeList;
    }

    public Employee getEmployeePayRollById(int empId) {
         return employeeList.get(empId-1);
    }

    public Employee addEmployee(EmployeePayrollDto employeePayrollDto) {
        Employee employee = null;
        employee = new Employee(employeeList.size()+1,employeePayrollDto);
        employeeList.add(employee);
        return employee;
    }

    public Employee UpdateEmployeePayroll(int empId, EmployeePayrollDto employeePayrollDto) {
        Employee employee = this.getEmployeePayRollById(empId);
       employee.setName(employeePayrollDto.getName());
       employee.setSalary(employeePayrollDto.getSalary());
       employeeList.set(empId-1,employee);
       return employee;
    }

    public void deleteEmployeePayroll(int empid){
        employeeList.remove(empid-1);
    }
}
