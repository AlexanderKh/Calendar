package alex;

import alex.renderer.AbstractCalendarRenderer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CalendarWriter {
    private static final String EMPTY = "";
    private static final String HTML = ".html";
    private static final String NEW_LINE = "\n";
    private static final String SLASH = "/";
    private static final String BRACE = "'";
    private static final String TAG_OPEN = "<";
    private static final String TAG_CLOSE = ">";
    private static final String TAG_END = "</";
    private static final String BR = "<br>";
    private AbstractCalendarRenderer renderer;
    private File path;

    CalendarWriter(AbstractCalendarRenderer renderer, File path){
        this.renderer = renderer;
        this.path = path;
    }

    public void generateFilesForCalendarSet(CalendarSet<MonthCalendar> monthCalendars){
        clearPath(path);
        for (int i = 0; i < monthCalendars.size(); i++) {
            printMonthToFile(monthCalendars.getPreviousFor(i),
                            monthCalendars.get(i),
                            monthCalendars.getNextFor(i));
        }
    }

    private void clearPath(File path) {
        if (path.isDirectory()){
            for (File subPath : path.listFiles())
                clearPath(subPath);
        }
        path.delete();
        path.mkdir();
    }

    private String generatehref(MonthCalendar monthCalendar){
        String result = EMPTY;
        result += TAG_OPEN + "a href = ";
        result += BRACE + ".." + SLASH + monthCalendar.getYear() + SLASH + monthCalendar.getMonthTitle() + HTML + BRACE + TAG_CLOSE;
        result += monthCalendar.getYear() + " " + monthCalendar.getMonthTitle();
        result += TAG_END + "a" + TAG_CLOSE;
        result += NEW_LINE;

        return result;
    }

    private void printMonthToFile(MonthCalendar previousMonth, MonthCalendar currentMonth, MonthCalendar nextMonth){
        String result = "";
        if (previousMonth != null)
            result += generatehref(previousMonth);
        result += BR;
        if (nextMonth != null)
            result += generatehref(nextMonth);
        result += BR;
        result += renderer.render(currentMonth);
        try {
            File yearDirectory = new File(path.getAbsolutePath() + SLASH + currentMonth.getYear());
            yearDirectory.mkdirs();
            File monthHTML = new File(path.getAbsolutePath() + SLASH + currentMonth.getYear() + SLASH + currentMonth.getMonthTitle() + HTML);
            monthHTML.createNewFile();
            Writer out = new FileWriter(monthHTML);
            out.write(result);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
