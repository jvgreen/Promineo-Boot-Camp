package com.promineotech.store.services;

import java.util.List;
import com.promineotech.store.models.Salary;

/**
 * A service for working with Salary information
 */
public interface SalaryService {
  /**
   * Returns all Salarys
   * @param limit
   * @return A list of all the salarys
   */
  List<Salary> all(int limit);
  
  /**
   * Gets a Salary by its Id
   * @param id
   * @return 
   */
  Salary get(int id);
  
  /**
   * Creates a new Salary
   * @param input
   * @return The new Salary
   */
  Salary create(Salary input);
  
  /**
   * Modifies an existing salary
   * @param id
   * @param input
   * @return the modified salary
   */
  Salary update(int id, Salary input);
  
  /**
   * Deletes a salary by id
   * @param id
   * @return The salary is removed, otherwise null is returned
   */
  Salary delete(int id);
}
