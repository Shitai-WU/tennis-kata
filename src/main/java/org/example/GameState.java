package org.example;

public abstract class GameState {
    protected final Game game;

    private static final int DEUCE_SCORE = 3;

    public GameState(Game game) {
        this.game = game;
    }

    public abstract void addScore(char playerName);

    protected boolean isFinal() {
        return (game.playerA.getScore() > DEUCE_SCORE && game.playerA.getScore() >= game.playerB.getScore() + 2)
                || (game.playerB.getScore() > DEUCE_SCORE && game.playerB.getScore() >= game.playerA.getScore() + 2);
    }

    protected boolean isDeuce() {
        return (game.playerA.getScore() == game.playerB.getScore()) && (game.playerA.getScore() >= DEUCE_SCORE) && (game.playerB.getScore() >= DEUCE_SCORE);
    }
}
