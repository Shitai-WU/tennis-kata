package org.example;

public class RegularGame extends GameState {
    public RegularGame(Player playerA, Player playerB) {
        super(playerA, playerB);
    }

    @Override
    public void addScore(char winnerName) {
        Player winner = winnerName == playerA.getName() ? playerA : playerB;
        winner.addScore();

        if (isDeuce()) {
            current = new DeuceGame(playerA, playerB);
            return;
        }

        if (isAdvantage()) {
            current = new AdvantageGame(playerA, playerB, winner);
            return;
        }

        if (isFinal()) {
            current = new FinalGame(playerA, playerB, winner);
            return;
        }

        current = new RegularGame(playerA, playerB);
    }

    private boolean isFinal() {
        return (playerA.getScore() >= 4 && playerA.getScore() >= playerB.getScore() + 2)
                || (playerB.getScore() >= 4 && playerB.getScore() >= playerA.getScore() + 2);
    }

    private boolean isAdvantage() {
        return (playerA.getScore() >= 4 && playerA.getScore() == playerB.getScore() + 1)
                || (playerB.getScore() >= 4 && playerB.getScore() == playerA.getScore() + 1);
    }

    private boolean isDeuce() {
        return (playerA.getScore() == playerA.getScore()) && (playerA.getScore() >= 4) && (playerB.getScore() >= 4);
    }

    @Override
    public void printScore() {
        System.out.printf("Player %s: %d / Player %s: %d%n", playerA.getName(), playerA.getDisplayScore(),
                playerB.getName(), playerB.getDisplayScore());
    }
}
