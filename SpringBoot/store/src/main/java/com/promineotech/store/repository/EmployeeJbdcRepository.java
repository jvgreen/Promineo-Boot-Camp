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
import com.promineotech.store.models.Employee;

@Repository
class EmployeeJdbcRepository implements EmployeeRepository {
  
  @Autowired
  private NamedParameterJdbcTemplate _provider;

  @Override
  public List<Employee> all(int limit) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Employee get(int id) {
    String sql = ""
      + "SELECT employee_id, salary_id, department_Id, firstName, lastName "
      + "FROM employees "
      + "WHERE employee_id = :employee_id;";
    
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("employee_id", id);
    
    List<Employee> employees = _provider.query(sql, parameters, new RowMapper<>() {
      public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee model = new Employee();
        model.setEmployeeId(rs.getInt("employee_id"));
        model.setSalaryId(rs.getInt("salary_id"));
        model.setDepartmentId(rs.getInt("department_id"));
        model.setFirstName(rs.getString("firstName"));
        model.setLastName(rs.getString("lastName"));

        return model;
      }
    });
    
    if(employees.isEmpty()) {
      return null;
    }
    return(employees.get(0));
  }

  @Override
  public Employee create(Employee input) {
    String sql = "INSERT INTO employees (employee_id, salary_id, department_id, firstName, lastName) "
        + "VALUES (:employee_id, :salary_id, :department_id, :firstName, :lastName);";
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("employee_id", input.getEmployeeId());
    parameters.addValue("salary_id", input.getSalaryId());
    parameters.addValue("department_id", input.getDepartmentId());
    parameters.addValue("firstName", input.getFirstName());
    parameters.addValue("lastName", input.getLastName());
    
    int numRows = _provider.update(sql, parameters);
    if(numRows == 1) {
      return (get(input.getEmployeeId()));
    }
    return null;
  }

  @Override
  public Employee update(int id, Employee input) {
    String sql = "UPDATE employees "
        + "SET employee_id = :employee_id, "
        + "salary_id = :salary_id, "
        + "department_id = :department_id, "
        + "firstName = :firstName, "
        + "lastName = :lastName "
        + "WHERE employee_id = :previous_employee_id";
    
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("previous_employee_id", id);
    parameters.addValue("employee_id", input.getEmployeeId());
    parameters.addValue("salary_id", input.getSalaryId());
    parameters.addValue("department_id", input.getDepartmentId());
    parameters.addValue("firstName", input.getFirstName());
    parameters.addValue("lastName", input.getLastName());
    
    int numRows = _provider.update(sql, parameters);
    if (numRows == 1) {
      return get(input.getEmployeeId());
    }
    return null;      
  }

  @Override
  public Employee delete(int id) {
    Employee existing = get(id);
    if (existing != null) {
      String sql = "DELETE FROM employees WHERE employee_id = :employee_id";
      MapSqlParameterSource parameters = new MapSqlParameterSource();
      parameters.addValue("employee_id", id);
      
      int numRows = _provider.update(sql, parameters);
      if (numRows == 1) {
        return existing;
      }
    }
    return null;
  }
  
}
