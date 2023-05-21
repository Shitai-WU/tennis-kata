package org.example;

public class Game {
    public static void main(String[] args) {
        Player playerA = new Player('A');
        Player playerB = new Player('B');

        String scores = "ABABAA";

        GameState.current = new InitGame(playerA, playerB);
        scores.chars().mapToObj(c -> (char) c).forEach(c -> {
            GameState.current.addScore(c);
            GameState.current.printScore();
        });
    }
}