package alex.writer;

import alex.CalendarFormatter;
import alex.CalendarWriter;
import alex.calendar.MonthCalendar;
import alex.calendar.NavigableList;
import alex.calendar.Year;

import java.util.List;

public class CalendarConsoleWriter implements CalendarWriter {

    public void writeYears(List<Year> years, CalendarFormatter formatter) {
        List<MonthCalendar> monthCalendars = new NavigableList<MonthCalendar>();
        for (Year year : years){
            monthCalendars.addAll(year.getMonthCalendars());
        }
        for(MonthCalendar monthCalendar : monthCalendars){
            System.out.println(formatter.render(monthCalendar));
        }
    }
}
