package alex.writer;

import alex.CalendarFormatter;
import alex.CalendarWriter;
import alex.calendar.MonthCalendar;
import alex.calendar.NavigableList;
import alex.calendar.Year;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class ConsoleWriter implements CalendarWriter {

    private OutputStream oStream;

    public ConsoleWriter(){
        this(System.out);
    }

    public ConsoleWriter(OutputStream oStream){
        this.oStream = oStream;
    }

    public void writeYears(List<Year> years, CalendarFormatter formatter) {
        NavigableList<MonthCalendar> monthCalendars = new NavigableList<MonthCalendar>();
        for (Year year : years){
            monthCalendars.addAll(year.getMonthCalendars());
        }
        PrintStream out = new PrintStream(oStream);
        for (int i = 0; i < monthCalendars.size(); i++) {
            out.println(formatter.render(monthCalendars, i));
        }
    }
}
