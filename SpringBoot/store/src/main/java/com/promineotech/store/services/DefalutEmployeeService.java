package com.promineotech.store.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.store.models.Employee;
import com.promineotech.store.repository.EmployeeRepository;

@Service
public class DefalutEmployeeService implements EmployeeService {
  @Autowired
  private EmployeeRepository repository;
  
  @Override
  public List<Employee> all(int limit) {
    return null;
  }

  @Override
  public Employee get(int id) {
    Employee model = repository.get(id);
    return model;
  }

  /**
   * Checks user input to make sure it is valid
   * @param input
   * @return True if valid, false if invalid
   */
  protected boolean isValid(Employee input) {
    if (input.getEmployeeId() < 0) {
      return false;
    }
    if (input.getSalaryId() < 0) {
      return false;
    }
    if (input.getDepartmentId() < 0) {
      return false;
    }
    if (input.getFirstName().isEmpty()) {
      return false;
    }
    if (input.getFirstName().isEmpty()) {
      return false;
    }
    return true;
  }
  
  @Override
  public Employee create(Employee input) {
    if (input == null) return null;
    
    if(isValid(input)) {
    Employee existing = repository.get(input.getEmployeeId());
    if (existing == null ) {
      Employee model = repository.create(input);
      return model;
      
      }
      return update(input.getEmployeeId(), input);
    }
    return null;
  }

  @Override
  public Employee update(int id, Employee input) {
    if (id <= 0) {
      id = input.getEmployeeId();
    }
    
    if (isValid(input)) {
      Employee existing = repository.get(id);
      if (existing != null) {
        Employee model = repository.update(id, input);
        return model;
      }
      return create(input);
    }
    return null;
  }

  @Override
  public Employee delete(int id) {
    if (id <= 0) {
      return null;
    }
    
    Employee existing = repository.get(id);
    if (existing != null) {
      Employee model = repository.delete(id);
      return model;
    }
    return null;
  }
}
