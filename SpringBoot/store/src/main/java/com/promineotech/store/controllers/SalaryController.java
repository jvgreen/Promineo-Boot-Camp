package com.promineotech.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.promineotech.store.models.Salary;
import com.promineotech.store.services.SalaryService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
public class SalaryController {
  @Autowired
  private SalaryService service;
  
  @Operation(summary = "Gets a salary by it's unique id",
      description = "Gets the salary if found, otherwise returns null")
  @RequestMapping(value = "/salary/{id}", method = RequestMethod.GET)
  public Salary get(@PathVariable int id) {
    Salary model = service.get(id);
    if (model != null) {
      return model;
    }
    
    throw new ResponseStatusException(HttpStatus.NOT_FOUND,
      String.format("Salary id '%s' was not found", id));
  }
  
  @Operation(summary = "Create a new salary")
  @RequestMapping(value = "/salary/{input}", method = RequestMethod.POST)
  public Salary create(@RequestBody Salary input) {
    if (input == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
          "Salary was empty or missing");
    }
    Salary model = service.create(input);
    if(model != null) {
      return model;
    }
    
    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
        "An internal / unexpected error ocurred creating requested salary");  
    }
  
  @Operation(summary = "Change an existing salary")
  @RequestMapping(value = "/salary/{id}", method = RequestMethod.PUT)
  public Salary update(@PathVariable int id, @RequestBody Salary input) {
    if(input == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
          "Salary was empty or missing");
    }
    
    Salary model = service.update(id, input);
    if (model != null) {
      return model;
    }
    
    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
        "An internal / unexpect error ocurred while modifiying requested salary");  
    }
  
  @Operation(summary = "Delete an existing salary")
  @RequestMapping(value ="/salary/{id}", method = RequestMethod.DELETE)
  public Salary delete(@PathVariable int id) {
     Salary existing = service.get(id);
     if (existing != null) {
       Salary model = service.delete(id);
       if (model != null) {
         return model;
       }
       throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
           "An internal / unexpect error ocurred while deleting requested salary.");
     }
     throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
         "The requested salary doesn't exist.");
  }
}
