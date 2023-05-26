package org.example;

public class Game {
    protected final Player playerA, playerB;

    private GameState state;

    public Game() {
        this.playerA = new Player('A', 0);
        this.playerB = new Player('B', 0);
        state = new RegularGame(this);
    }

    public void addScore(char playerName) {
        state.addScore(playerName);
    }

    public void setState(GameState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
