package com.promineotech.store.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.store.models.Department;
import com.promineotech.store.repository.DepartmentRepository;

@Service
public class DefaultDepartmentService implements DepartmentService {
  @Autowired
  private DepartmentRepository repository;
  
  @Override
  public List<Department> all(int limit) {
    return null;
  }

  @Override
  public Department get(int id) {
    Department model = repository.get(id);
    return model;
  }

  /**
   * Checks user input to make sure it is valid
   * @param input
   * @return True if valid, false if invalid
   */
  protected boolean isValid(Department input) {
    if (input.getId() < 0) {
      return false;
    }
    if (input.getName().isEmpty()) {
      return false;
    }

    return true;
  }
  
  @Override
  public Department create(Department input) {
    if (input == null) return null;
    
    if(isValid(input)) {
    Department existing = repository.get(input.getId());
    if (existing == null ) {
      Department model = repository.create(input);
      return model;
      
      }
      return update(input.getId(), input);
    }
    return null;
  }

  @Override
  public Department update(int id, Department input) {
    if (id <= 0) {
      id = input.getId();
    }
    
    if (isValid(input)) {
      Department existing = repository.get(id);
      if (existing != null) {
        Department model = repository.update(id, input);
        return model;
      }
      return create(input);
    }
    return null;
  }

  @Override
  public Department delete(int id) {
    if (id <= 0) {
      return null;
    }
    
    Department existing = repository.get(id);
    if (existing != null) {
      Department model = repository.delete(id);
      return model;
    }
    return null;
  }
}
