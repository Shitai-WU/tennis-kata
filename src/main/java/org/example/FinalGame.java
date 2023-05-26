package org.example;

public class FinalGame extends GameState {
    private final Player winner;

    public FinalGame(Game game, Player winner) {
        super(game);
        this.winner = winner;
    }

    @Override
    public void addScore(char playerName) {
        throw new IllegalStateException("Game has ended");
    }

    @Override
    public String toString() {
        return String.format("Player %s wins the game%n", winner.getName());
    }
}
