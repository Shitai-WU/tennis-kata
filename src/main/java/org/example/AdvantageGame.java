package org.example;

public class AdvantageGame extends GameState {
    private final Player advantage;

    public AdvantageGame(Player playerA, Player playerB, Player advantagePlayer) {
        super(playerA, playerB);
        if (!isAdvantage()) {
            throw new IllegalArgumentException("Is not advantage game");
        }
        this.advantage = advantagePlayer;
    }

    @Override
    public void addScore(char playerName) {
        Player winner = playerName == playerA.getName() ? playerA : playerB;
        winner.addScore();

        if (winner.getName() == advantage.getName()) {
            current = new FinalGame(playerA, playerB, winner);
            return;
        }

        current = new DeuceGame(playerA, playerB);
    }

    @Override
    public void printScore() {
        System.out.printf("Advantage Player %s%n", advantage.getName());
    }
}
