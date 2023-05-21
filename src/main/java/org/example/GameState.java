package org.example;

public abstract class GameState {
    static GameState current;

    protected final Player playerA, playerB;

    protected GameState(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public abstract void addScore(char playerName);

    public abstract void printScore();
}
