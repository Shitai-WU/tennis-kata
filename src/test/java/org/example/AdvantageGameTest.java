package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AdvantageGameTest {
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
    void should_throw_exception_when_game_is_not_advantage_game() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new AdvantageGame(new Player('A', 0), new Player('B', 0), new Player('A', 0))
        );
    }

    @Test
    void should_move_to_final_game() {
        GameState.current = new AdvantageGame(new Player('A', 5), new Player('B', 4), new Player('A', 5));
        GameState.current.addScore('A');

        assertTrue(GameState.current instanceof FinalGame);
    }

    @Test
    void should_move_to_deuce_game() {
        GameState.current = new AdvantageGame(new Player('A', 5), new Player('B', 4), new Player('A', 5));
        GameState.current.addScore('B');

        assertTrue(GameState.current instanceof DeuceGame);
    }

    @Test
    void should_print_score() {
        GameState.current = new AdvantageGame(new Player('A', 5), new Player('B', 4), new Player('A', 5));
        GameState.current.printScore();

        assertEquals("Advantage Player A", outputStreamCaptor.toString().trim());
    }
}