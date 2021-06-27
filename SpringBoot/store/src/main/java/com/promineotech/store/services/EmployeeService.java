package com.promineotech.store.services;

import java.util.List;
import com.promineotech.store.models.Employee;

/**
 * A service for working with Employee information
 */
public interface EmployeeService {
  /**
   * Returns all Employees
   * @param limit
   * @return A list of all the employees
   */
  List<Employee> all(int limit);
  
  /**
   * Gets a Employee by its Id
   * @param id
   * @return 
   */
  Employee get(int id);
  
  /**
   * Creates a new Employee
   * @param input
   * @return The new Employee
   */
  Employee create(Employee input);
  
  /**
   * Modifies an existing employee
   * @param id
   * @param input
   * @return the modified employee
   */
  Employee update(int id, Employee input);
  
  /**
   * Deletes a employee by id
   * @param id
   * @return The employee is removed, otherwise null is returned
   */
  Employee delete(int id);
}
