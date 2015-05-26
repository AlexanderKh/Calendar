package alex;

import alex.renderer.AbstractCalendarRenderer;
import alex.renderer.HTMLCalendarRenderer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Collections;

public class CalendarApp {
    public static AbstractCalendarRenderer renderer;

    public static void main(String[] args){
        renderer = new HTMLCalendarRenderer();
        InputReader inputReader = new InputReader();
        File input = new File("/home/employee/Documents/input.txt");
        File output = new File("/home/employee/Documents/output/");
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
        CalendarFileWriter calendarFileWriter = new CalendarFileWriter(renderer, output);
        calendarFileWriter.generateFilesForCalendarSet(monthCalendars);
    }
}
