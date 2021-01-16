package hexlet.bkmceh.xo.controllers;

import hexlet.bkmceh.xo.model.Field;
import hexlet.bkmceh.xo.model.Figure;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class WinnerControllerTest {

    @Test
    void getWinnerWhenWinnerRow() throws Exception {

        final int SIZE = 3;

        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < SIZE; i++) {
            final Field field = new Field(SIZE);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(field));
        }

    }

    @Test
    void getWinnerWhenNoWinnerRow() throws Exception {

        final int SIZE = 3;

        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < SIZE; i++) {
            final Field field = new Field(SIZE);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.O);
            field.setFigure(new Point(i, 2), Figure.X);
            assertNull(winnerController.getWinner(field));
        }

    }

    @Test
    void getWinnerWhenWinnerColumn() throws Exception {

        final int SIZE = 3;

        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < SIZE; i++) {
            final Field field = new Field(SIZE);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(field));
        }

    }

    @Test
    void getWinnerWhenNoWinnerColumn() throws Exception {

        final int SIZE = 3;

        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < SIZE; i++) {
            final Field field = new Field(SIZE);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.O);
            assertNull(winnerController.getWinner(field));
        }

    }

    @Test
    void getWinnerWhenWinnerFirstDiagonal() throws Exception {

        final int SIZE = 3;

        final WinnerController winnerController = new WinnerController();


        final Field field = new Field(SIZE);
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.X);
        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    void getWinnerWhenNoWinnerFirstDiagonal() throws Exception {

        final int SIZE = 3;

        final WinnerController winnerController = new WinnerController();


        final Field field = new Field(SIZE);
        field.setFigure(new Point(0, 0), Figure.O);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.X);
        assertNull(winnerController.getWinner(field));
    }

    @Test
    void getWinnerWhenWinnerSecondDiagonal() throws Exception {

        final int SIZE = 3;

        final WinnerController winnerController = new WinnerController();


        final Field field = new Field(SIZE);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 0), Figure.X);
        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    void getWinnerWhenNoWinnerSecondDiagonal() throws Exception {

        final int SIZE = 3;

        final WinnerController winnerController = new WinnerController();


        final Field field = new Field(SIZE);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 1), Figure.O);
        field.setFigure(new Point(2, 0), Figure.O);
        assertNull(winnerController.getWinner(field));
    }

}