package org.example;

public class Player {
    private int score = 0;

    private final char name;

    public Player(char name) {
        this.name = name;
    }

    public void addScore() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public int getDisplayScore() {
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
