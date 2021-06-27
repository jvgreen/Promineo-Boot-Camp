package com.promineotech.imdb2.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.imdb2.models.Title;
import com.promineotech.imdb2.repository.TitleRepository;

@Service
public class DefaultTitleService implements TitleService {
  @Autowired
  private TitleRepository _repository;
  
  public List<Title> all(int limit) {
    return(null);
  }

  public Title get(String id) {
    Title model = _repository.get(id);
    return(model);
  }

  /**
   * Checks the title to make sure it is valid.
   * @param input The title to validate
   * @return True if valid, false if otherwise.
   */
  protected boolean isValid(Title input) {
    if (input.getId().isEmpty()) {
      return(false);
    }
    if (input.getName().isEmpty()) {
      return(false);
    }
    if (input.getType() <= 0) {
      return(false);
    }
    return(true);
  }

  public Title create(Title input) {
    if (input == null) return(null);
    
    if (isValid(input)) {
      Title existing = _repository.get(input.getId());
      if (existing == null) {
        Title model = _repository.create(input);
        return(model);
      }
      
      return(update(input.getId(), input));
    }
    return(null);
  }

  public Title update(String id, Title input) {
    if ((id == null) || (id.isEmpty())) {
      id = input.getId();
    }
    
    if (isValid(input)) {
      Title existing = _repository.get(id);
      if (existing != null) {
        Title model = _repository.update(id, input);
        return(model);
      }
      
      return(create(input));
    }
    
    return(null);
  }

  public Title delete(String id) {
    if ((id == null) || (id.isEmpty())) {
      return(null);
    }
    
    Title existing = _repository.get(id);
    if (existing != null) {
      Title model = _repository.delete(id);
      return(model);
    }
    return(null);
  }
}
