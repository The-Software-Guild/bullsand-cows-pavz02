package com.bullsAndCows.dao;

import com.bullsAndCows.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameDao {
    @Autowired
    private JdbcTemplate jdbc;

    public void addGame(Game game) {
        jdbc.update("INSERT INTO games (id, answer, isOngoing) VALUES (?, ?, ?)",
                game.getId(), game.getAnswer(), game.isOngoing());
    }

    public Game getGame(int id) {
        return jdbc.queryForObject("SELECT * FROM games WHERE id = ?",
                (rs, rowNum) -> new Game(rs.getInt("id"),
                        rs.getString("answer"),
                        rs.getBoolean("isOngoing")), id);
    }

    public boolean gameExists(int id) {
        return jdbc.queryForObject("SELECT COUNT(*) FROM games WHERE id = ?", Integer.class, id) == 1;
    }

    public void setGameOver(int id) {
        jdbc.update("UPDATE games SET isOngoing = false WHERE id = ?", id);
    }

    public List<Game> getAllGames() {
        return jdbc.query("SELECT * FROM games",
                (rs, rowNum) -> new Game(rs.getInt("id"),
                        rs.getString("answer"),
                        rs.getBoolean("isOngoing")));
    }
}
