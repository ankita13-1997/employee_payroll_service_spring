package com.projectBL.employeepayroll.services;

import com.projectBL.employeepayroll.dtoModel.EditPayrollDto;
import com.projectBL.employeepayroll.dtoModel.EmployeePayrollDto;

import java.util.List;
import java.util.UUID;

public interface IPayrollServices {
    EmployeePayrollDto addUsers(EmployeePayrollDto employee);
    EmployeePayrollDto deleteUser(UUID employeeId);


    EmployeePayrollDto findUserById(UUID employeeId);

    List<EmployeePayrollDto> findAllUsers();

    EmployeePayrollDto updateUserDetails(EditPayrollDto user);
}
