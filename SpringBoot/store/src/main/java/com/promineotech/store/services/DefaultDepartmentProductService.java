package com.promineotech.store.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.store.models.DepartmentProduct;
import com.promineotech.store.repository.DepartmentProductRepository;

@Service
public class DefaultDepartmentProductService implements DepartmentProductService {
  
  @Autowired
  private DepartmentProductRepository repository;
  
  @Override
  public List<DepartmentProduct> getByProductId(int id) {
    List<DepartmentProduct> model = repository.getByProductId(id);
    return model;
  }

  @Override
  public List<DepartmentProduct> getByDepartmentId(int id) {
    List<DepartmentProduct> model = repository.getByDepartmentId(id);
    return model;
  }

  @Override
  public DepartmentProduct getByLinkId(int id) {
    DepartmentProduct model = repository.getLinkId(id);
    return model;
  }
  /**
   * Checks user input to make sure it is valid
   * @param input
   * @return True if valid, false if invalid
   */
  protected boolean isValid(DepartmentProduct input) {
    if (input.getProductId() < 0) {
      return false;
    }
    if (input.getDepartmentId() < 0) {
      return false;
    }

    return true;
  }
  
  @Override
  public DepartmentProduct create(DepartmentProduct input) {
    if (input == null) return null;
    
    if(isValid(input)) {
    DepartmentProduct existing = repository.getLinkId(input.getLinkId());
    if (existing == null ) {
      DepartmentProduct model = repository.create(input);
      return model;
      
      }
      return update(input.getLinkId(), input);
    }
    return null;
  }

  @Override
  public DepartmentProduct update(int id, DepartmentProduct input) {
    if (id <= 0) {
      id = input.getLinkId();
    }
    
    if (isValid(input)) {
      DepartmentProduct existing = repository.getLinkId(id);
      if (existing != null) {
        DepartmentProduct model = repository.update(id, input);
        return model;
      }
      return create(input);
    }
    return null;
  }

  @Override
  public DepartmentProduct delete(int id) {
    if (id <= 0) {
      return null;
    }
    
    DepartmentProduct existing = repository.getLinkId(id);
    if (existing != null) {
      DepartmentProduct model = repository.delete(id);
      return model;
    }
    return null;
  }

}
