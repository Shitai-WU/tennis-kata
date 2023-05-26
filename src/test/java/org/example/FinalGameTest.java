package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FinalGameTest {
    @Test
    void should_throw_exception_when_add_score() {
        assertThrows(
                IllegalStateException.class,
                () -> {
                    Game game = createFinalGameWithPlayA();
                    game.addScore('B');
                }
        );
    }

    @Test
    void should_print_score() {
        Game game = createFinalGameWithPlayA();

        assertEquals("Player A wins the game", game.toString().trim());
    }

    private Game createFinalGameWithPlayA() {
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
        game.addScore('A');
        return game;
    }
}