package org.example;

public class FinalGame extends GameState {
    private final Player winner;

    public FinalGame(Player playerA, Player playerB, Player winner) {
        super(playerA, playerB);
        if (!isFinal()) {
            throw new IllegalArgumentException("Is not final game");
        }
        this.winner = winner;
    }

    @Override
    public void addScore(char playerName) {
        throw new IllegalStateException("Game has ended");
    }

    @Override
    public void printScore() {
        System.out.printf("Player %s wins the game%n", winner.getName());
    }
}
