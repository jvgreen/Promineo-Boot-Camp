package com.promineotech.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.promineotech.jeep.dao.JeepSalesDao;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

public interface JeepSalesService {

  List<Jeep> fetchJeeps(JeepModel model, String trim);
  
}
