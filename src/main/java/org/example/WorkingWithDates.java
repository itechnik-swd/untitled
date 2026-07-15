package org.example;

import java.time.LocalDate;
import java.time.Period;

/**
 * <b>Ответ:</b> 2<br>
 * <b>Объяснение:</b> Period работает с датами (годы, месяцы, дни). Разница
 * между 7 и 9 июля = 2 дня. Всё просто.
 */
public class WorkingWithDates {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2026, 7, 7);
        LocalDate date2 = LocalDate.of(2026, 7, 9);
        LocalDate date3 = LocalDate.of(2026, 5, 7);
        LocalDate date4 = LocalDate.of(2025, 3, 15);

        Period p = Period.between(date1, date2);
        System.out.println(p.getDays());
        Period p2 = Period.between(date1, date3);
        System.out.println(p2.getMonths());
        Period p3 = Period.between(date1, date4);
        System.out.println(p3.getYears());
    }
}
