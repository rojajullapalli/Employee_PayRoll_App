package com.bridgelabz.employeepayrollapp.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.exception.CustomException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayRollData;
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
    private final List<EmployeePayRollData> employeePayRollDataList = new ArrayList<>();
    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    public List<EmployeePayRollData> getEmployeePayrollData() {
        return employeePayrollRepository.findAll();
    }

    public EmployeePayRollData getEmployeePayRollById(int empId) {
        return employeePayrollRepository.findById(empId).orElseThrow(()-> new CustomException("Employee with employeeId "+empId+" does not exists...!"));
    }

    public EmployeePayRollData addEmployee(EmployeePayrollDto employeePayrollDto) {
        EmployeePayRollData employeePayRollData = null;
        employeePayRollData = new EmployeePayRollData(employeePayrollDto);
        log.debug("Emp Data" + employeePayRollData);
        employeePayRollDataList.add(employeePayRollData);
        return employeePayrollRepository.save(employeePayRollData);
    }

    public EmployeePayRollData UpdateEmployeePayroll(int empId, EmployeePayrollDto employeePayrollDto) {
        EmployeePayRollData employeePayRollData = this.getEmployeePayRollById(empId);
        employeePayRollData.updateEmployeePayrollData(employeePayrollDto);
        return employeePayrollRepository.save(employeePayRollData);
    }

    public void deleteEmployeePayroll(int empId) {
        EmployeePayRollData employeePayRollData = this.getEmployeePayRollById(empId);
        employeePayrollRepository.delete(employeePayRollData);
    }
}
