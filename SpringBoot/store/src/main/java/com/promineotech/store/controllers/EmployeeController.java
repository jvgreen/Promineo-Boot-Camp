package com.promineotech.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.promineotech.store.models.Employee;
import com.promineotech.store.services.EmployeeService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
public class EmployeeController {
  @Autowired
  private EmployeeService service;
  
  @Operation(summary = "Gets a employee by it's unique id",
      description = "Gets the employee if found, otherwise returns null")
  @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
  public Employee get(@PathVariable int id) {
    Employee model = service.get(id);
    if (model != null) {
      return model;
    }
    
    throw new ResponseStatusException(HttpStatus.NOT_FOUND,
      String.format("Employee id '%s' was not found", id));
  }
  
  @Operation(summary = "Create a new employee")
  @RequestMapping(value = "/employee/{input}", method = RequestMethod.POST)
  public Employee create(@RequestBody Employee input) {
    if (input == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
          "Employee was empty or missing");
    }
    Employee model = service.create(input);
    if(model != null) {
      return model;
    }
    
    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
        "An internal / unexpected error ocurred creating requested employee");  
    }
  
  @Operation(summary = "Change an existing employee")
  @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
  public Employee update(@PathVariable int id, @RequestBody Employee input) {
    if(input == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
          "Employee was empty or missing");
    }
    
    Employee model = service.update(id, input);
    if (model != null) {
      return model;
    }
    
    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
        "An internal / unexpect error ocurred while modifiying requested employee");  
    }
  
  @Operation(summary = "Delete an existing employee")
  @RequestMapping(value ="/employee/{id}", method = RequestMethod.DELETE)
  public Employee delete(@PathVariable int id) {
     Employee existing = service.get(id);
     if (existing != null) {
       Employee model = service.delete(id);
       if (model != null) {
         return model;
       }
       throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
           "An internal / unexpect error ocurred while deleting requested employee.");
     }
     throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
         "The requested employee doesn't exist.");
  }
}
