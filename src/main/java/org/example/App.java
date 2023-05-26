package org.example;

public class App {
    public static void main(String[] args) {
        String scores = "ABABAA";
        Game game = new Game();

        scores.strip().replaceAll("[^AB]", "")
                .chars().mapToObj(c -> (char) c)
                .forEach(c -> {
                    game.addScore(c);
                    System.out.println(game);
                });
    }
}