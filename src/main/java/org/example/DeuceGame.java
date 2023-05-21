package org.example;

public class DeuceGame extends GameState {

    public DeuceGame(Player playerA, Player playerB) {
        super(playerA, playerB);
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
