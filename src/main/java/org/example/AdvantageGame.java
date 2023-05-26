package org.example;

public class AdvantageGame extends GameState {
    private final Player advantage;

    public AdvantageGame(Game game, Player advantagePlayer) {
        super(game);
        this.advantage = advantagePlayer;
    }

    @Override
    public void addScore(char playerName) {
        Player winner = playerName == game.playerA.getName() ? game.playerA : game.playerB;
        winner.addScore();

        if (winner.getName() == advantage.getName()) {
            game.setState(new FinalGame(game, winner));
            return;
        }

        game.setState(new DeuceGame(game));
    }

    @Override
    public String toString() {
        return String.format("Advantage Player %s%n", advantage.getName());
    }
}
