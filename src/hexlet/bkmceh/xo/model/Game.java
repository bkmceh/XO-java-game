package hexlet.bkmceh.xo.model;

public class Game {

    private final String name;

    private final Player[] players;

    private final Field field;

    public Game(final String name,
                final Player[] players,
                final Field field) {
        this.name = name;
        this.players = players;
        this.field = field;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Field getField() {
        return field;
    }

    public String getName() {
        return name;
    }
}
