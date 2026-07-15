package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * <b>Ответ:</b> 0m 28d
 * <b>Ловушка:</b> Period.between считает точную разницу в днях, а затем
 * раскладывает на годы/месяцы/дни.
 * От 31 января до 28 февраля — это ровно 28 дней. Но если бы date2 был 1 марта,
 * то p.getMonths() был бы 1, а getDays() — 1 (потому что это 1 месяц и 1 день,
 * так как февраль короче). Не путайте с ChronoUnit.DAYS.between(), который
 * просто возвращает общее количество дней.
 */
public class WorkingWithDates2 {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2026, 1, 31);
        LocalDate date2 = LocalDate.of(2026, 2, 28);
        LocalDate date3 = LocalDate.of(2026, 3, 1);

        Period p = Period.between(date1, date2);
        System.out.println(p.getMonths() + "m " + p.getDays() + "d");
        Period p2 = Period.between(date1, date3);
        System.out.println(p2.getDays() + "d"); // важно учитывать ещё и месяцы

        System.out.println();

        System.out.println(ChronoUnit.DAYS.between(date1, date2));
        System.out.println(ChronoUnit.DAYS.between(date1, date3));
    }
}
