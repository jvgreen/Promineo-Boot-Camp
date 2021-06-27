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
import com.promineotech.store.models.DepartmentProduct;

@Repository
public class DepartmentProductJdbcRepository implements DepartmentProductRepository {

  @Autowired
  private NamedParameterJdbcTemplate _provider;
  
  @Override
  public DepartmentProduct getLinkId(int id) {
    String sql = ""
        + "SELECT d_p.link_id, d.department_id, d.name, p.product_id, p.name, p.company, p.price "
        + "FROM products p "
        + "inner join depart_products d_p on p.product_id = d_p.product_id "
        + "inner join department d on d.department_id = d_p.department_id "
        + "WHERE d_p.link_id = :link_id;";
      
      Map<String, Object> parameters = new HashMap<>();
      parameters.put("link_id", id);
      
      List<DepartmentProduct> departmentProducts = _provider.query(sql, parameters, new RowMapper<>() {
        public DepartmentProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
          DepartmentProduct model = new DepartmentProduct();
          model.setLinkId(rs.getInt("link_id"));
          model.setDepartmentId(rs.getInt("department_id"));
          model.setProductId(rs.getInt("product_id"));
          model.setDepartmentName(rs.getString("d.name"));
          model.setProductName(rs.getString("p.name"));
          model.setCompany(rs.getNString("p.company"));
          model.setPrice(rs.getDouble("p.price"));
          return model;
        }
      });    
      if(departmentProducts.isEmpty()) {
        return null;
      }
      return(departmentProducts.get(0));
  }


  @Override
  public List<DepartmentProduct> getByProductId(int id) {
    String sql = ""
        + "SELECT d_p.link_id, d.department_id, d.name, p.product_id, p.name, p.company, p.price "
        + "FROM products p "
        + "inner join depart_products d_p on p.product_id = d_p.product_id "
        + "inner join department d on d.department_id = d_p.department_id "
        + "WHERE p.product_id = :product_id;";
      
      Map<String, Object> parameters = new HashMap<>();
      parameters.put("product_id", id);
      
      List<DepartmentProduct> departmentProducts = _provider.query(sql, parameters, new RowMapper<>() {
        public DepartmentProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
          DepartmentProduct model = new DepartmentProduct();
          model.setLinkId(rs.getInt("link_id"));
          model.setDepartmentId(rs.getInt("department_id"));
          model.setProductId(rs.getInt("product_id"));
          model.setDepartmentName(rs.getString("d.name"));
          model.setProductName(rs.getString("p.name"));
          model.setCompany(rs.getNString("p.company"));
          model.setPrice(rs.getDouble("p.price"));
          return model;
        }
      });    
      if(departmentProducts.isEmpty()) {
        return null;
      }
      return(departmentProducts);
  }

  @Override
  public List<DepartmentProduct> getByDepartmentId(int id) {
    String sql = ""
        + "SELECT d_p.link_id, d.department_id, d.name, p.product_id, p.name, p.company, p.price "
        + "FROM products p "
        + "inner join depart_products d_p on p.product_id = d_p.product_id "
        + "inner join department d on d.department_id = d_p.department_id "
        + "WHERE d.department_id = :departmentProduct_id;";
      
      Map<String, Object> parameters = new HashMap<>();
      parameters.put("departmentProduct_id", id);
      
      List<DepartmentProduct> departmentProducts = _provider.query(sql, parameters, new RowMapper<>() {
        public DepartmentProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
          DepartmentProduct model = new DepartmentProduct();
          model.setLinkId(rs.getInt("link_id"));
          model.setDepartmentId(rs.getInt("department_id"));
          model.setProductId(rs.getInt("product_id"));
          model.setDepartmentName(rs.getString("d.name"));
          model.setProductName(rs.getString("p.name"));
          model.setCompany(rs.getNString("p.company"));
          model.setPrice(rs.getDouble("p.price"));
          return model;
        }
      });
      if(departmentProducts.isEmpty()) {
        return null;
      }
      return(departmentProducts);
    }

    @Override
    public DepartmentProduct create(DepartmentProduct input) {
      String sql = "INSERT INTO depart_products (link_id, department_id, product_id) "
          + "VALUES (:link_id, :department_id, :product_id);";
      MapSqlParameterSource parameters = new MapSqlParameterSource();
      parameters.addValue("link_id", input.getLinkId());
      parameters.addValue("department_id", input.getDepartmentId());
      parameters.addValue("product_id", input.getProductId());
      
      int numRows = _provider.update(sql, parameters);
      if(numRows == 1) {
        return getLinkId(input.getLinkId());
      }
      return null;
    }

    @Override
    public DepartmentProduct update(int id, DepartmentProduct input) {
      String sql = "UPDATE depart_products "
          + "SET link_id = :link_id, "
          + "department_id = :department_id, "
          + "product_id = :product_id "
          + "WHERE link_id = :previous_link_id";
      
      MapSqlParameterSource parameters = new MapSqlParameterSource();
      parameters.addValue("previous_link_id", id);
      parameters.addValue("link_id", input.getLinkId());
      parameters.addValue("department_id", input.getDepartmentId());
      parameters.addValue("product_id", input.getProductId());      
      
      int numRows = _provider.update(sql, parameters);
      if (numRows == 1) {
        return getLinkId(input.getLinkId());
      }
      return null;      
    }

    @Override
    public DepartmentProduct delete(int id) {
      DepartmentProduct existing = getLinkId(id);
      if (existing != null) {
        String sql = "DELETE FROM depart_products WHERE link_id = :link_id";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("link_id", id);
        
        int numRows = _provider.update(sql, parameters);
        if (numRows == 1) {
          return existing;
        }
      }
      return null;
    }
    
  }
