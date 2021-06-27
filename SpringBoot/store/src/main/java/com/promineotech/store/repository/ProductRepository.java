package com.promineotech.store.repository;

import java.util.List;
import com.promineotech.store.models.DepartmentProduct;
import com.promineotech.store.models.Product;

public interface ProductRepository {
  /**
   * Returns all Products
   * @param limit
   * @return A list of all the Products
   */
  List<Product> all(int limit);
  
  /**
   * Gets a Product by its Id
   * @param id
   * @return 
   */
  Product get(int id);
  
  /**
   * Creates a new Product
   * @param input
   * @return The new Product
   */
  Product create(Product input);
  
  /**
   * Modifies an existing Product
   * @param id
   * @param input
   * @return the modified Product
   */
  Product update(int id, Product input);
  
  /**
   * Deletes a Product by id
   * @param id
   * @return The Product is removed, otherwise null is returned
   */
  Product delete(int id);
}
