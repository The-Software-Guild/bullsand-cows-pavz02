package com.carAgency.dao;

import com.carAgency.model.CarType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarTypeDao {
    @Autowired
    private JdbcTemplate jdbc;

    public List<CarType> getAllCarTypes() {
        return jdbc.query("SELECT * FROM carTypes",
                (rs, rowNum) -> new CarType(rs.getString("name"),
                                            rs.getDouble("price"),
                                            rs.getInt("capacity")));
    }

    public void addCarType(CarType carType) {
        jdbc.update("INSERT INTO CarTypes VALUES (?, ?, ?)",
                carType.getCarType(), carType.getPrice(), carType.getCapacity());
    }
}
