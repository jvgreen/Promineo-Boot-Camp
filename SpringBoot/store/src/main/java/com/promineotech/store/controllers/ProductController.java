package com.promineotech.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.promineotech.store.models.Product;
import com.promineotech.store.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
public class ProductController {
  @Autowired
  private ProductService service;
  
  @Operation(summary = "Gets a Product by it's unique id",
      description = "Gets the Product if found, otherwise returns null")
  @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
  public Product get(@PathVariable int id) {
    Product model = service.get(id);
    if (model != null) {
      return model;
    }
    
    throw new ResponseStatusException(HttpStatus.NOT_FOUND,
      String.format("Product id '%s' was not found", id));
  }
  
  @Operation(summary = "Create a new product "
      + "(This will need to be added to a department use Product-Department controller)")
  @RequestMapping(value = "/product/{input}", method = RequestMethod.POST)
  public Product create(@RequestBody Product input) {
    if (input == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
          "Product was empty or missing");
    }
    Product model = service.create(input);
    if(model != null) {
      return model;
    }
    
    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
        "An internal / unexpected error ocurred creating requested product");  
    }
  
  @Operation(summary = "Change an existing product")
  @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
  public Product update(@PathVariable int id, @RequestBody Product input) {
    if(input == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
          "Product was empty or missing");
    }
    
    Product model = service.update(id, input);
    if (model != null) {
      return model;
    }
    
    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
        "An internal / unexpect error ocurred while modifiying requested product");  
    }
  
  @Operation(summary = "Delete an existing product")
  @RequestMapping(value ="/product/{id}", method = RequestMethod.DELETE)
  public Product delete(@PathVariable int id) {
     Product existing = service.get(id);
     if (existing != null) {
       Product model = service.delete(id);
       if (model != null) {
         return model;
       }
       throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
           "An internal / unexpect error ocurred while deleting requested product.");
     }
     throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
         "The requested product doesn't exist.");
  }
}
