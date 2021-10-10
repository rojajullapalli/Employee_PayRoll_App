package com.bridgelabz.employeepayrollapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
@Data
@Entity
public class Employee {
    @Id
    private int empId;
    private String name;
    private int salary;

}
