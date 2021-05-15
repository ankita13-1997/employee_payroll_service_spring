package com.projectBL.employeepayroll.dtoModel;

import com.projectBL.employeepayroll.model.EmployeePayRollModel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;


@Data
public class EmployeePayrollDto {

    @Pattern(regexp = "[A-Z]{1}[a-z]{3,20}$",message = "Please Do Enter Valid name!")
    @NotNull(message = "Please Do Enter valid name!")
    @NotEmpty(message = "Please Enter Valid name!")
    private String name;

    @Pattern(regexp = "[0-9]+([,.][0-9]{1,2})",message = "please enter valid salary")
    @NotNull(message = "Please Do Enter valid salary amount!")
    @NotEmpty(message = "Please Enter salary amount")
    private String salary;

    @NotNull(message = "Please Enter gender")
    @NotEmpty(message = "Please Enter gender")
    private String gender;

    private String profilePic;

    @NotNull(message = "Please Enter department")
    @NotEmpty(message = "Please Enter department")
    private List<String> department;

    @NotNull(message = "Please Enter start date")
    @NotEmpty(message = "Please Enter start date")
    private String startDate;

    @NotNull(message = "Please Enter duty notes")
    @NotEmpty(message = "Please Enter duty notes")
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
