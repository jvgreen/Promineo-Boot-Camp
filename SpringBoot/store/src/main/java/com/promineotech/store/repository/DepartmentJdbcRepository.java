package com.promineotech.store.repository;

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
import com.promineotech.store.models.Department;
import com.promineotech.store.models.Store;

@Repository
public class DepartmentJdbcRepository implements DepartmentRepository {

  @Autowired
  private NamedParameterJdbcTemplate _provider;
  
  @Override
  public List<Department> all(int limit) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Department get(int id) {
    String sql = ""
      + "SELECT department_id, name "
      + "FROM department "
      + "WHERE department_id = :department_id;";
    
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("department_id", id);
    
    List<Department> departments = _provider.query(sql, parameters, new RowMapper<>() {
      public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
        Department model = new Department();
        model.setId(rs.getInt("department_id"));
        model.setName(rs.getString("name"));
        return model;
      }
    });
    
    if(departments.isEmpty()) {
      return null;
    }
    return(departments.get(0));
  }

  @Override
  public Department create(Department input) {
      String sql = "INSERT INTO department (department_id, name) "
          + "VALUES (:department_id, :name);";
      MapSqlParameterSource parameters = new MapSqlParameterSource();
      parameters.addValue("department_id", input.getId());
      parameters.addValue("name", input.getName());
      
      int numRows = _provider.update(sql, parameters);
      if(numRows == 1) {
        return (get(input.getId()));
      }
      return null;
    }    

  @Override
  public Department update(int id, Department input) {
    String sql = "UPDATE department "
        + "SET department_id = :department_id, "
        + "name = :name "
        + "WHERE department_id = :previous_department_id;";
    
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("previous_department_id", id);
    parameters.addValue("department_id", input.getId());
    parameters.addValue("name", input.getName());
    
    int numRows = _provider.update(sql, parameters);
    if (numRows == 1) {
      return get(input.getId());
    }
    return null;      
  }

  @Override
  public Department delete(int id) {
    Department existing = get(id);
    if (existing != null) {
      String sql = "DELETE FROM department WHERE department_id = :department_id";
      MapSqlParameterSource parameters = new MapSqlParameterSource();
      parameters.addValue("department_id", id);
      
      int numRows = _provider.update(sql, parameters);
      if (numRows == 1) {
        return existing;
      }
    }
    return null;
  }

}
