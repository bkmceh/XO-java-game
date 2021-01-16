package hexlet.bkmceh.xo.controllers;

import hexlet.bkmceh.xo.model.Field;
import hexlet.bkmceh.xo.model.Figure;
import hexlet.bkmceh.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field) {
        int numFigureX = 0;
        int numFigureO = 0;

        try {
            for (int i = 0; i < field.getSize(); i++) {
                for (int j = 0; j < field.getSize(); j++) {
                    if (field.getFigure(new Point(i, j)) == Figure.X) {
                        numFigureX += 1;
                    }
                    if (field.getFigure(new Point(i, j)) == Figure.O) {
                        numFigureO += 1;
                    }
                }
            }
        } catch (final InvalidPointException e) {
            e.printStackTrace();
        }
        if (numFigureO + numFigureX == field.getSize() * field.getSize()) {
            return null;
        }

        if (numFigureX > numFigureO) {
            return Figure.O;
        }

        return Figure.X;
    }
}
