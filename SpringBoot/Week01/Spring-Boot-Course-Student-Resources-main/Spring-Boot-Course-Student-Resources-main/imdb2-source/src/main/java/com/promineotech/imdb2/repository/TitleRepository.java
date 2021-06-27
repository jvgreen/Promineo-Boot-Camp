package com.promineotech.imdb2.repository;

import java.util.List;
import com.promineotech.imdb2.models.Title;

public interface TitleRepository {
  /**
   * Gets a title based on it's unique id.
   * @param id The unique / internal id
   * @return The title if found, otherwise null.
   */
  Title get(String id);
  
  /**
   * Returns all titles.
   * @param limit The maximum number of items to return.
   * @return All titles found, if no titles are found then an empty list is returned.
   */
  List<Title> all(int limit);

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
