package hexlet.bkmceh.xo.view;

import hexlet.bkmceh.xo.controllers.CurrentMoveController;
import hexlet.bkmceh.xo.controllers.MoveController;
import hexlet.bkmceh.xo.controllers.WinnerController;
import hexlet.bkmceh.xo.model.Field;
import hexlet.bkmceh.xo.model.Figure;
import hexlet.bkmceh.xo.model.Game;
import hexlet.bkmceh.xo.model.exceptions.AlreadyOccupiedException;
import hexlet.bkmceh.xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final WinnerController winnerController = new WinnerController();

    private final MoveController moveController = new MoveController();

    public void show(final Game game) {
        final Field field = game.getField();
        for (int x = 0; x < field.getSize(); x++) {
            if (x != 0)
                Divider();
            printLine(field, x);
        }
        System.out.println();
    }

    private void printLine(final Field field, final int x) {

        for (int y = 0; y < field.getSize(); y++) {
            if (y != 0) {
                System.out.print("|");
            }
            System.out.print(" ");
            final Figure figure;
            try {
                figure = field.getFigure(new Point(y, x));
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
        }
        System.out.println();
    }

    private void Divider() {
        System.out.println("~~~~~~~~~~~");
    }

    public boolean move(final Game game) {
        final Field field = game.getField();
        final Figure currentFigure = currentMoveController.currentMove(field);
        final Figure winner = winnerController.getWinner(field);
        if (winner != null) {
            if (winner == game.getPlayers()[0].getFigure()) {
                System.out.format("Winner is %s\n", game.getPlayers()[0].getName());
            } else {
                System.out.format("Winner is %s\n", game.getPlayers()[1].getName());
            }

            return false;
        }
        if (currentFigure == null) {
            System.out.println("Its a draw!");
            return false;
        }
        if (currentFigure == game.getPlayers()[0].getFigure()) {
            System.out.format("Please enter move point for %s: \n", game.getPlayers()[0].getName());
        } else {
            System.out.format("Please enter move point for %s: \n", game.getPlayers()[1].getName());
        }

        final Point point = askPoint();
        try {
            moveController.applyFigure(field, currentFigure, point);
            System.out.println();
        } catch (InvalidPointException | AlreadyOccupiedException e) {
            System.out.println("Invalid point!\n");
        }
        return true;
    }

    private Point askPoint() {
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private int askCoordinate(final String coordinateName) {
        System.out.format("Please input %s: ", coordinateName);
        final Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (final InputMismatchException e) {
            System.out.println("Hey bro nice move but try once again");
            return askCoordinate(coordinateName);
        }
    }
}
