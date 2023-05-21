package org.example;

public class Game {
    public static void main(String[] args) {
        Player playerA = new Player('A', 0);
        Player playerB = new Player('B', 0);

        String scores = "ABABAA";
        GameState.current = new InitGame(playerA, playerB);

        scores.strip().replaceAll("[^AB]", "")
                .chars().mapToObj(c -> (char) c)
                .forEach(c -> {
                    GameState.current.addScore(c);
                    GameState.current.printScore();
                });
    }
}