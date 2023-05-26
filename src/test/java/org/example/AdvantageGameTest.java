package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdvantageGameTest {
    @Test
    void should_move_to_final_game() {
        Game game = createAdvantageGameWithPlayerA();

        game.addScore('A');

        assertEquals("Player A wins the game", game.toString().trim());
    }

    @Test
    void should_move_to_deuce_game() {
        Game game = createAdvantageGameWithPlayerA();

        game.addScore('B');

        assertEquals("Deuce", game.toString().trim());
    }

    @Test
    void should_return_advantage_game_score() {
        Game game = createAdvantageGameWithPlayerA();

        assertEquals("Advantage Player A", game.toString().trim());
    }

    private Game createAdvantageGameWithPlayerA() {
        Game game = new Game();
        game.addScore('A');
        game.addScore('B');
        game.addScore('A');
        game.addScore('B');
        game.addScore('A');
        game.addScore('B');
        game.addScore('A');
        game.addScore('B');
        game.addScore('A');
        return game;
    }
}