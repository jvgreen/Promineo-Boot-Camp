package com.promineotech.imdb2.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.promineotech.imdb2.models.Title;

@Repository
public class TitleJdbcRepository implements TitleRepository {
  @Autowired
  private NamedParameterJdbcTemplate _provider; 
  
  public Title get(String id) {
    String sql = "SELECT title_id,content_type_id,primary_title "
               + "FROM title "
               + "WHERE title_id = :title_id;";
    Map<String,Object> parameters = new HashMap<String,Object>();
    parameters.put("title_id", id);
    
    List<Title> titles = _provider.query(sql, parameters, new RowMapper<Title>() {
      public Title mapRow(ResultSet rs, int rowNum) throws SQLException {
        Title model = new Title();
        model.setId(rs.getString("title_id"));
        model.setType(rs.getInt("content_type_id"));
        model.setName(rs.getString("primary_title"));
        return(model);
      }
    });
    
    if (titles.isEmpty()) {
      return(null);
    }
    return(titles.get(0));
  }

  public List<Title> all(int limit) {
    // TODO Auto-generated method stub
    return null;
  }

  public Title create(Title input) {
    String sql = "INSERT INTO title (title_id,primary_title,content_type_id)"
               + "VALUES (:title_id,:primary_title,:content_type_id);";
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("title_id", input.getId());
    parameters.addValue("primary_title", input.getName());
    parameters.addValue("content_type_id", input.getType());
    
    int numRows = _provider.update(sql, parameters);
    if (numRows == 1) {
      return(get(input.getId()));
    }
    return null;
  }

  public Title update(String id, Title input) {
    String sql = "UPDATE title SET "
               + "  title_id = :title_id, "
               + "  primary_title = :primary_title, "
               + "  content_type_id = :content_type_id "
               + "WHERE "
               + "  title_id = :previous_title_id;";
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("previous_title_id", id);
    parameters.addValue("title_id", input.getId());
    parameters.addValue("primary_title", input.getName());
    parameters.addValue("content_type_id", input.getType());

    int numRows = _provider.update(sql, parameters);
    if (numRows == 1) {
      return(get(input.getId()));
    }
    return null;
  }

  public Title delete(String id) {
    Title existing = get(id);
    if (existing != null) {
      String sql = "DELETE FROM title WHERE title_id = :title_id;";
      MapSqlParameterSource parameters = new MapSqlParameterSource();
      parameters.addValue("title_id", id);

      int numRows = _provider.update(sql, parameters);
      if (numRows == 1) {
        return(existing);
      }
    }
    
    return null;
  }

}
