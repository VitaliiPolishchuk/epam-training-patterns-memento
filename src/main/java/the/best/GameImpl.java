package the.best;

import java.util.Scanner;

public class GameImpl implements Game {

    Board board;
    Figure figure;
    Caretaker caretaker;

    public GameImpl(Board board, Caretaker caretaker) {
        this.board = board;
        this.caretaker = caretaker;
    }

    @Override
    public void run() {
        board = new Board();
        doMoves();
    }

    private void doMoves() {
        while(true) {
            if(board.isEnd()){
                System.out.println("Win " + board.getWinner());
                return;
            }

            figure = getFigure();
            System.out.printf("This is move of %s\nChoose position: row,column\n\t0,1\nThis is example of choosing the position in 0 row and 1 column.\n" +
                    "To make back move enter '<-'\n", figure);
            Scanner scanner = new Scanner(System.in);
            String args = scanner.nextLine();
            if ("<-".equals(args)) {
                goBack();
                continue;
            }
            String[] posArgs = args.split("\\,");
            int r = Integer.parseInt(posArgs[0]);
            int c = Integer.parseInt(posArgs[1]);
            if (board.isEmpty(r, c)){
                caretaker.push(board.save());
                board.add(r, c, figure);
                System.out.println(board);
            } else {
                System.out.println("This position is not empty");
            }
        }
    }

    private void goBack(){
        if(caretaker.size() == 0){
            System.out.println("Board is empty");
            return;
        }

        board.restore(caretaker.pop());
        System.out.println(board);
    }

    private Figure getFigure(){
        if(caretaker.size() % 2 == 0) {
            return ChristFigure.getInstance();
        } else {
            return ZeroFigure.getInstance();
        }
    }
}
