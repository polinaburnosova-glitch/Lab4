import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityTest {

    @Test
    void testCityMethods() {
        City city = new City("Зелёный город", 80);

        // Проверяем все методы
        assertEquals("Зелёный город", city.getName());
        assertEquals(80, city.getDangerLevel());
        assertEquals("Зелёный город опасен", city.description());
    }

    @Test
    void testSafeCity() {
        City city = new City("Долина", 20);
        assertEquals("Долина безопасен", city.description());
    }

    @Test
    void testInvalidCityName() {
        assertThrows(IllegalArgumentException.class, () -> new City("", 50));
    }
}