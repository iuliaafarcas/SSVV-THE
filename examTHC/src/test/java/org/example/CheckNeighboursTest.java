package org.example;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CheckNeighboursTest {
    @Before
    public void initArray() {
        App.feelings = new ArrayList<>(Arrays.asList(-1, -1, 0, 0, 1, 1, -1, 1, 0, -1, 1, -1));
    }
    @Test
    public void emptyArray() {
        App.feelings = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> {
            App.checkNeighbours(1);
        });
    }
    @Test
    public void startBeforeZero() {
        assertThrows(RuntimeException.class, () -> App.checkNeighbours(-1));
    }

    @Test
    public void positionGreaterThanLen() {
        assertThrows(RuntimeException.class, () -> App.checkNeighbours(20));
    }
    @Test
    public void firstElement() {
        assertFalse(App.checkNeighbours(0));
    }

    @Test
    public void lastElement() {
        assertFalse(App.checkNeighbours(App.feelings.size() - 1));
    }

    @Test
    public void onlyBefore() {
        assertFalse(App.checkNeighbours(5));
    }

    @Test
    public void onlyAfter() {
        assertFalse(App.checkNeighbours(4));
    }

    @Test
    public void valid() {
        App.feelings = new ArrayList<>(Arrays.asList(-1, -1, 0, 0, 1, -1, 1, 1, 0, -1, 1, -1));
        assertTrue(App.checkNeighbours(5));
    }


}
