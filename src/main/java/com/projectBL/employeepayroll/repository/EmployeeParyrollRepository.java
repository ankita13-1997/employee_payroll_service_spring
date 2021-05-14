package com.projectBL.employeepayroll.repository;

import com.projectBL.employeepayroll.model.EmployeePayRollModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeParyrollRepository extends JpaRepository<EmployeePayRollModel, UUID> {

    Optional<EmployeePayRollModel> findByName(String name);
}
