package the.best;

import org.junit.Test;

import static org.junit.Assert.*;

public class ZeroFigureTest {
    @Test
    public void shouldBeEqualsMethodGetInstance() {
        assertEquals(ZeroFigure.getInstance(), ZeroFigure.getInstance());
    }
}