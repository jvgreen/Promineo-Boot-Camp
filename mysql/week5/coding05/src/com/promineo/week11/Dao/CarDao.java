package com.promineo.week11.Dao;

import com.promineo.week11.Models.Car;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarDao extends MySqlConnection implements ICarDao {
    private Connection connection;
    public CarDao() {
        connection = super.getConnection("cars");
    }

    @Override
    public ArrayList<Car> getCars() {
        ArrayList<Car> cars = new ArrayList<Car>();

        try {
            CallableStatement st = connection.prepareCall("{call getCars()}");
            boolean hasResult = st.execute();
            if(hasResult) {
                ResultSet rs = st.getResultSet();

                while(rs.next()) {
                    cars.add(new Car(rs.getInt(1), rs.getString(2), rs.getString(3)));
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return cars;
        }
        return cars;
    }

    @Override
    public void createCar(Car car) {
        try
        {
            CallableStatement st = connection.prepareCall("{call addCar(?, ?)}");
            st.setString(1, car.getMake());
            st.setString(2, car.getModel());
            st.execute();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deleteCar(Car car) {
        try {
            CallableStatement st = connection.prepareCall("{call deleteCar(?)}");
            st.setInt(1, car.getCarId());
            st.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void updateCar(Car car) {
        try {
            CallableStatement st = connection.prepareCall("{call updateCar(?,?,?)}");
            st.setInt(1, car.getCarId());
            st.setString(2, car.getMake());
            st.setString(3, car.getModel());
            st.execute();
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
