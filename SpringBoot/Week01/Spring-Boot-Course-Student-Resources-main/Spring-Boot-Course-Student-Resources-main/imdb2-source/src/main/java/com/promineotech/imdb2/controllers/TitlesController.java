package com.promineotech.imdb2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.promineotech.imdb2.models.Title;
import com.promineotech.imdb2.services.TitleService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
@OpenAPIDefinition(info = @Info(title = "IMDb: The Next Generation"))
public class TitlesController {
  @Autowired
  private TitleService service;
  
  @Operation(summary = "Gets a title by it's unique id",
      description = "Gets the title if found, otherwise returns null")
  @RequestMapping(value = "/titles/{title}", method = RequestMethod.GET)
  public Title get(@PathVariable String title) {
    Title model = service.get(title);
    if (model != null) {
      return(model);
    }
    
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
        String.format("Title '%s' was not found", title));
  }
  
  @RequestMapping(value = "/titles", method = RequestMethod.POST)
  public Title create(@RequestBody Title input) {
    if (input == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
          "Title was empty or missing");
    }
    
    Title model = service.create(input);
    if (model != null) {
      return(model);
    }
    
    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
        "An internal / unexpect error ocurred creating requested title.");
  }

  @RequestMapping(value = "/titles/{title}", method = RequestMethod.PUT)
  public Title update(@PathVariable String title, @RequestBody Title input) {
    if ((title == null) || (title.isEmpty())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
          "Not title id was specified.");
    }
    if (input == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
          "Title was empty or missing");
    }
    
    Title model = service.update(title, input);
    if (model != null) {
      return(model);
    }
    
    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
        "An internal / unexpect error ocurred creating requested title.");
  }
  
  @RequestMapping(value = "/titles/{title}", method = RequestMethod.DELETE)
  public Title delete(@PathVariable String title) {
    if ((title == null) || (title.isEmpty())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
          "Not title id was specified.");
    }

    Title existing = service.get(title);
    if (existing != null) {
      Title model = service.delete(title);
      if (model != null) {
        return(model);
      }

      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
          "An internal / unexpect error ocurred creating requested title.");
    }
    
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
        "The requested title doesn't exist.");
  }
}
