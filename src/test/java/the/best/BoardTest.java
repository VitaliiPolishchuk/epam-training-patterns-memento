package the.best;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    Board instance;

    @Before
    public void setUp() throws Exception {
        instance = new Board();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldThrowArrayIndexOutOfBoundsExceptionWhenRowOutOfBoundMethodIsEmpty() {
        instance.isEmpty(3,2);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldThrowArrayIndexOutOfBoundsExceptionWhenRowNegativeMethodIsEmpty() {
        instance.isEmpty(-1,2);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldThrowArrayIndexOutOfBoundsExceptionWhenColOutOfBoundMethodIsEmpty() {
        instance.isEmpty(2,3);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldThrowArrayIndexOutOfBoundsExceptionWhenColNegativeMethodIsEmpty() {
        instance.isEmpty(2,-1);
    }

    @Test
    public void shouldReturnFalseWhenPosIsNotEmptyMethodIsEmpty() {
        Board specialInstance = new Board();
        specialInstance.add(0, 0, ChristFigure.getInstance());
        assertFalse(specialInstance.isEmpty(0, 0));
    }

    @Test
    public void shouldReturnTrueWhenPosIsEmptyMethodIsEmpty() {
        assertTrue(instance.isEmpty(0, 0));
    }

    @Test
    public void shouldBeEqualsUsingSaveRestoreMethod() {
        Board specialInstance1 = new Board();
        Board specialInstance2 = new Board();
        specialInstance1.add(0, 0, ChristFigure.getInstance());

        specialInstance2.restore(specialInstance1.save());

        assertEquals(specialInstance1.toString(), specialInstance2.toString());
    }

    @Test
    public void shouldReturnTrueWhenRow0FullMethodIsEnd() {
        Board specialInstance = new Board();
        specialInstance.add(0, 0, ChristFigure.getInstance());
        specialInstance.add(0, 1, ChristFigure.getInstance());
        specialInstance.add(0, 2, ChristFigure.getInstance());

        assertTrue(specialInstance.isEnd());
    }

    @Test
    public void shouldReturnTrueWhenRow1FullMethodIsEnd() {
        Board specialInstance = new Board();
        specialInstance.add(1, 0, ChristFigure.getInstance());
        specialInstance.add(1, 1, ChristFigure.getInstance());
        specialInstance.add(1, 2, ChristFigure.getInstance());

        assertTrue(specialInstance.isEnd());
    }

    @Test
    public void shouldReturnTrueWhenRow2FullMethodIsEnd() {
        Board specialInstance = new Board();
        specialInstance.add(2, 0, ChristFigure.getInstance());
        specialInstance.add(2, 1, ChristFigure.getInstance());
        specialInstance.add(2, 2, ChristFigure.getInstance());

        assertTrue(specialInstance.isEnd());
    }

    @Test
    public void shouldReturnTrueWhenCol0FullMethodIsEnd() {
        Board specialInstance = new Board();
        specialInstance.add(0, 0, ChristFigure.getInstance());
        specialInstance.add(1, 0, ChristFigure.getInstance());
        specialInstance.add(2, 0, ChristFigure.getInstance());

        assertTrue(specialInstance.isEnd());
    }

    @Test
    public void shouldReturnTrueWhenCol1FullMethodIsEnd() {
        Board specialInstance = new Board();
        specialInstance.add(0, 1, ChristFigure.getInstance());
        specialInstance.add(1, 1, ChristFigure.getInstance());
        specialInstance.add(2, 1, ChristFigure.getInstance());

        assertTrue(specialInstance.isEnd());
    }

    @Test
    public void shouldReturnTrueWhenCol2FullMethodIsEnd() {
        Board specialInstance = new Board();
        specialInstance.add(0, 2, ChristFigure.getInstance());
        specialInstance.add(1, 2, ChristFigure.getInstance());
        specialInstance.add(2, 2, ChristFigure.getInstance());

        assertTrue(specialInstance.isEnd());
    }

    @Test
    public void shouldReturnTrueWhenDiagonalFullMethodIsEnd() {
        Board specialInstance = new Board();
        specialInstance.add(0, 0, ChristFigure.getInstance());
        specialInstance.add(1, 1, ChristFigure.getInstance());
        specialInstance.add(2, 2, ChristFigure.getInstance());

        assertTrue(specialInstance.isEnd());
    }

    @Test
    public void shouldReturnTrueWhenReversedDiagonalFullMethodIsEnd() {
        Board specialInstance = new Board();
        specialInstance.add(2, 0, ChristFigure.getInstance());
        specialInstance.add(1, 1, ChristFigure.getInstance());
        specialInstance.add(0, 2, ChristFigure.getInstance());

        assertTrue(specialInstance.isEnd());
    }

    @Test
    public void shouldReturnTrueWhenNotMatchWinningCombinationMethodIsEnd() {
        Board specialInstance = new Board();
        specialInstance.add(2, 2, ChristFigure.getInstance());
        specialInstance.add(1, 1, ChristFigure.getInstance());
        specialInstance.add(0, 2, ChristFigure.getInstance());

        assertFalse(specialInstance.isEnd());
    }

    @Test
    public void shouldBeEqualsWhenReversedDiagonalFullMethodgetWinner() {
        Board specialInstance = new Board();
        specialInstance.add(2, 0, ChristFigure.getInstance());
        specialInstance.add(1, 1, ChristFigure.getInstance());
        specialInstance.add(0, 2, ChristFigure.getInstance());

        specialInstance.isEnd();

        assertEquals(ChristFigure.getInstance(), specialInstance.getWinner());
    }

    @Test
    public void shouldNotBeEqualsWhenReversedDiagonalFullMethodgetWinner() {
        Board specialInstance = new Board();
        specialInstance.add(2, 0, ChristFigure.getInstance());
        specialInstance.add(1, 1, ChristFigure.getInstance());
        specialInstance.add(2, 2, ChristFigure.getInstance());

        specialInstance.isEnd();

        assertNotEquals(ChristFigure.getInstance(), specialInstance.getWinner());
    }
}