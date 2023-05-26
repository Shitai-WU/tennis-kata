package org.example;

public class DeuceGame extends GameState {

    public DeuceGame(Game game) {
        super(game);
    }

    @Override
    public void addScore(char winnerName) {
        Player winner = winnerName == game.playerA.getName() ? game.playerA : game.playerB;
        winner.addScore();

        game.setState(new AdvantageGame(game, winner));
    }

    @Override
    public String toString() {
        return "Deuce";
    }
}
