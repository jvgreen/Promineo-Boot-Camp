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
import com.promineotech.store.models.Salary;

@Repository
class SalaryJdbcRepository implements SalaryRepository {
  
  @Autowired
  private NamedParameterJdbcTemplate _provider;

  @Override
  public List<Salary> all(int limit) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Salary get(int id) {
    String sql = ""
      + "SELECT salary_id, amount "
      + "FROM salary "
      + "WHERE salary_id = :salary_id;";
    
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("salary_id", id);
    
    List<Salary> salarys = _provider.query(sql, parameters, new RowMapper<>() {
      public Salary mapRow(ResultSet rs, int rowNum) throws SQLException {
        Salary model = new Salary();
        model.setSalary_id(rs.getInt("salary_id"));
        model.setAmount(rs.getDouble("amount"));
        return model;
      }
    });
    
    if(salarys.isEmpty()) {
      return null;
    }
    return(salarys.get(0));
  }

  @Override
  public Salary create(Salary input) {
    String sql = "INSERT INTO salary (salary_id, amount) "
        + "VALUES (:salary_id, :amount);";
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("salary_id", input.getSalary_id());
    parameters.addValue("amount", input.getAmount());
    
    int numRows = _provider.update(sql, parameters);
    if(numRows == 1) {
      return (get(input.getSalary_id()));
    }
    return null;
  }

  @Override
  public Salary update(int id, Salary input) {
    String sql = "UPDATE salary "
        + "SET salary_id = :salary_id, "
        + "amount = :amount "
        + "WHERE salary_id = :previous_salary_id";
    
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("previous_salary_id", id);
    parameters.addValue("salary_id", input.getSalary_id());
    parameters.addValue("amount", input.getAmount());
    
    int numRows = _provider.update(sql, parameters);
    if (numRows == 1) {
      return get(input.getSalary_id());
    }
    return null;      
  }

  @Override
  public Salary delete(int id) {
    Salary existing = get(id);
    if (existing != null) {
      String sql = "DELETE FROM salary WHERE salary_id = :salary_id";
      MapSqlParameterSource parameters = new MapSqlParameterSource();
      parameters.addValue("salary_id", id);
      
      int numRows = _provider.update(sql, parameters);
      if (numRows == 1) {
        return existing;
      }
    }
    return null;
  }
  
}
