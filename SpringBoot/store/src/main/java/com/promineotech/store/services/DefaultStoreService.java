package com.promineotech.store.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.store.models.Store;
import com.promineotech.store.repository.StoreRepository;

@Service
public class DefaultStoreService implements StoreService {
  @Autowired
  private StoreRepository repository;
  
  @Override
  public List<Store> all(int limit) {
    return null;
  }

  @Override
  public Store get(int id) {
    Store model = repository.get(id);
    return model;
  }

  /**
   * Checks user input to make sure it is valid
   * @param input
   * @return True if valid, false if invalid
   */
  protected boolean isValid(Store input) {
    if (input.getId() < 0) {
      return false;
    }
    if (input.getCity().isEmpty()) {
      return false;
    }
    if (input.getAddress().isEmpty()) {
      return false;
    }
    return true;
  }
  
  @Override
  public Store create(Store input) {
    if (input == null) return null;
    
    if(isValid(input)) {
    Store existing = repository.get(input.getId());
    if (existing == null ) {
      Store model = repository.create(input);
      return model;
      
      }
      return update(input.getId(), input);
    }
    return null;
  }

  @Override
  public Store update(int id, Store input) {
    if (id <= 0) {
      id = input.getId();
    }
    
    if (isValid(input)) {
      Store existing = repository.get(id);
      if (existing != null) {
        Store model = repository.update(id, input);
        return model;
      }
      return create(input);
    }
    return null;
  }

  @Override
  public Store delete(int id) {
    if (id <= 0) {
      return null;
    }
    
    Store existing = repository.get(id);
    if (existing != null) {
      Store model = repository.delete(id);
      return model;
    }
    return null;
  }
}
