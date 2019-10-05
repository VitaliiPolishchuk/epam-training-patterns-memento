package the.best;

public class Main {

    static Game game;

    public static void main(String[] args) {
        Board board = new Board();
        game = new GameImpl(board, new Caretaker(board));
        game.run();
    }
}
