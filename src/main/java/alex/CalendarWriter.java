package alex;

import alex.renderer.AbstractCalendarRenderer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

public class CalendarWriter {
    private static final String HTML = ".html";
    private static final String FOLDER = "/home/employee/Documents/out";
    public static final String NEW_LINE = "\n";
    public static final String PATH_SEPARATOR = "/";
    private AbstractCalendarRenderer renderer;

    CalendarWriter(AbstractCalendarRenderer renderer){
        this.renderer = renderer;
    }

    public void generateFiles(List<Date> datesToWrite){
        Collections.sort(datesToWrite);
        List<MonthCalendar> monthCalendars = new ArrayList<MonthCalendar>();
        Calendar calendar = null;
        for (Date date : datesToWrite){
            calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.YEAR, -1900);
            monthCalendars.add(new MonthCalendar(calendar));
        }
        MonthCalendar prevMonth;
        MonthCalendar nextMonth;
        MonthCalendar currentMonth;
        for (int i = 0; i < monthCalendars.size(); i++) {
            prevMonth = (i - 1 >= 0) ? monthCalendars.get(i - 1) : null;
            currentMonth = monthCalendars.get(i);
            nextMonth = (i < monthCalendars.size() - 1) ? monthCalendars.get(i + 1) : null;
            printMonthToFile(prevMonth, currentMonth, nextMonth);
        }
    }

    private void printMonthToFile(MonthCalendar previousMonth, MonthCalendar currentMonth, MonthCalendar nextMonth){
        String result = "";
        if (previousMonth != null)
            result += "Prev month: <a href = '../" + previousMonth.getYear() + PATH_SEPARATOR + previousMonth.getMonthTitle() + HTML + "'>"
                    + previousMonth.getYear() + " " + previousMonth.getMonthTitle()
                    + "</a>" + NEW_LINE;
        result += "<br>";
        if (nextMonth != null)
            result += "Next month: <a href = '../" + nextMonth.getYear() + PATH_SEPARATOR + nextMonth.getMonthTitle() + HTML + "'>"
                    + nextMonth.getYear() + " " + nextMonth.getMonthTitle()
                    + "</a>" + NEW_LINE;
        result += "<br>";
        result += renderer.render(currentMonth);
        try {
            File file = new File(FOLDER + PATH_SEPARATOR + currentMonth.getYear());
            file.mkdirs();
            file = new File(FOLDER + PATH_SEPARATOR + currentMonth.getYear() + PATH_SEPARATOR + currentMonth.getMonthTitle() + HTML);
            file.createNewFile();
            Writer out = new FileWriter(file);
            out.write(result);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
