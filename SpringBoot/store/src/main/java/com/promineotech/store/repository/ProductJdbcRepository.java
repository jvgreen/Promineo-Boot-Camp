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
import com.promineotech.store.models.Product;

@Repository
class ProductJdbcRepository implements ProductRepository {
  
  @Autowired
  private NamedParameterJdbcTemplate _provider;

  @Override
  public List<Product> all(int limit) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Product get(int id) {
    String sql = ""
      + "SELECT product_id, name, company, price "
      + "FROM products "
      + "WHERE product_id = :product_id;";
    
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("product_id", id);
    
    List<Product> products = _provider.query(sql, parameters, new RowMapper<>() {
      public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product model = new Product();
        model.setId(rs.getInt("product_id"));
        model.setName(rs.getString("name"));
        model.setCompany(rs.getString("company"));
        model.setPrice(rs.getDouble("price"));
        return model;
      }
    });
    
    if(products.isEmpty()) {
      return null;
    }
    return(products.get(0));
  }

  @Override
  public Product create(Product input) {
    String sql = "INSERT INTO products (product_id, name, company, price) "
        + "VALUES (:product_id, :name, :company, :price);";
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("product_id", input.getId());
    parameters.addValue("name", input.getName());
    parameters.addValue("company", input.getCompany());
    parameters.addValue("price", input.getPrice());
    
    int numRows = _provider.update(sql, parameters);
    if(numRows == 1) {
      return (get(input.getId()));
    }
    return null;
  }

  @Override
  public Product update(int id, Product input) {
    String sql = "UPDATE products "
        + "SET product_id = :product_id, "
        + "name = :name, "
        + "company = :company, "
        + "price = :price "
        + "WHERE product_id = :previous_product_id";
    
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("previous_product_id", id);
    parameters.addValue("product_id", input.getId());
    parameters.addValue("name", input.getName());
    parameters.addValue("company", input.getCompany());
    parameters.addValue("price", input.getPrice());
    
    int numRows = _provider.update(sql, parameters);
    if (numRows == 1) {
      return get(input.getId());
    }
    return null;      
  }

  @Override
  public Product delete(int id) {
    Product existing = get(id);
    if (existing != null) {
      String sql = "DELETE FROM products WHERE product_id = :product_id";
      MapSqlParameterSource parameters = new MapSqlParameterSource();
      parameters.addValue("product_id", id);
      
      int numRows = _provider.update(sql, parameters);
      if (numRows == 1) {
        return existing;
      }
    }
    return null;
  }
  
}
