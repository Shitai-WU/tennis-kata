package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class RegularGameTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void should_throw_exception_when_game_is_not_regular_game() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new RegularGame(new Player('A', 3), new Player('B', 3))
        );
    }

    @Test
    void should_move_to_regular_game() {
        GameState.current = new RegularGame(new Player('A', 1), new Player('B', 2));
        GameState.current.addScore('A');

        assertTrue(GameState.current instanceof RegularGame);
    }

    @Test
    void should_move_to_deuce_game() {
        GameState.current = new RegularGame(new Player('A', 3), new Player('B', 2));
        GameState.current.addScore('B');

        assertTrue(GameState.current instanceof DeuceGame);
    }

    @Test
    void should_move_to_final_game() {
        GameState.current = new RegularGame(new Player('A', 1), new Player('B', 3));
        GameState.current.addScore('B');

        assertTrue(GameState.current instanceof FinalGame);
    }

    @Test
    void should_print_score() {
        GameState.current = new InitGame(new Player('A', 0), new Player('B', 0));
        GameState.current.printScore();

        assertEquals("Game starts:", outputStreamCaptor.toString().strip());
    }
}