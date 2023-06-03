package com.bullsAndCows.service;

import com.bullsAndCows.dao.GameDao;
import com.bullsAndCows.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService {
    private static int currentId = 1;

    @Autowired
    private GameDao dao;

    public Game setNewGame() {
        Game game = new Game(currentId, this.generateAnswer(), true);
        dao.addGame(game);
        currentId++;

        return game;
    }

    public boolean doesGameExist(int id) {
        return dao.gameExists(id);
    }

    public Game getGame(int id) {
        return dao.getGame(id);
    }

    public List<Game> getAllGames() {
        return dao.getAllGames();
    }

    public boolean isOngoing(int id) { return dao.getGame(id).isOngoing(); }

    public void setGameDone(int id, boolean ongoing) {
        if (ongoing) dao.setGameOver(id);
    }

    private String generateAnswer() {
        String answer = "";
        Random random = new Random();

        int number = random.nextInt(10);
        while (number == 0) number = random.nextInt(10);
        answer += String.valueOf(number);

        while(answer.length() < 4) {
            number = random.nextInt(10);
            if (answer.contains(String.valueOf(number))) continue;
            answer += number;
        }

        return answer;
    }

}
