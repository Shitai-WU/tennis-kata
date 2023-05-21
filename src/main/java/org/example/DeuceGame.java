package org.example;

public class DeuceGame extends GameState {

    public DeuceGame(Player playerA, Player playerB) {
        super(playerA, playerB);
        if (!isDeuce()) {
            throw new IllegalArgumentException("Is not deuce game");
        }
    }

    @Override
    public void addScore(char winnerName) {
        Player winner = winnerName == playerA.getName() ? playerA : playerB;
        winner.addScore();

        current = new AdvantageGame(playerA, playerB, winner);
    }

    @Override
    public void printScore() {
        System.out.println("Deuce");
    }
}
