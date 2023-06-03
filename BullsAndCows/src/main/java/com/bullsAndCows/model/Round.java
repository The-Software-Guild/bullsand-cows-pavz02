package com.bullsAndCows.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Round {
    String guess;
    String dateTime;
    String result;

    Round() {}

    public Round(String guess, String result) {
        this.guess = guess;
        this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        this.result = result;
    }

    public Round(String guess, String result, String datetime) {
        this.guess = guess;
        this.dateTime = datetime;
        this.result = result;
    }

    public String getGuess() {
        return guess;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Round{" + "guess='" + guess + ", dateTime=" + dateTime + ", result='" + result + '}';
    }
}
