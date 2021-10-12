package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
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

    @NotNull
    @Pattern(regexp = "male|female", message="gender should be either male or female")
    public String gender;

    @NotNull
    @JsonFormat(pattern = "dd MMM yyyy")
    @PastOrPresent(message = "Date should be present date or past date")
    public LocalDate startDate;

    @NotBlank(message = "note should not be empty")
    public String note;

    @NotBlank(message = "profile pic should not be empty")
    public String profilePic;

    @NotNull
    public List<String> department;

}
