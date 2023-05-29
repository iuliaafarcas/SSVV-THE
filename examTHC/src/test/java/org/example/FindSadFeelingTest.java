package org.example;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertThrows;

public class FindSadFeelingTest {
    @Before
    public void initialize() {
        App.feelings = new ArrayList<>(Arrays.asList(-1, -1, 0, 0, 1, 1, -1, 1, 0, -1, 1, 0, 1, 1, -1, 0, 1, 1));
    }
    @Test
    public void startAtSize() {
        assertEquals(App.findSadFeeling(App.feelings.size()), App.feelings.size());
    }
    @Test
    public void startBeforeZero() {
        assertThrows(RuntimeException.class, () -> App.findSadFeeling(-1));
    }

    @Test
    public void positionGreaterThanLen() {
        assertThrows(RuntimeException.class, () -> App.findSadFeeling(20));
    }

    @Test
    public void startAtLast() {
        assertEquals(App.findSadFeeling(App.feelings.size() - 1), App.feelings.size());
    }

    @Test
    public void existsBeforeStart() {
        App.feelings = new ArrayList<>(Arrays.asList(-1, -1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1));
        assertEquals(App.findSadFeeling(2), 18);
    }
    @Test
    public void existsAfterStart() {
        assertEquals(App.findSadFeeling(0), 0);
    }

    @Test
    public void doesNotExist() {
        assertEquals(App.findSadFeeling(15), App.feelings.size());
    }
}
