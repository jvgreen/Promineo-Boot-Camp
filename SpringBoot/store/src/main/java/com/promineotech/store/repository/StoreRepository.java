package com.promineotech.store.repository;

import java.util.List;
import com.promineotech.store.models.Store;

public interface StoreRepository {
  /**
   * Returns all Stores
   * @param limit
   * @return A list of all the stores
   */
  List<Store> all(int limit);
  
  /**
   * Gets a Store by its Id
   * @param id
   * @return 
   */
  Store get(int id);
  
  /**
   * Creates a new Store
   * @param input
   * @return The new Store
   */
  Store create(Store input);
  
  /**
   * Modifies an existing store
   * @param id
   * @param input
   * @return the modified store
   */
  Store update(int id, Store input);
  
  /**
   * Deletes a store by id
   * @param id
   * @return The store is removed, otherwise null is returned
   */
  Store delete(int id);
}
