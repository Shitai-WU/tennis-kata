package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeuceGameTest {
    @Test
    void should_move_to_advantage_game() {
        Game game = createDeuceGame();

        game.addScore('A');

        assertEquals("Advantage Player A", game.toString().trim());
    }

    @Test
    void should_return_deuce_game_score() {
        Game game = createDeuceGame();

        assertEquals("Deuce", game.toString().trim());
    }

    private Game createDeuceGame() {
        Game game = new Game();
        game.addScore('A');
        game.addScore('B');
        game.addScore('A');
        game.addScore('B');
        game.addScore('A');
        game.addScore('B');
        game.addScore('A');
        game.addScore('B');
        return game;
    }
}