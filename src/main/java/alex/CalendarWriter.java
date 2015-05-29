package alex;

import alex.calendar.Year;

import java.util.List;

public interface CalendarWriter {
    void writeYears(List<Year> years, CalendarFormatter formatter);
}
