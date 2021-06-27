package com.promineotech.imdb2.services;

import java.util.List;
import com.promineotech.imdb2.models.Title;

/**
 * A service for working with IMDb title information. 
 */
public interface TitleService {
  /**
   * Returns all titles.
   * @param limit The maximum number of titles to return.
   * @return A list of all the titles.
   */
  List<Title> all(int limit);

  /**
   * Gets a title by it's unique id.
   * @param id The unique id of the title.
   * @return The title if found, otherwise null.
   */
  Title get(String id);

  /**
   * Creates a new title.
   * @param input The new title information.
   * @return The newly created title.
   */
  Title create(Title input);
  
  /**
   * Updates or modifies an existing title.
   * @param id The existing id of the title to modify
   * @param input The update title information
   * @return The updated / modified title.
   */
  Title update(String id, Title input);

  /**
   * Deletes or removes the specified title.
   * @param id The unique id of the title to remove.
   * @return The removed title if removed, otherwise returns null
   */
  Title delete(String id);  
}
