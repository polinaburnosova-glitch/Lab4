import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ZhitelyTest {

    @Test
    void testInitialState() {
        Zhitely z = new Zhitely("Шпунтик", CharacterType.TRUSTFUL, 30, "Долина");
        assertFalse(z.isScared());
        assertFalse(z.hasHearGossip());
    }

    @Test
    void testReactToDragon() {
        Zhitely z = new Zhitely("Шпунтик", CharacterType.TRUSTFUL, 30, "Долина");
        Dragon d = new Dragon(true, 80);
        z.reactToDragon(d);
        assertTrue(z.isScared());
        assertTrue(z.hasHearGossip());
    }

    @Test
    void testDoActionWhenScared() {
        Zhitely z = new Zhitely("Шпунтик", CharacterType.TRUSTFUL, 30, "Долина");
        // Сделаем его напуганным
        z.reactToDragon(new Dragon(true, 80));
        String action = z.doAction();
        assertTrue(action.contains("Боится и прячется"));
    }

    @Test
    void testDoActionWhenNotScaredButHeardGossip() {
        Zhitely z = new Zhitely("Шпунтик", CharacterType.TRUSTFUL, 30, "Долина");
        // Вызовем hearGossip напрямую (без страха)
        Gossip safeRumor = new Gossip("Слух", 1, false);
        z.hearGossip(safeRumor);
        assertFalse(z.isScared());
        assertTrue(z.hasHearGossip());
        String action = z.doAction();
        assertTrue(action.contains("Обсуждает слухи"));
    }

    @Test
    void testMeetStranger() {
        Zhitely curious = new Zhitely("Кнопка", CharacterType.CURIOUS, 50, "Город");
        assertTrue(curious.meetStranger().contains("расспросить"));

        Zhitely brave = new Zhitely("Винтик", CharacterType.BRAVE, 60, "Город");
        assertTrue(brave.meetStranger().contains("познакомиться"));

        Zhitely scared = new Zhitely("Тюбик", CharacterType.SCARED, 20, "Город");
        assertTrue(scared.meetStranger().contains("наблюдает издалека"));
    }

    @Test
    void testToGoToZeleniyGorodSuccess() {
        Zhitely z = new Zhitely("Шпунтик", CharacterType.BRAVE, 90, "Долина");
        String result = z.toGoToZeleniyGorod();
        assertFalse(z.isScared()); // если успешно — не боится
        assertTrue(result.contains("Решается пойти"));
    }

    @Test
    void testToGoToZeleniyGorodFailure() {
        Zhitely z = new Zhitely("Шпунтик", CharacterType.SCARED, 10, "Долина");
        String result = z.toGoToZeleniyGorod();
        assertTrue(z.isScared());
        assertTrue(result.contains("Испугался и остался дома"));
    }

    @Test
    void testHearGossipWithMock() {
        Zhitely z = new Zhitely("Test", CharacterType.BRAVE, 50, "City");
        Gossip mock = mock(Gossip.class);
        when(mock.isScary()).thenReturn(true);
        when(mock.getFormattedContent()).thenReturn("Mock");

        z.hearGossip(mock);

        assertTrue(z.hasHearGossip());
        assertTrue(z.isScared());
    }
}

