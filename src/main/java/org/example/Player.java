package org.example;

public class Player {
    private int score;

    private final char name;

    public Player(char name, int score) {
        this.name = name;
        this.score = score;
    }

    public void addScore() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public int displayScore() {
        return switch (score) {
            case 0 -> 0;
            case 1 -> 15;
            case 2 -> 30;
            default -> 40;
        };
    }

    public char getName() {
        return name;
    }
}
