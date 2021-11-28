package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import java.util.Arrays;

public final class Logic {
    private final Figure[] figures = new Figure[32]; /*Создали пустой массив на 32 ячейки */
    private int index = 0; /* Счетчик */

    public void add(Figure figure) {  /* Добавляет фигуру в массив figures */
        figures[index++] = figure;   /* передвигамся на свободную ячейку */
        System.out.println(Arrays.toString(figures));
    }

    public void move(Cell source, Cell dest) /* принимает стартовое и конечное положения фигуры */
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = findBy(source);
                /*System.out.println(index + "  индекс");*/
        Cell[] steps = figures[index].way(dest);
                /*System.out.println(Arrays.toString(steps) + "  массив steps");*/
        free(steps);
        figures[index] = figures[index].copy(dest); /* переписываем начальное полож конечным */
                /*System.out.println(Arrays.toString(figures) + "  перезапись");*/
    }

    private boolean free(Cell[] steps) throws OccupiedCellException {
        for (Figure figure : figures) {
            for (Cell step : steps) {
                if (figure != null && figure.position().equals(step)) {
                    throw new OccupiedCellException();
                }
            }
        }
        return true;
    }

    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }
    /* проверяет есть ли на переданной клетке Cell какая либо фигура из мас figures типа Figure */
    /* если есть то возвращает индекс фигуры в массиве figures, если нет то "фигура не найдена" */

    private int findBy(Cell cell) throws FigureNotFoundException { /*в параметре */
        for (int index = 0; index != figures.length; index++) {    /* передаем клетку Cell */
            Figure figure = figures[index]; /* ставим в переменную поочередно объекты из массива */
            if (figure != null && figure.position().equals(cell)) { /* Если ячейка не null и...  */
                return index;          /* у фигуры извлекаем координаты сравнивая с клеткой Cell*/
            }
        }
        throw new FigureNotFoundException();
    }
}
