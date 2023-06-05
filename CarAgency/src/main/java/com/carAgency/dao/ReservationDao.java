package com.carAgency.dao;

import com.carAgency.model.CarType;
import com.carAgency.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ReservationDao {
    @Autowired
    private JdbcTemplate jdbc;

    private final RowMapper<Reservation> mapper =
            (rs, rowNum) -> new Reservation(
                    rs.getInt("reservationId"),
                    rs.getInt("carId"),
                    rs.getInt("people"),
                    rs.getDate("startDate").toLocalDate(),
                    rs.getDate("endDate").toLocalDate());

    public List<Reservation> getAllReservations() {
        return jdbc.query("SELECT * FROM Reservations", mapper);
    }

    public Integer addReservation(Reservation reservation) {
        jdbc.update("INSERT INTO Reservations VALUES (?, ?, ?, ?)",
                reservation.getCarId(), reservation.getPeople(),
                reservation.getStartDate(), reservation.getEndDate());

        return jdbc.queryForObject("SELECT AUTO_INCREMENT FROM information_schema.tables " +
                        "WHERE table_name = 'Reservations' AND table_schema = 'CarAgency'",
                new BeanPropertyRowMapper<>(Integer.class));
    }

    public void removeReservation(Reservation reservation) {
        jdbc.update("DELETE FROM Reservations WHERE reservationId = ?", reservation.getReservationId());
    }
}
