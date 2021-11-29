package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import ru.job4j.chess.firuges.Cell;
import org.junit.Test;

import static ru.job4j.chess.firuges.Cell.*;

public class BishopBlackTest {
    @Test
    public void testPosition() {
        Assert.assertEquals(Cell.C1, new BishopBlack(Cell.C1).position());
    }

    @Test
    public void testWay() {
        Cell[] check = new Cell[] {D2, E3, F4, G5};
        Assert.assertArrayEquals(check, new BishopBlack(Cell.C1).way(G5));
    }

    @Test
    public void testIsDiagonal() {
        new BishopBlack(C1).way(G5);
    }

    @Test
    public void testCopy() {
        Assert.assertEquals(G5, new BishopBlack(Cell.C1).copy(G5).position());
    }
}