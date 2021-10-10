package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @GetMapping("/get")
    public ResponseEntity<String> getEmployeePayrollData(){
        return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeePayrollData(@PathVariable(value="empId") int empId){
        return  new ResponseEntity<>("Get Call Success For Id " +empId, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeePayrollDto employeePayrollDto){
        return new ResponseEntity<String>("Created Employee Payroll Data For "+employeePayrollDto, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeePayroll(@RequestBody EmployeePayrollDto employeePayrollDto){
        return new ResponseEntity<String>("Update Employee Payroll Data For "+employeePayrollDto, HttpStatus.OK );
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayroll(@PathVariable(value="empId") int empId){
        return new ResponseEntity<String>("Delete Call Success For Id "+empId, HttpStatus.OK);
    }
}