package com.projectBL.employeepayroll.dtoModel;

import com.projectBL.employeepayroll.model.EmployeePayRollModel;
import lombok.Data;

import java.util.List;


@Data
public class EmployeePayrollDto {
    private String name;
    private String salary;

    private String gender;
    private String profilePic;
    private List<String> department;
    private String startDate;
    private String notes;


    public EmployeePayrollDto(String name, String salary, String gender,
                              String profilePic, List<String> department,
                              String startDate, String notes) {
        this.name = name;
        this.salary = salary;

        this.gender = gender;
        this.profilePic = profilePic;
        this.department = department;
        this.startDate = startDate;
        this.notes = notes;

    }


    public EmployeePayrollDto(EmployeePayRollModel employee) {
        this.name= employee.getName();
        this.salary=employee.getSalary();
        this.gender=employee.getGender();
        this.profilePic=employee.getProfilePic();
        this.department=employee.getDepartment();
        this.startDate=employee.getStartDate();
        this.notes=employee.getNotes();



    }
}
