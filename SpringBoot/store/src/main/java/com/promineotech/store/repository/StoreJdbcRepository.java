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
import com.promineotech.store.models.Store;

@Repository
class StoreJdbcRepository implements StoreRepository {
  
  @Autowired
  private NamedParameterJdbcTemplate _provider;

  @Override
  public List<Store> all(int limit) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Store get(int id) {
    String sql = ""
      + "SELECT store_id, city, address "
      + "FROM store "
      + "WHERE store_id = :store_id;";
    
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("store_id", id);
    
    List<Store> stores = _provider.query(sql, parameters, new RowMapper<>() {
      public Store mapRow(ResultSet rs, int rowNum) throws SQLException {
        Store model = new Store();
        model.setId(rs.getInt("store_id"));
        model.setCity(rs.getString("city"));
        model.setAddress(rs.getString("address"));
        return model;
      }
    });
    
    if(stores.isEmpty()) {
      return null;
    }
    return(stores.get(0));
  }

  @Override
  public Store create(Store input) {
    String sql = "INSERT INTO store (store_id, city, address) "
        + "VALUES (:store_id, :city, :address);";
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("store_id", input.getId());
    parameters.addValue("city", input.getCity());
    parameters.addValue("address", input.getAddress());
    
    int numRows = _provider.update(sql, parameters);
    if(numRows == 1) {
      return (get(input.getId()));
    }
    return null;
  }

  @Override
  public Store update(int id, Store input) {
    String sql = "UPDATE store "
        + "SET store_id = :store_id, "
        + "city = :city, "
        + "address = :address "
        + "WHERE store_id = :previous_store_id";
    
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("previous_store_id", id);
    parameters.addValue("store_id", input.getId());
    parameters.addValue("city", input.getCity());
    parameters.addValue("address", input.getAddress());
    
    int numRows = _provider.update(sql, parameters);
    if (numRows == 1) {
      return get(input.getId());
    }
    return null;      
  }

  @Override
  public Store delete(int id) {
    Store existing = get(id);
    if (existing != null) {
      String sql = "DELETE FROM store WHERE store_id = :store_id";
      MapSqlParameterSource parameters = new MapSqlParameterSource();
      parameters.addValue("store_id", id);
      
      int numRows = _provider.update(sql, parameters);
      if (numRows == 1) {
        return existing;
      }
    }
    return null;
  }
  
}
