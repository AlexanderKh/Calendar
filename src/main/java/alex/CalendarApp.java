package alex;

import alex.renderer.AbstractCalendarRenderer;
import alex.renderer.HTMLCalendarRenderer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class CalendarApp {
    public static AbstractCalendarRenderer renderer;

    public static void main(String[] args){
        renderer = new HTMLCalendarRenderer();
        InputReader inputReader = new InputReader();
        File input = new File("/home/employee/Documents/input.txt");
        File output = new File("/home/employee/Documents/output/");
        NavigableList<MonthCalendar> monthCalendars = null;
        try {
            List<Year> years = inputReader.readYears(input);
            Collections.sort(years);
            monthCalendars = new NavigableList<MonthCalendar>();
            for (Year year : years){
                monthCalendars.addAll(year.getMonthCalendars());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        CalendarFileWriter calendarFileWriter = new CalendarFileWriter(renderer, output);
        calendarFileWriter.generateFilesForCalendarSet(monthCalendars);
    }
}
