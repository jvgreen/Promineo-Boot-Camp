package com.promineotech.store.services;

import java.util.List;
import com.promineotech.store.models.DepartmentProduct;

/**
 * A service for working with Store information
 */
public interface DepartmentProductService {

  /**
   * Gets a product department link by link id
   * @param id
   * @return
   */
  DepartmentProduct getByLinkId(int id);
  
  /**
   * Gets a product department link by product id
   * @param id
   * @return 
   */
  List<DepartmentProduct> getByProductId(int id);
  
  /**
   * Gets a product department link by department id
   * @param id
   * @return 
   */
  List<DepartmentProduct> getByDepartmentId(int id);
  
  /**
   * Creates a new DepartmentProduct
   * @param input
   * @return The new DepartmentProduct
   */
  DepartmentProduct create(DepartmentProduct input);
  
  /**
   * Modifies an existing DepartmentProduct
   * @param id
   * @param input
   * @return the modified DepartmentProduct
   */
  DepartmentProduct update(int id, DepartmentProduct input);
  
  /**
   * Deletes a DepartmentProduct by id
   * @param id
   * @return The DepartmentProduct is removed, otherwise null is returned
   */
  DepartmentProduct delete(int id);
}
