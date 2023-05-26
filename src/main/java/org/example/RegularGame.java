package org.example;

public class RegularGame extends GameState {
    public RegularGame(Game game) {
        super(game);
    }

    @Override
    public void addScore(char winnerName) {
        Player winner = winnerName == game.playerA.getName() ? game.playerA : game.playerB;
        winner.addScore();

        if (isDeuce()) {
            game.setState(new DeuceGame(game));
            return;
        }

        if (isFinal()) {
            game.setState(new FinalGame(game, winner));
        }
    }

    @Override
    public String toString() {
        return String.format("Player %s: %d / Player %s: %d%n", game.playerA.getName(), game.playerA.displayScore(),
                game.playerB.getName(), game.playerB.displayScore());
    }
}
