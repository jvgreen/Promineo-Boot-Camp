package com.promineotech.store.models;

import lombok.Data;

@Data
public class DepartmentProduct {
  private int linkId;
  private int departmentId;
  private int productId;
  private String departmentName;
  private String productName;
  private String company;
  private double price;
}