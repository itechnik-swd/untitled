package org.example;

import java.time.Duration;
import java.time.LocalTime;

/**
 * <b>Ответ:</b> 90<br>
 * <b>Объяснение:</b> Duration работает с временем (часы, минуты, секунды,
 * наносекунды).<br>
 * Разница между 10:00 и 11:30 = 1 час 30 минут = 90 минут.
 */
public class WorkingWithDates3 {
    public static void main(String[] args) {
        LocalTime t1 = LocalTime.of(10, 0);
        LocalTime t2 = LocalTime.of(11, 30);

        Duration d = Duration.between(t1, t2);
        System.out.println(d.toMinutes());
    }
}
