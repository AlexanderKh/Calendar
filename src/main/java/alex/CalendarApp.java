package alex;

import alex.renderer.AbstractCalendarRenderer;
import alex.renderer.HTMLCalendarRenderer;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CalendarApp {
    public static AbstractCalendarRenderer renderer;

    public static void main(String[] args){
        renderer = new HTMLCalendarRenderer();
        InputReader inputReader = new InputReader();
        File input = new File("C:\\Users\\Admin4ik\\Desktop\\input.txt");
        File output = new File("C:\\Users\\Admin4ik\\Desktop\\output\\");
        CalendarSet<MonthCalendar> monthCalendars = null;
        try {
            CalendarSet<Calendar> calendars = inputReader.getFirstDatesFromFile(input);
            Collections.sort(calendars);
            monthCalendars = new CalendarSet<MonthCalendar>();
            for (Calendar calendar : calendars){
                monthCalendars.add(new MonthCalendar(calendar));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        CalendarWriter calendarWriter = new CalendarWriter(renderer, output);
        calendarWriter.generateFilesForCalendarSet(monthCalendars);
    }
}
