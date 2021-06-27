package com.promineotech.store.repository;

import java.util.List;
import com.promineotech.store.models.Department;

public interface DepartmentRepository {
  /**
   * Returns all Departments
   * @param limit
   * @return A list of all the Departments
   */
  List<Department> all(int limit);
  
  /**
   * Gets a Department by its Id
   * @param id
   * @return 
   */
  Department get(int id);
  
  /**
   * Creates a new Department
   * @param input
   * @return The new Department
   */
  Department create(Department input);
  
  /**
   * Modifies an existing Department
   * @param id
   * @param input
   * @return the modified Department
   */
  Department update(int id, Department input);
  
  /**
   * Deletes a Department by id
   * @param id
   * @return The Department is removed, otherwise null is returned
   */
  Department delete(int id);
}
