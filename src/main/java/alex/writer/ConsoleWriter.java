package alex.writer;

import alex.CalendarFormatter;
import alex.CalendarWriter;
import alex.calendar.MonthCalendar;
import alex.calendar.NavigableList;
import alex.calendar.Year;

import java.util.List;

public class ConsoleWriter implements CalendarWriter {

    public void writeYears(List<Year> years, CalendarFormatter formatter) {
        NavigableList<MonthCalendar> monthCalendars = new NavigableList<MonthCalendar>();
        for (Year year : years){
            monthCalendars.addAll(year.getMonthCalendars());
        }
        for (int i = 0; i < monthCalendars.size(); i++) {
            System.out.println(formatter.render(monthCalendars, i));
        }
    }
}
