package alex;

import alex.reader.InputReader;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class CalendarApp {

    private InputReader reader;

    public void setReader(InputReader reader){
        this.reader = reader;
    }

    CalendarApp(){
        File output = new File("/home/employee/Documents/output/");
        NavigableList<MonthCalendar> monthCalendars = null;
        List<Year> years = reader.getYears();
        Collections.sort(years);
        monthCalendars = new NavigableList<MonthCalendar>();
        for (Year year : years){
            monthCalendars.addAll(year.getMonthCalendars());
        }
        CalendarFileWriter calendarFileWriter = new CalendarFileWriter(output);
        calendarFileWriter.generateFilesForCalendarSet(monthCalendars);
    }


}
