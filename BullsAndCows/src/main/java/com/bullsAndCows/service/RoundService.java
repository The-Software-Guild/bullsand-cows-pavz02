package com.bullsAndCows.service;

import com.bullsAndCows.dao.RoundDao;
import com.bullsAndCows.model.Round;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoundService {
    @Autowired
    private RoundDao dao;
    public Round createNewRound(int id, String guess, String actual) {
        Round round = new Round(guess, this.generateResult(guess, actual));
        dao.addRound(id, round);
        return round;
    }

    public boolean isExactGuess(Round round) {
        System.out.println(round.getResult().charAt(1));
        return round.getResult().charAt(1) == '4';
    }

    public List<Round> getGuesses(int id) {
        return dao.getAllRounds(id);
    }

    private String generateResult(String guess, String actual) {
        int exact = 0;
        int partial = 0;

        for (int i = 0; i < 4; i++) {
            if (guess.charAt(i) == actual.charAt(i)) {
                exact++;
            } else if (actual.contains(String.valueOf(guess.charAt(i)))) {
                partial++;
            }
        }

        return "e" + exact + "p" + partial;
    }
}
