package com.bridgelabz.employeepayrollapp.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.List;


/**
 * creates and maintains employee payroll as object (DTO)
 *
 * @author roja julapalli
 * @version 0.0.1
 * @since 10-10-2021
 */
@Data
@ToString
public class EmployeePayrollDto {

    @NotNull
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "name should contains atleast 2 characters\nfirst letter should be caps")
    public String name;

    @NotNull
    @Min(value = 600, message = "Salary must be greater than 600")
    @Max(value = 50000, message = "salary must be less than 50000")
    public long salary;

    public String gender;
    public String startDate;
    public String note;
    public String profilePic;
    public List<String> department;

}
