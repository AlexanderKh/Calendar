package alex;

import alex.calendar.MonthCalendar;
import alex.calendar.NavigableList;
import alex.calendar.Year;

import java.util.Collections;
import java.util.List;

public class CalendarApp {
    private InputReader reader;
    private CalendarFormatter formatter;
    private CalendarWriter writer;
    public void setReader(InputReader reader){
        this.reader = reader;
    }
    public void setFormatter(CalendarFormatter formatter) {
        this.formatter = formatter;
    }
    public void setWriter(CalendarWriter writer) {
        this.writer = writer;
    }

    public void execute(){

        List<Year> years = reader.getYears();
        writer.writeYears(years, formatter);
    }
}
