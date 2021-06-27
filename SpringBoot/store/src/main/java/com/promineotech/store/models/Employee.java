package com.promineotech.store.models;

import lombok.Data;

@Data
public class Employee {
  private int employeeId;
  private int salaryId;
  private int departmentId;
  private String firstName;
  private String lastName;
}
