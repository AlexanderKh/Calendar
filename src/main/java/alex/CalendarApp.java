package alex;

import alex.calendar.MonthCalendar;
import alex.calendar.NavigableList;
import alex.calendar.Year;
import alex.filewriter.CalendarFileWriter;
import alex.InputReader;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class CalendarApp {
    private InputReader reader;
    private CalendarRenderer renderer;
    public void setReader(InputReader reader){
        this.reader = reader;
    }

    public void setRenderer(CalendarRenderer renderer) {
        this.renderer = renderer;
    }

    public void execute(){
        NavigableList<MonthCalendar> monthCalendars = null;
        System.out.println(reader);
        List<Year> years = reader.getYears();
        Collections.sort(years);
        monthCalendars = new NavigableList<MonthCalendar>();
        for (Year year : years){
            monthCalendars.addAll(year.getMonthCalendars());
        }
        for(MonthCalendar monthCalendar : monthCalendars){
            System.out.println(renderer.render(monthCalendar));
        }
    }
}
