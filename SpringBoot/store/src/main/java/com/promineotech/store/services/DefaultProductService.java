package com.promineotech.store.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.store.models.DepartmentProduct;
import com.promineotech.store.models.Product;
import com.promineotech.store.repository.ProductRepository;

@Service
public class DefaultProductService implements ProductService {
  @Autowired
  private ProductRepository repository;
  
  @Override
  public List<Product> all(int limit) {
    return null;
  }

  @Override
  public Product get(int id) {
    Product model = repository.get(id);
    return model;
  }

  /**
   * Checks user input to make sure it is valid
   * @param input
   * @return True if valid, false if invalid
   */
  protected boolean isValid(Product input) {
    if (input.getId() < 0) {
      return false;
    }
    if (input.getName().isEmpty()) {
      return false;
    }
    if (input.getCompany().isEmpty()) {
      return false;
    }
    if (input.getPrice() <= 0) {
      return false;
    }
    return true;
  }
  
  @Override
  public Product create(Product input) {
    if (input == null) return null;
    
    if(isValid(input)) {
    Product existing = repository.get(input.getId());
    if (existing == null ) {
      Product model = repository.create(input);
      return model;
      
      }
      return update(input.getId(), input);
    }
    return null;
  }
  
  @Override
  public Product update(int id, Product input) {
    if (id <= 0) {
      id = input.getId();
    }
    
    if (isValid(input)) {
      Product existing = repository.get(id);
      if (existing != null) {
        Product model = repository.update(id, input);
        return model;
      }
      return create(input);
    }
    return null;
  }

  @Override
  public Product delete(int id) {
    if (id <= 0) {
      return null;
    }
    
    Product existing = repository.get(id);
    if (existing != null) {
      Product model = repository.delete(id);
      return model;
    }
    return null;
  }

}
