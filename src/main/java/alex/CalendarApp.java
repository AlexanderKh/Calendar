package alex;

import alex.renderer.AbstractCalendarRenderer;
import alex.renderer.HTMLCalendarRenderer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalendarApp {
    public static AbstractCalendarRenderer renderer;

    public static void main(String[] args){
        renderer = new HTMLCalendarRenderer();
        Calendar date = Calendar.getInstance();
        InputReader inputReader = new InputReader();
        File file = new File("/home/employee/Documents/input.txt");
        List<Date> dates = null;
        try {
            dates = inputReader.getFirstDatesFromFile(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        CalendarWriter calendarWriter = new CalendarWriter(renderer);
        calendarWriter.generateFiles(dates);
    }
}
