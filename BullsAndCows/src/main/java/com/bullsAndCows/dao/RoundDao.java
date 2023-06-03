package com.bullsAndCows.dao;

import com.bullsAndCows.model.Round;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RoundDao {
    @Autowired
    private JdbcTemplate jdbc;

    public List<Round> getAllRounds(int id) {
        return jdbc.query("SELECT * FROM rounds WHERE gameId = ?",
                (rs, rowNum) -> new Round(rs.getString("guess"),
                        rs.getString("result"),
                        rs.getString("guessTime")), id);
    }

    public void addRound(int id, Round round) {
        jdbc.update("INSERT INTO rounds (gameId, guess, guessTime, result) VALUES (?, ?, ?, ?)",
                id, round.getGuess(), round.getDateTime(), round.getResult());
    }
}
