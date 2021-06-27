package com.promineotech.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.promineotech.store.models.Department;
import com.promineotech.store.services.DepartmentService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
public class DepartmentController {
  @Autowired
  private DepartmentService service;
  
  @Operation(summary = "Get the department name by its Id",
           description = "Gets the department if the Id is found else it returns null")
  @RequestMapping(value = "/department/{id}", method = RequestMethod.GET) 
  public Department get(@PathVariable int id) {
    Department model = service.get(id);
    if (model != null) {
      return model;
    }
    throw new ResponseStatusException(HttpStatus.NOT_FOUND,
        String.format("Department id '%s' was not found", id));
  }
  @Operation(summary = "Create a new Department")
  @RequestMapping(value = "/department/{input}", method = RequestMethod.POST)
  public Department create(@RequestBody Department input) {
    if (input == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
          "Department was empty or missing");
    }
    Department model = service.create(input);
    if(model != null) {
      return model;
    }
    
    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
        "An internal / unexpected error ocurred creating requested Department");  
    }
  
  @Operation(summary = "Change an existing Department")
  @RequestMapping(value = "/department/{id}", method = RequestMethod.PUT)
  public Department update(@PathVariable int id, @RequestBody Department input) {
    if(input == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
          "Department was empty or missing");
    }
    
    Department model = service.update(id, input);
    if (model != null) {
      return model;
    }
    
    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
        "An internal / unexpect error ocurred while modifiying requested Department");  
    }
  
  @Operation(summary = "Delete an existing Department")
  @RequestMapping(value ="/department/{id}", method = RequestMethod.DELETE)
  public Department delete(@PathVariable int id) {
     Department existing = service.get(id);
     if (existing != null) {
       Department model = service.delete(id);
       if (model != null) {
         return model;
       }
       throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
           "An internal / unexpect error ocurred while deleting requested Department.");
     }
     throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
         "The requested Department doesn't exist.");
  }
}
