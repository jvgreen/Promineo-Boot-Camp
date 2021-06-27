package com.promineotech.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.promineotech.store.models.Store;
import com.promineotech.store.services.StoreService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
@OpenAPIDefinition(info = @Info(title = "Generic Store Backend"))
public class StoreController {
  @Autowired
  private StoreService service;
  
  @Operation(summary = "Gets a store by it's unique id",
      description = "Gets the store if found, otherwise returns null")
  @RequestMapping(value = "/store/{id}", method = RequestMethod.GET)
  public Store get(@PathVariable int id) {
    Store model = service.get(id);
    if (model != null) {
      return model;
    }
    
    throw new ResponseStatusException(HttpStatus.NOT_FOUND,
      String.format("Store id '%s' was not found", id));
  }
  
  @Operation(summary = "Create a new store")
  @RequestMapping(value = "/store/{input}", method = RequestMethod.POST)
  public Store create(@RequestBody Store input) {
    if (input == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
          "Store was empty or missing");
    }
    Store model = service.create(input);
    if(model != null) {
      return model;
    }
    
    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
        "An internal / unexpected error ocurred creating requested store");  
    }
  
  @Operation(summary = "Change an existing store")
  @RequestMapping(value = "/store/{id}", method = RequestMethod.PUT)
  public Store update(@PathVariable int id, @RequestBody Store input) {
    if(input == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
          "Store was empty or missing");
    }
    
    Store model = service.update(id, input);
    if (model != null) {
      return model;
    }
    
    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
        "An internal / unexpect error ocurred while modifiying requested store");  
    }
  
  @Operation(summary = "Delete an existing store")
  @RequestMapping(value ="/store/{id}", method = RequestMethod.DELETE)
  public Store delete(@PathVariable int id) {
     Store existing = service.get(id);
     if (existing != null) {
       Store model = service.delete(id);
       if (model != null) {
         return model;
       }
       throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
           "An internal / unexpect error ocurred while deleting requested store.");
     }
     throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
         "The requested store doesn't exist.");
  }
}
