package the.best;

import java.util.Arrays;
import java.util.Objects;

public class Board {

    class Memento {
        private Figure[][] state;

        public Memento(Figure[][] state) {
            this.state = state;
        }

        public Figure[][] getState() {
            return state;
        }
    }

    Figure[][] board;
    Figure winner;

    public Board() {
        this.board = new Figure[3][3];
    }

    private boolean isValid(int r, int c){
        return r >= 0 && r < board.length &&
                c >= 0 && c < board[0].length;
    }

    public boolean isEmpty(int r, int c) {
        if(!isValid(r,c)){
            throw new ArrayIndexOutOfBoundsException(String.format("Indexes out of bound r = %d, c = %d", r, c));
        }
        return board[r][c] == null;
    }

    public void add(int r, int c, Figure figure) {
        board[r][c] = figure;
    }

    public boolean isEnd() {

        for(int i = 0; i < board.length; ++i){
            if(equals(board[i][0],board[i][1], board[i][2])){
                winner = board[i][0];
                return true;
            }
        }

        for(int i = 0; i < board[0].length; ++i){
            if(equals(board[0][i],board[1][i], board[2][i])){
                winner = board[0][i];
                return true;
            }
        }

        if(equals(board[0][0],board[1][1], board[2][2])){
            winner = board[0][0];
            return true;
        }

        if(equals(board[2][0],board[1][1], board[0][2])){
            winner = board[1][1];
            return true;
        }

        return false;
    }

    public Figure getWinner() {
        return winner;
    }

    private boolean equals(Figure f1, Figure f2, Figure f3){
        if(f1 == null || f2 == null || f3 == null){
            return false;
        }
        return f1.equals(f2) &&
                f2.equals(f3);
    }

    @Override
    public String toString() {
        StringBuilder resB = new StringBuilder();
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[i].length; ++j){
                if(board[i][j] == null){
                    resB.append(" ");
                } else {
                    resB.append(board[i][j]);
                }
                resB.append("|");
            }
            resB.deleteCharAt(resB.length() - 1);
            resB.append("\n");
        }
        return resB.toString();
    }

    public Memento save(){
        return new Memento(clone(board));
    }

    public void restore(Memento memento){
        this.board = clone(memento.getState());
    }

    private Figure[][] clone(Figure[][] board){
        Figure[][] clonedBoard = new Figure[3][3];
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[i].length; ++j){
                clonedBoard[i][j] = board[i][j];
            }
        }
        return clonedBoard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board1 = (Board) o;
        return Arrays.equals(board, board1.board);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(winner);
        result = 31 * result + Arrays.hashCode(board);
        return result;
    }
}
