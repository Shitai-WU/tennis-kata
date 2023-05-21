package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    @Test
    void should_add_score() {
        Player player = new Player('A', 5);
        player.addScore();

        assertEquals(6, player.getScore());
    }

    @Test
    void should_display_score_when_score_is_0() {
        Player player = new Player('A', 0);

        assertEquals(0, player.displayScore());
    }

    @Test
    void should_display_score_when_score_is_1() {
        Player player = new Player('A', 1);

        assertEquals(15, player.displayScore());
    }

    @Test
    void should_display_score_when_score_is_2() {
        Player player = new Player('A', 2);

        assertEquals(30, player.displayScore());
    }

    @Test
    void should_display_score_when_score_is_3() {
        Player player = new Player('A', 3);

        assertEquals(40, player.displayScore());
    }

    @Test
    void should_display_score_when_score_is_larger_than_3() {
        Player player = new Player('A', 5);

        assertEquals(40, player.displayScore());
    }
}