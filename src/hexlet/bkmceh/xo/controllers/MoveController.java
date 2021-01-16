package hexlet.bkmceh.xo.controllers;

import hexlet.bkmceh.xo.model.Field;
import hexlet.bkmceh.xo.model.Figure;
import hexlet.bkmceh.xo.model.exceptions.AlreadyOccupiedException;
import hexlet.bkmceh.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field,
                            final Figure figure,
                            final Point point) throws InvalidPointException,
                                                    AlreadyOccupiedException {
        if(field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);

    }

}
