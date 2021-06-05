package com.promineotech.jeep.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Jeep {
  private Long modelPK;
  private JeepModel modelId;
  private String trimLevel;
  private int numDoors;
  private int wheelSize;
  private BigDecimal basePrice;
  
  public void setModelPk(Long modelPk)
  {
      modelPK = modelPk;
  }
  
  public void setJeepModel(String model)
  {
      modelId = JeepModel.valueOf(model);
  }
  
  public void setTrimLevel(String trim)
  {
      trimLevel = trim;
  }
  
  public void setNumDoors(int doors)
  {
      numDoors = doors;
  }
  
  public void setWheelSize(int wSize)
  {
      wheelSize = wSize;
  }
  
  public void setBasePrice(BigDecimal bPrice)
  {
      basePrice = bPrice;
  }
}