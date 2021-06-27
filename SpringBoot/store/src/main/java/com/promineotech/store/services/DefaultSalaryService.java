package com.promineotech.store.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.store.models.Salary;
import com.promineotech.store.repository.SalaryRepository;

@Service
public class DefaultSalaryService implements SalaryService {
  @Autowired
  private SalaryRepository repository;
  
  @Override
  public List<Salary> all(int limit) {
    return null;
  }

  @Override
  public Salary get(int id) {
    Salary model = repository.get(id);
    return model;
  }

  /**
   * Checks user input to make sure it is valid
   * @param input
   * @return True if valid, false if invalid
   */
  protected boolean isValid(Salary input) {
    if (input.getSalary_id() < 0) {
      return false;
    }
    if (input.getAmount() < 0) {
      return false;
    }
    return true;
  }
  
  @Override
  public Salary create(Salary input) {
    if (input == null) return null;
    
    if(isValid(input)) {
    Salary existing = repository.get(input.getSalary_id());
    if (existing == null ) {
      Salary model = repository.create(input);
      return model;
      
      }
      return update(input.getSalary_id(), input);
    }
    return null;
  }

  @Override
  public Salary update(int id, Salary input) {
    if (id <= 0) {
      id = input.getSalary_id();
    }
    
    if (isValid(input)) {
      Salary existing = repository.get(id);
      if (existing != null) {
        Salary model = repository.update(id, input);
        return model;
      }
      return create(input);
    }
    return null;
  }

  @Override
  public Salary delete(int id) {
    if (id <= 0) {
      return null;
    }
    
    Salary existing = repository.get(id);
    if (existing != null) {
      Salary model = repository.delete(id);
      return model;
    }
    return null;
  }
}
