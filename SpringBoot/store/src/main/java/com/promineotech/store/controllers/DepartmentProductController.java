package com.promineotech.store.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.promineotech.store.models.DepartmentProduct;
import com.promineotech.store.services.DepartmentProductService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
public class DepartmentProductController {
  @Autowired
  private DepartmentProductService service;
  
  @Operation(summary = "Gets a departmentProduct by it's unique link id",
      description = "Gets the departmentProduct if found, otherwise returns null")
  @RequestMapping(value = "/departmentProductLink/{id}", method = RequestMethod.GET)
  public DepartmentProduct getByLinkId(@PathVariable int id) {
    DepartmentProduct model = service.getByLinkId(id);
    if (model != null) {
      return model;
    }
    
    throw new ResponseStatusException(HttpStatus.NOT_FOUND,
      String.format("DepartmentProduct id '%s' was not found", id));
  }
  
  @Operation(summary = "Gets a Department Product by a product id",
      description = "Gets the departmentProduct if found, otherwise returns null")
  @RequestMapping(value = "/departmentProductProduct/{id}", method = RequestMethod.GET)
  public List<DepartmentProduct> getByProductId(@PathVariable int id) {
    List<DepartmentProduct> model = service.getByProductId(id);
    if (model != null) {
      return model;
    }
    
    throw new ResponseStatusException(HttpStatus.NOT_FOUND,
      String.format("DepartmentProduct id '%s' was not found", id));
  }
  
  @Operation(summary = "Gets a departmentProduct by a department id",
      description = "Gets the departmentProduct if found, otherwise returns null")
  @RequestMapping(value = "/departmentProductDepartment/{id}", method = RequestMethod.GET)
  public List<DepartmentProduct> getByDepartmentId(@PathVariable int id) {
    List<DepartmentProduct> model = service.getByDepartmentId(id);
    if (model != null) {
      return model;
    }
    
    throw new ResponseStatusException(HttpStatus.NOT_FOUND,
      String.format("DepartmentProduct id '%s' was not found", id));
  }
  
  @Operation(summary = "Create a new departmentProduct make sure to use an already "
      + "created product and department Just set the Id's")
  @RequestMapping(value = "/departmentProduct/{input}", method = RequestMethod.POST)
  public DepartmentProduct create(@RequestBody DepartmentProduct input) {
    if (input == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
          "DepartmentProduct was empty or missing");
    }
    DepartmentProduct model = service.create(input);
    if(model != null) {
      return model;
    }
    
    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
        "An internal / unexpected error ocurred creating requested departmentProduct");  
    }
  
  @Operation(summary = "Change an existing departmentProduct Just set the Id's")
  @RequestMapping(value = "/departmentProduct/{id}", method = RequestMethod.PUT)
  public DepartmentProduct update(@PathVariable int id, @RequestBody DepartmentProduct input) {
    if(input == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
          "DepartmentProduct was empty or missing");
    }
    
    DepartmentProduct model = service.update(id, input);
    if (model != null) {
      return model;
    }
    
    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
        "An internal / unexpect error ocurred while modifiying requested departmentProduct");  
    }
  
  @Operation(summary = "Delete an existing departmentProduct")
  @RequestMapping(value ="/departmentProduct/{id}", method = RequestMethod.DELETE)
  public DepartmentProduct delete(@PathVariable int id) {
     DepartmentProduct existing = service.getByLinkId(id);
     if (existing != null) {
       DepartmentProduct model = service.delete(id);
       if (model != null) {
         return model;
       }
       throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
           "An internal / unexpect error ocurred while deleting requested departmentProduct.");
     }
     throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
         "The requested departmentProduct doesn't exist.");
  }
}
