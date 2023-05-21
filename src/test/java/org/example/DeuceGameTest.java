package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DeuceGameTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void should_throw_exception_when_game_is_not_deuce() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new DeuceGame(new Player('A', 2), new Player('B', 2))
        );
    }

    @Test
    void should_move_to_advantage_game() {
        GameState.current = new DeuceGame(new Player('A', 4), new Player('B', 4));
        GameState.current.addScore('A');

        assertTrue(GameState.current instanceof AdvantageGame);
    }

    @Test
    void should_print_score() {
        GameState.current = new DeuceGame(new Player('A', 4), new Player('B', 4));
        GameState.current.printScore();

        assertEquals("Deuce", outputStreamCaptor.toString().trim());
    }
}