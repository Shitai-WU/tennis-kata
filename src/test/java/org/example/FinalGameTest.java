package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FinalGameTest {
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
    void should_throw_exception_when_game_is_not_final() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new FinalGame(new Player('A', 2), new Player('B', 2), new Player('A', 2))
        );
    }

    @Test
    void should_throw_exception_when_add_score() {
        assertThrows(
                IllegalStateException.class,
                () -> {
                    GameState.current = new FinalGame(new Player('A', 10), new Player('B', 8), new Player('A', 10));
                    GameState.current.addScore('B');
                }
        );
    }

    @Test
    void should_print_score() {
        GameState.current = new FinalGame(new Player('A', 10), new Player('B', 8), new Player('A', 10));
        GameState.current.printScore();

        assertEquals("Player A wins the game", outputStreamCaptor.toString().trim());
    }
}