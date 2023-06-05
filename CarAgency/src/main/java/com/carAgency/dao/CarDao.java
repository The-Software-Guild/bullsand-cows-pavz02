package com.carAgency.dao;

import com.carAgency.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDao {
    @Autowired
    private JdbcTemplate jdbc;

    public List<Car> getAllCars() {
        return jdbc.query("SELECT * FROM cars",
                (rs, rowNum) -> new Car(rs.getInt("carId"),
                                        rs.getString("carType")));
    }

    public Integer addCar(Car carType) {
        jdbc.update("INSERT INTO CarTypes VALUES (?)", carType.getCarType());

        return jdbc.queryForObject("SELECT AUTO_INCREMENT FROM information_schema.tables " +
                        "WHERE table_name = 'Cars' AND table_schema = 'CarAgency'",
                new BeanPropertyRowMapper<>(Integer.class));
    }
}
