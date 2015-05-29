package alex;

import alex.calendar.MonthCalendar;
import alex.calendar.NavigableList;

public interface CalendarFormatter {

    String render(NavigableList<MonthCalendar> monthCalendars, int index);
    String getRelativeFilename(MonthCalendar monthCalendar);
}
