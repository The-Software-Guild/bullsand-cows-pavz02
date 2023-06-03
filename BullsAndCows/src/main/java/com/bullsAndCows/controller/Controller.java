package com.bullsAndCows.controller;

import com.bullsAndCows.model.Round;
import com.bullsAndCows.service.GameService;
import com.bullsAndCows.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Controller {

    @Autowired
    GameService gameService;

    @Autowired
    RoundService roundService;

    @PostMapping("/begin")
    public ResponseEntity<Object> setGame() {
        return getResponseBody(gameService.setNewGame(), HttpStatus.OK);
    }

    @PostMapping("/guess")
    public ResponseEntity<Object> setGuess(@RequestBody Map<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        String guess = map.get("guess");

        if (!gameService.doesGameExist(id))
            return getResponseBody("This game does not exist", HttpStatus.NOT_FOUND);

        if (!gameService.isOngoing(id))
            return getResponseBody("This game is over", HttpStatus.NOT_FOUND);

        Round round = roundService.createNewRound(id, guess, gameService.getGame(id).getAnswer());
        gameService.setGameDone(id, roundService.isExactGuess(round));

        return getResponseBody(round, HttpStatus.OK);
    }

    @GetMapping("/game")
    public ResponseEntity<Object> getAllGames() {
        return getResponseBody(gameService.getAllGames(), HttpStatus.OK);
    }

    @GetMapping("/game/{id}")
    public ResponseEntity<Object> getGame(@PathVariable("id") int id) {
        if (!gameService.doesGameExist(id))
            return getResponseBody("This game does not exist", HttpStatus.NOT_FOUND);

        return getResponseBody(gameService.getGame(id), HttpStatus.OK);
    }

    @GetMapping("/rounds/{id}")
    public ResponseEntity<Object> getAllRounds(@PathVariable("id") int id) {
        if (!gameService.doesGameExist(id))
            return getResponseBody("This game does not exist", HttpStatus.NOT_FOUND);
        return getResponseBody(roundService.getGuesses(id), HttpStatus.OK);
    }

    private ResponseEntity<Object> getResponseBody(Object object, HttpStatus status) {
        return new ResponseEntity<>(object, status);
    }
}
