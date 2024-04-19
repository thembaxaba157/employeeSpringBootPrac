package com.example.payroll;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.payroll.model.EmployeeModel;

    /**
     * InnerEmployeeRepository extends JpaRepository
     */
   public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {
        
    }
    

