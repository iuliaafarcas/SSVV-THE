package org.example;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BeHappyTest {
    @Before
    public void initArray() {
        App.feelings = new ArrayList<>(Arrays.asList(-1, -1, 0, 0, 1, 1, -1, 1, 0, -1, 1, 0, 1, 1, -1, 0, 1, 1));
    }

    @Test
    public void findNonExistent() {
        assertEquals(App.findSadFeeling(15), App.feelings.size());
    }
    @Test
    public void findExistent() {
        assertEquals(App.findSadFeeling(0), 0);
    }

    @Test
    public void checkValid() {
        assertTrue(App.checkNeighbours(6));
    }

    @Test
    public void checkInvalid() {
        assertFalse(App.checkNeighbours(9));
    }

    @Test
    public void singleInsert() {
        App.insertHappyFeelings(9);
        assertEquals(App.feelings.size(),19);
    }

    @Test
    public void testBothInsert() {
        App.insertHappyFeelings(1);
        assertEquals(App.feelings.size(),20);
    }

    @Test
    public void testBeHappy() {
        App.beHappy();
        assertEquals(App.feelings, Arrays.asList(1, -1, 1, -1, 1, 0, 0, 1, 1, -1, 1, 0, 1, -1, 1, 0, 1, 1, -1, 1, 0, 1, 1));
    }

}
