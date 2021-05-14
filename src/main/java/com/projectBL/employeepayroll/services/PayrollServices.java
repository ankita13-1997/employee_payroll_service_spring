package com.projectBL.employeepayroll.services;

import com.projectBL.employeepayroll.Exception.PayrollException;
import com.projectBL.employeepayroll.dtoModel.EditPayrollDto;
import com.projectBL.employeepayroll.dtoModel.EmployeePayrollDto;
import com.projectBL.employeepayroll.model.EmployeePayRollModel;
import com.projectBL.employeepayroll.repository.EmployeeParyrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PayrollServices implements IPayrollServices{

    @Autowired
    EmployeeParyrollRepository employeeParyrollRepository;


    @Override
    public EmployeePayrollDto addUsers(EmployeePayrollDto employee) {
        Optional<EmployeePayRollModel> byName=employeeParyrollRepository.findByName(employee.getName());
        if (byName.isPresent()){
            throw new PayrollException(PayrollException.ExceptionTypes.EMPLOYEE_ALREADY_PRESENT);
        }

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
    public EmployeePayRollModel addUsersModel(EmployeePayrollDto employee) {

        Optional<EmployeePayRollModel> byName=employeeParyrollRepository.findByName(employee.getName());
        if (byName.isPresent()){
            throw new PayrollException(PayrollException.ExceptionTypes.EMPLOYEE_ALREADY_PRESENT);
        }

        EmployeePayRollModel employeePayRollModel = new EmployeePayRollModel(employee.getName(),
                employee.getSalary(),
                employee.getGender(),
                employee.getProfilePic(),
                employee.getDepartment(),
                employee.getStartDate(),
                employee.getNotes());

        return new EmployeePayRollModel(employeeParyrollRepository.save(employeePayRollModel));
    }

    @Override
    public EmployeePayrollDto deleteUser(UUID employeeId) {
        Optional<EmployeePayRollModel> byId= employeeParyrollRepository.findById(employeeId);
        if (!byId.isPresent()){
            throw new PayrollException(PayrollException.ExceptionTypes.EMPLOYEE_NOT_FOUND);
        }
        employeeParyrollRepository.deleteById(byId.get().getEmployeeId());
        return new EmployeePayrollDto(byId.get());
    }

    @Override
    public EmployeePayRollModel deleteUserModel(UUID employeeId) {
        Optional<EmployeePayRollModel> byId= employeeParyrollRepository.findById(employeeId);
        if (!byId.isPresent()){
            throw new PayrollException(PayrollException.ExceptionTypes.EMPLOYEE_NOT_FOUND);
        }
        employeeParyrollRepository.deleteById(byId.get().getEmployeeId());
        return new EmployeePayRollModel(byId.get());
    }

    @Override
    public EmployeePayrollDto findUserById(UUID employeeId) {
        Optional<EmployeePayRollModel> byId=employeeParyrollRepository.findById(employeeId);
        if (!byId.isPresent()){

                throw new PayrollException(PayrollException.ExceptionTypes.EMPLOYEE_NOT_FOUND);
        }
        return new EmployeePayrollDto(byId.get());
    }

    @Override
    public EmployeePayRollModel findUserByIdModel(UUID employeeId) {
        Optional<EmployeePayRollModel> byId=employeeParyrollRepository.findById(employeeId);
        if (!byId.isPresent()){
              throw new PayrollException(PayrollException.ExceptionTypes.EMPLOYEE_NOT_FOUND);
            }

        return new EmployeePayRollModel(byId.get());
    }


    @Override
    public List<EmployeePayrollDto> findAllUsers() {

        return employeeParyrollRepository.findAll().
                stream().
                map(employeePayRollModel -> new EmployeePayrollDto(employeePayRollModel)).
                collect(Collectors.toList());
    }

    @Override
    public List<EmployeePayRollModel> findAllUsersModel() {
        return employeeParyrollRepository.findAll().
                stream().
                map(employeePayRollModel -> new EmployeePayRollModel(employeePayRollModel)).
                collect(Collectors.toList());

    }

    @Override
    public EmployeePayrollDto updateUserDetails(EditPayrollDto user) {


        Optional<EmployeePayRollModel> employeeDetails=employeeParyrollRepository.findById(user.getEmployeeId());

        if (!employeeDetails.isPresent()){
            throw new PayrollException(PayrollException.ExceptionTypes.EMPLOYEE_NOT_PRESENT);
        }
        employeeDetails.get().setEmployeeId(user.getEmployeeId());
        employeeDetails.get().setName(user.getName());
        employeeDetails.get().setSalary(user.getSalary());
        employeeDetails.get().setGender(user.getGender());
        employeeDetails.get().setProfilePic(user.getProfilePic());
        employeeDetails.get().setDepartment(user.getDepartment());
        employeeDetails.get().setStartDate(user.getStartDate());
        employeeDetails.get().setNotes(user.getNotes());
        employeeDetails.get().setUpdatedAt(LocalDateTime.now());
        return new EmployeePayrollDto(employeeParyrollRepository.save(employeeDetails.get()));
    }

    @Override
    public EmployeePayRollModel updateUserDetailsModel(EditPayrollDto user) {
        Optional<EmployeePayRollModel> employeeDetails=employeeParyrollRepository.findById(user.getEmployeeId());

        if (!employeeDetails.isPresent()){
            throw new PayrollException(PayrollException.ExceptionTypes.EMPLOYEE_NOT_PRESENT);
        }
        employeeDetails.get().setEmployeeId(user.getEmployeeId());
        employeeDetails.get().setName(user.getName());
        employeeDetails.get().setSalary(user.getSalary());
        employeeDetails.get().setGender(user.getGender());
        employeeDetails.get().setProfilePic(user.getProfilePic());
        employeeDetails.get().setDepartment(user.getDepartment());
        employeeDetails.get().setStartDate(user.getStartDate());
        employeeDetails.get().setNotes(user.getNotes());
        employeeDetails.get().setUpdatedAt(LocalDateTime.now());
        return new EmployeePayRollModel(employeeParyrollRepository.save(employeeDetails.get()));
    }


}
