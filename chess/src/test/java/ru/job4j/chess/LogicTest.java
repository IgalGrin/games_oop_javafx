package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;


import static ru.job4j.chess.firuges.Cell.*;

public class LogicTest {

    @Ignore
    @Test
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        /* Создаем объект для доступа к методам класса Logic */
        Logic logic = new Logic();
        /* Создали слона на С1, в массиве figures типа Figure */
        logic.add(new BishopBlack(Cell.C1));
        /* Запускаем метод move c желаемыми параметрами */
        logic.move(Cell.C1, Cell.H6);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenIsNotDiagonial() {
        new BishopBlack(C1).way(G6);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFound() throws OccupiedCellException, FigureNotFoundException {
        /* Фигура не найдена, т.к. мы ее не создавали */
        Logic logic = new Logic();
        /* У findBy доступ private, напрямую не обратиться, поэтому обращаемся через public move()*/
        /* и ловим исключение */
        logic.move(Cell.C1, H6);
    }

    @Test
    public void whenFigureFound() throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        /* Создаем фигуру в (нулевой) ячейке массива figures */
        logic.add(new BishopBlack(Cell.C1));
        /* запускаем findBy через public move()*/
        logic.move(Cell.C1, H6);
        /* Дальше нужно получить номер ячейки из int index, не знаю как, потом сравнить
        через Assert.assertEquals()
        Также нужно получить массив из Cell[] steps...Далее метод free... */

    }
}