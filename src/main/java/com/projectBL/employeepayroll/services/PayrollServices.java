package com.projectBL.employeepayroll.services;

import com.projectBL.employeepayroll.dtoModel.EditPayrollDto;
import com.projectBL.employeepayroll.dtoModel.EmployeePayrollDto;
import com.projectBL.employeepayroll.model.EmployeePayRollModel;
import com.projectBL.employeepayroll.repository.EmployeeParyrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PayrollServices implements IPayrollServices{

    @Autowired
    EmployeeParyrollRepository employeeParyrollRepository;


    @Override
    public EmployeePayrollDto addUsers(EmployeePayrollDto employee) {
        EmployeePayRollModel employeePayRollModel = new EmployeePayRollModel(employee.getName(),
                                                                             employee.getSalary(),
                                                                             employee.getGender(),
                                                                             employee.getProfilePic(),
                                                                             employee.getDepartment(),
                                                                             employee.getStartDate(),
                                                                             employee.getNotes());

            return new EmployeePayrollDto(employeeParyrollRepository.save(employeePayRollModel));


    }

    @Override
    public EmployeePayrollDto deleteUser(UUID employeeId) {
        Optional<EmployeePayRollModel> byId= employeeParyrollRepository.findById(employeeId);
        employeeParyrollRepository.deleteById(byId.get().getEmployeeId());
        return new EmployeePayrollDto(byId.get());
    }

    @Override
    public EmployeePayrollDto findUserById(UUID employeeId) {
        Optional<EmployeePayRollModel> byId=employeeParyrollRepository.findById(employeeId);
        return new EmployeePayrollDto(byId.get());
    }

    @Override
    public List<EmployeePayrollDto> findAllUsers() {

        return employeeParyrollRepository.findAll().
                stream().
                map(employeePayRollModel -> new EmployeePayrollDto(employeePayRollModel)).
                collect(Collectors.toList());
    }

    @Override
    public EmployeePayrollDto updateUserDetails(EditPayrollDto user) {
        Optional<EmployeePayRollModel> employeeDetails=employeeParyrollRepository.findById(user.getEmployeeId());
        employeeDetails.get().setEmployeeId(user.getEmployeeId());
        employeeDetails.get().setName(user.getName());
        employeeDetails.get().setSalary(user.getSalary());
        employeeDetails.get().setProfilePic(user.getProfilePic());
        employeeDetails.get().setDepartment(user.getDepartment());
        employeeDetails.get().setStartDate(user.getStartDate());
        employeeDetails.get().setNotes(user.getNotes());
        return new EmployeePayrollDto(employeeParyrollRepository.save(employeeDetails.get()));
    }


}
