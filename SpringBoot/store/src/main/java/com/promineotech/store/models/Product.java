package com.promineotech.store.models;

import lombok.Data;

@Data
public class Product {
  private int id;
  private String name;
  private String company;
  private Double price;
}
