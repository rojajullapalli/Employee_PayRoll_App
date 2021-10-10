package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.dto.ResponseDto;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @GetMapping("/get")
    public ResponseEntity<ResponseDto> getEmployeePayrollData(){
        Employee employee = null;
        employee = new Employee(1,new EmployeePayrollDto("roja",450000));
        ResponseDto responseDto = new ResponseDto("Get Call Success", employee);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDto> getEmployeePayrollData(@PathVariable(value="empId") int empId){
        Employee employee = null;
        employee = new Employee(1,new EmployeePayrollDto("roja",450000));
        ResponseDto responseDto = new ResponseDto("Get Call Success For Id", employee);
        return  new ResponseEntity<ResponseDto>( responseDto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> addEmployeePayrollData(@RequestBody EmployeePayrollDto employeePayrollDto){
        Employee employee = null;
        employee = new Employee(1,employeePayrollDto);
        ResponseDto responseDto = new ResponseDto("Created Employee Payroll Data For ", employee);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateEmployeePayroll(@RequestBody EmployeePayrollDto employeePayrollDto){
        Employee employee = null;
        employee = new Employee(1,employeePayrollDto);
        ResponseDto responseDto = new ResponseDto("Update Employee Payroll Data For ", employee);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK );
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDto> deleteEmployeePayroll(@PathVariable(value="empId") int empId){
        ResponseDto responseDto = new ResponseDto("Deleted Successfully","deleted id: "+empId);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
}
