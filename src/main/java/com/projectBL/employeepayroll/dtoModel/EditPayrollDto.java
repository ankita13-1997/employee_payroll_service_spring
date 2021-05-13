package com.projectBL.employeepayroll.dtoModel;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class EditPayrollDto extends EmployeePayrollDto{

    private UUID employeeId;

    public EditPayrollDto(String name, String salary, String gender, String profilePic, List<String> department, String startDate, String notes) {
        super(name, salary, gender, profilePic, department, startDate, notes);
    }
}
