package com.example.payroll;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.payroll.model.EmployeeModel;

@RestController
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
   public List<EmployeeModel> all() {
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public EmployeeModel newEmployeeModel(@RequestBody EmployeeModel newEmployeeModel){
        return employeeRepository.save(newEmployeeModel);
    }

    


    @GetMapping("/employees/{id}")
    public EmployeeModel one(@PathVariable Long id) {
      
      return employeeRepository.findById(id)
        .orElseThrow(() -> new EmployeeNotFoundException(id));
    }
  
    @PutMapping("/employees/{id}")
    public EmployeeModel replaceEmployee(@RequestBody EmployeeModel newEmployee, @PathVariable Long id) {
      
      return employeeRepository.findById(id)
        .map(employee -> {
          employee.setName(newEmployee.getName());
          employee.setRole(newEmployee.getRole());
          return employeeRepository.save(employee);
        })
        .orElseGet(() -> {
          newEmployee.setId(id);
          return employeeRepository.save(newEmployee);
        });
    }

  @DeleteMapping("/employees/{id}")
  public void deleteEmployee(@PathVariable Long id) {
      employeeRepository.deleteById(id);
    }

}
