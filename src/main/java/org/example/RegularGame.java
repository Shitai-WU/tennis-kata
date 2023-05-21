package org.example;

public class RegularGame extends GameState {
    public RegularGame(Player playerA, Player playerB) {
        super(playerA, playerB);
        if (isDeuce() || isAdvantage() || isFinal()) {
            throw new IllegalArgumentException("Is not regular game");
        }
    }

    @Override
    public void addScore(char winnerName) {
        Player winner = winnerName == playerA.getName() ? playerA : playerB;
        winner.addScore();

        if (isDeuce()) {
            current = new DeuceGame(playerA, playerB);
            return;
        }

        if (isFinal()) {
            current = new FinalGame(playerA, playerB, winner);
            return;
        }

        current = new RegularGame(playerA, playerB);
    }

    @Override
    public void printScore() {
        System.out.printf("Player %s: %d / Player %s: %d%n", playerA.getName(), playerA.displayScore(),
                playerB.getName(), playerB.displayScore());
    }
}
