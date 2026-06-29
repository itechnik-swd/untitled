package org.util;

public enum Weekday {
    MONDAY("MON", false),

    TUESDAY("TUE", false),

    WEDNESDAY("WEN", false),

    THURSDAY("THU", false),

    FRIDAY("FRI", false),

    SATURDAY("SAT", true),

    SUNDAY("SUN", true);

    private final String shortName;
    private final boolean isWeekEnd;

    Weekday(String shortName, boolean isWeekEnd) {
        this.shortName = shortName;
        this.isWeekEnd = isWeekEnd;
    }

    public String getShortName() {
        return shortName;
    }

    public boolean isWeekEnd() {
        return isWeekEnd;
    }
}
