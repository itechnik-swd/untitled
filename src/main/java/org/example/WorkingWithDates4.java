package org.example;

import java.time.Instant;

/**
 * <b>Ответ:</b> 3600000 (1 час = 3600 секунд * 1000 миллисекунд).<br>
 * <b>Ловушка:</b> Instant — это момент времени в UTC, без привязки к часовому
 * поясу.
 * Это самый безопасный способ работать с временем в
 * многопоточных/распределенных системах. В тестах часто спрашивают разницу
 * между Instant, LocalDateTime и ZonedDateTime.
 */
public class WorkingWithDates4 {
    public static void main(String[] args) {
        Instant now = Instant.now();
        Instant later = now.plusSeconds(3600);
        long diff = later.toEpochMilli() - now.toEpochMilli();
        System.out.println(diff);
    }
}
