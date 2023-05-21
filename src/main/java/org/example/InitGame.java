package org.example;

public class InitGame extends GameState {
    public InitGame(Player playerA, Player playerB) {
        super(playerA, playerB);
    }

    @Override
    public void addScore(char winnerName) {
        Player winner = winnerName == playerA.getName() ? playerA : playerB;
        winner.addScore();

        current = new RegularGame(playerA, playerB);
    }

    @Override
    public void printScore() {
        System.out.println("Game starts: ");
    }
}
