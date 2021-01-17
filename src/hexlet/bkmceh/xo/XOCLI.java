package hexlet.bkmceh.xo;

import hexlet.bkmceh.xo.model.Field;
import hexlet.bkmceh.xo.model.Figure;
import hexlet.bkmceh.xo.model.Game;
import hexlet.bkmceh.xo.model.Player;
import hexlet.bkmceh.xo.view.ConsoleView;

public class XOCLI {
    public static void main(final String[] args) {
        final String name1 = "Захар";
        final String name2 = "Ильсур";

        final Player[] players = new Player[2];

        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game gameXO = new Game("XO", players, new Field(3));

        final ConsoleView consoleView = new ConsoleView();

        System.out.format("Game name: %s\n", gameXO.getName());

        System.out.format("%s is %s\n", players[0].getName(), players[0].getFigure());
        System.out.format("%s is %s\n", players[1].getName(), players[1].getFigure());

        System.out.println("Coordinate starts from 1 to 3");

        consoleView.show(gameXO);

        while(consoleView.move(gameXO)) {
            consoleView.show(gameXO);
        }
    }
}
