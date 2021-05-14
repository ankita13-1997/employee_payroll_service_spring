package com.projectBL.employeepayroll.services;

import com.projectBL.employeepayroll.dtoModel.EditPayrollDto;
import com.projectBL.employeepayroll.dtoModel.EmployeePayrollDto;
import com.projectBL.employeepayroll.model.EmployeePayRollModel;

import java.util.List;
import java.util.UUID;

public interface IPayrollServices {
    EmployeePayrollDto addUsers(EmployeePayrollDto employee);
    EmployeePayRollModel addUsersModel(EmployeePayrollDto employee);

    EmployeePayrollDto deleteUser(UUID employeeId);
    EmployeePayRollModel deleteUserModel(UUID employeeId);


    EmployeePayrollDto findUserById(UUID employeeId);
    EmployeePayRollModel findUserByIdModel(UUID employeeId);

    List<EmployeePayrollDto> findAllUsers();
    List<EmployeePayRollModel> findAllUsersModel();

    EmployeePayrollDto updateUserDetails(EditPayrollDto user);
    EmployeePayRollModel updateUserDetailsModel(EditPayrollDto user);
}
