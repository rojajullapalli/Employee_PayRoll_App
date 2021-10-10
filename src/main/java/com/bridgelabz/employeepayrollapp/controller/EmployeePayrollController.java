package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.Service.EmployeeService;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.dto.ResponseDto;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get")
    public ResponseEntity<ResponseDto> getEmployeePayrollData(){
        List<Employee> employee = null;
        employee = employeeService.getEmployeePayrollData();
        ResponseDto responseDto = new ResponseDto("Get Call Success", employee);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDto> getEmployeePayrollDataById(@PathVariable(value="empId") int empId){
        Employee employee = null;
        employee = employeeService.getEmployeePayRollById(empId);
        ResponseDto responseDto = new ResponseDto("Get Call Success For Id", employee);
        return  new ResponseEntity<ResponseDto>( responseDto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> addEmployeePayrollData(@RequestBody EmployeePayrollDto employeePayrollDto){
        Employee employee = null;
        employee = employeeService.addEmployee(employeePayrollDto);
        ResponseDto responseDto = new ResponseDto("Created Employee Payroll Data For ", employee);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDto> updateEmployeePayroll(@PathVariable(value="empId") int empId,@RequestBody EmployeePayrollDto employeePayrollDto){
        Employee employee = null;
        employee = employeeService.UpdateEmployeePayroll(empId,employeePayrollDto);
        ResponseDto responseDto = new ResponseDto("Update Employee Payroll Data For ", employee);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK );
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDto> deleteEmployeePayroll(@PathVariable(value="empId") int empId){
        employeeService.deleteEmployeePayroll(empId);
        ResponseDto responseDto = new ResponseDto("Deleted Successfully","deleted id: "+empId);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
}
