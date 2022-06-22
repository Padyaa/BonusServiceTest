import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusServiceTest {
    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long actual = service.calculate(1000, true);

        Assertions.assertEquals(30, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long actual = service.calculate(1_000_000, true);

        Assertions.assertEquals(500, actual);
    }

    @Test
    void shouldCalculateForNotRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long actual = service.calculate(1000, false);

        Assertions.assertEquals(10, actual);
    }

    @Test
    void shouldCalculateForNotRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long actual = service.calculate(1_000_000, false);

        Assertions.assertEquals(500, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOnLimit() {
        BonusService service = new BonusService();

        long actual = service.calculate(16_700, true);

        Assertions.assertEquals(500, actual);
    }

    @Test
    void shouldCalculateForNotRegisteredAndOnLimit() {
        BonusService service = new BonusService();

        long actual = service.calculate(50_000, false);

        Assertions.assertEquals(500, actual);
    }
}

