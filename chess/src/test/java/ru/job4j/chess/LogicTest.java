package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static ru.job4j.chess.firuges.Cell.*;

public class LogicTest {

    @Test(expected = ImpossibleMoveException.class)
    public void whenIsNotDiagonial() {
        new BishopBlack(C1).way(G6);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFound() throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.move(Cell.C1, H6);
    }

    @Test(expected = OccupiedCellException.class)
    public void whenOccupiedCell() throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(C1));
        logic.add(new BishopBlack(A3));
        logic.move(Cell.C1, A3);
    }
}