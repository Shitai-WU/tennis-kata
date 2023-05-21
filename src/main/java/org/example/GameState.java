package org.example;

public abstract class GameState {
    static GameState current;

    protected final Player playerA, playerB;

    private static final int DEUCE_SCORE = 3;

    protected GameState(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public abstract void addScore(char playerName);

    public abstract void printScore();

    protected boolean isFinal() {
        return (playerA.getScore() > DEUCE_SCORE && playerA.getScore() >= playerB.getScore() + 2)
                || (playerB.getScore() > DEUCE_SCORE && playerB.getScore() >= playerA.getScore() + 2);
    }

    protected boolean isAdvantage() {
        return (playerA.getScore() > DEUCE_SCORE && playerA.getScore() == playerB.getScore() + 1)
                || (playerB.getScore() > DEUCE_SCORE && playerB.getScore() == playerA.getScore() + 1);
    }

    protected boolean isDeuce() {
        return (playerA.getScore() == playerA.getScore()) && (playerA.getScore() >= DEUCE_SCORE) && (playerB.getScore() >= DEUCE_SCORE);
    }
}
