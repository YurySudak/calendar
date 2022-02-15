package zen.calendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import zen.calendar.model.Status;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@SpringBootTest
class CalendarApplicationTests {

    @Test
    void con() {
        Assertions.assertEquals("ACTIVE", "" + Status.ACTIVE);
    }

}
