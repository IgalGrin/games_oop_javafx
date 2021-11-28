package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Assert;
import ru.job4j.chess.firuges.Cell;

import static ru.job4j.chess.firuges.Cell.*;

public class BishopBlackTest extends TestCase {

    public void testPosition() {
        Assert.assertEquals(Cell.C1, new BishopBlack(Cell.C1).position());
    }

    public void testWay() {
        /* Создаем ожидаемый массив с клетками-шагами */
        Cell[] check = new Cell[] {D2, E3, F4, G5};
        /* Сравниваем ожидаемый массив с возвратом метода way */
        Assert.assertArrayEquals(check, new BishopBlack(Cell.C1).way(G5));
    }

    public void testIsDiagonal() {
        new BishopBlack(C1).way(G5);
    }

    public void testCopy() {
        Assert.assertEquals(G5, new BishopBlack(Cell.C1).copy(G5).position());
    }
}