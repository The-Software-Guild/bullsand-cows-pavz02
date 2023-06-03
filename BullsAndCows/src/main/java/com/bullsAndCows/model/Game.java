package com.bullsAndCows.model;

import org.hibernate.annotations.Type;

public class Game {
    private int id;
    private String answer;
    private Boolean isOngoing;

    Game() { }

    public Game(int id, String answer, Boolean isOngoing) {
        this.id = id;
        this.answer = answer;
        this.isOngoing = isOngoing;
    }

    public int getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public Boolean isOngoing() {
        return isOngoing;
    }

    public void setGameOver() { isOngoing = false; }

    @Override
    public String toString() {
        String result = "Game{" + "id=" + id;
        if (!this.isOngoing()) result += ", answer='" + answer;
        result += ", isOngoing=" + isOngoing;

        return result;
    }
}
