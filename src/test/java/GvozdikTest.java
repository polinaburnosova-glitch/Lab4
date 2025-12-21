import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GvozdikTest {

    @Test
    void testInitialState() {
        Gvozdik g = new Gvozdik("Гвоздик", CharacterType.BRAVE, 70);
        assertFalse(g.hasReturned()); // изначально не вернулся
        assertEquals("Гвоздик пропал в Зеленом городе", g.doAction());
    }

    @Test
    void testGoToGreenCitySuccess() {
        Gvozdik g = new Gvozdik("Гвоздик", CharacterType.BRAVE, 60); // >50
        g.goToGreenCity();
        assertTrue(g.hasReturned()); // ← теперь будет true!
        assertEquals("Гвоздик дома", g.doAction());
    }

    @Test
    void testDoActionNotReturned() {
        Gvozdik g = new Gvozdik("Гвоздик", CharacterType.BRAVE, 70);
        assertEquals("Гвоздик пропал в Зеленом городе", g.doAction());
    }

    @Test
    void testGoToGreenCityFailure() {
        Gvozdik g = new Gvozdik("Гвоздик", CharacterType.BRAVE, 40); // <=50
        g.goToGreenCity();
        assertFalse(g.hasReturned());
        assertEquals("Гвоздик пропал в Зеленом городе", g.doAction());
    }
}
