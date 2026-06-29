package org.example;

import org.util.Weekday;

import static org.util.Weekday.MONDAY;
import static org.util.Weekday.THURSDAY;

public class EnumExample {
    public static void main(String[] args) {
        System.out.println(workingHours(MONDAY));
        System.out.println(workingHours(THURSDAY));

        for (Weekday w : Weekday.values()) {
            System.out.println(w + " (" + w.getShortName() + ") " + (w.isWeekEnd() ? "Relax & enjoy!" : "Work hard!"));
        }
    }

    static String workingHours(Weekday weekday) {
        return switch (weekday) {
            case MONDAY, FRIDAY -> "9:30 - 13:00";
            case TUESDAY, THURSDAY -> "14:00 - 17:30";
            case WEDNESDAY, SATURDAY, SUNDAY -> "Выходной";
        };
    }
}
