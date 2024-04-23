package com.example.payroll.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.payroll.employee.model.EmployeeModel;

    /**
     * InnerEmployeeRepository extends JpaRepository
     */
   public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {
        
    }
    

