package the.best;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChristFigureTest {
    @Test
    public void shouldBeEqualsMethodGetInstance() {
        assertEquals(ChristFigure.getInstance(), ChristFigure.getInstance());
    }
}