package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegularGameTest {
    @Test
    void should_return_regular_game_score() {
        Game game = new Game();
        game.addScore('A');
        game.addScore('B');
        game.addScore('B');

        assertEquals("Player A: 15 / Player B: 30", game.toString().trim());

    }

    @Test
    void should_move_to_deuce_game() {
        Game game = new Game();
        game.addScore('A');
        game.addScore('A');
        game.addScore('A');
        game.addScore('B');
        game.addScore('B');

        game.addScore('B');

        assertEquals("Deuce", game.toString().trim());
    }

    @Test
    void should_move_to_final_game() {
        Game game = new Game();
        game.addScore('A');
        game.addScore('B');
        game.addScore('B');
        game.addScore('B');

        game.addScore('B');

        assertEquals("Player B wins the game", game.toString().trim());
    }
}