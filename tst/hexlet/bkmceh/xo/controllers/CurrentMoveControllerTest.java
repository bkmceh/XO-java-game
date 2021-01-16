package hexlet.bkmceh.xo.controllers;

import hexlet.bkmceh.xo.model.Field;
import hexlet.bkmceh.xo.model.Figure;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CurrentMoveControllerTest {

    @Test
    void currentMoveWhenNextMoveIsO() throws Exception {
        CurrentMoveController currentMoveController = new CurrentMoveController();

        final Field field = new Field(3);

        field.setFigure(new Point(0, 1), Figure.X);
        field.setFigure(new Point(1, 1), Figure.O);
        field.setFigure(new Point(1, 0), Figure.X);

        assertEquals(Figure.O, currentMoveController.currentMove(field));
    }

    @Test
    void currentMoveWhenNextMoveIsX() throws Exception {
        CurrentMoveController currentMoveController = new CurrentMoveController();

        final Field field = new Field(3);

        field.setFigure(new Point(0, 1), Figure.X);
        field.setFigure(new Point(1, 1), Figure.O);
        field.setFigure(new Point(1, 0), Figure.O);

        assertEquals(Figure.X, currentMoveController.currentMove(field));
    }

    @Test
    void currentMoveWhenNoNextMove() throws Exception {
        CurrentMoveController currentMoveController = new CurrentMoveController();

        final Field field = new Field(3);

        for (int i = 0; i < field.getSize(); i++) {
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.O);
            field.setFigure(new Point(i, 2), Figure.X);

        }
        assertNull(currentMoveController.currentMove(field));
    }

}