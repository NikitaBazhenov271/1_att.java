import org.junit.Test;
import static org.junit.Assert.*;

public class CatTest {

    @Test
    public void testInitialPosition() {
        Cat cat = new Cat(200, 200);
        assertEquals(200, cat.getX());//совпадают ли фактические координаты с ожидаемыми с помощью метода assertEquals
        assertEquals(200, cat.getY());
    }

    @Test
    public void testMoveToTarget() {
        Cat cat = new Cat(200, 200);
        cat.setTarget(300, 300);
        cat.moveToTarget();

        int expectedX = 200 + 6;
        int expectedY = 200 + 6;
        assertEquals(expectedX, cat.getX());
        assertEquals(expectedY, cat.getY());
    }

    @Test
    public void testMoveLeft() {
        Cat cat = new Cat(200, 200);
        cat.setTarget(100, 200);
        cat.moveToTarget();
        assertTrue(cat.getX() < 200);  // Должен двигаться влево
    }

    @Test
    public void testMoveUp() {
        Cat cat = new Cat(200, 200);
        cat.setTarget(200, 100);
        cat.moveToTarget();
        assertTrue(cat.getY() < 200);  // Должен двигаться вверх
    }
}
