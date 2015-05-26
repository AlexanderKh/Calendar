package alex;

import alex.renderer.AbstractCalendarRenderer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CalendarFileWriter {
    private static final String EMPTY = "";
    private static final String HTML = ".html";
    private static final String NEW_LINE = "\n";
    private static final String SLASH = "/";
    private static final String BRACE = "'";
    private static final String TAG_OPEN = "<";
    private static final String TAG_CLOSE = ">";
    private static final String TAG_END = "</";
    private static final String BR = "<br>";
    private static final String LINK_TAG = "a";
    private static final String HREF = " href = ";
    private static final String SPACE = " ";
    private static final String UPPER_FOLDER = "..";

    private AbstractCalendarRenderer renderer;
    private File path;

    CalendarFileWriter(AbstractCalendarRenderer renderer, File path){
        this.renderer = renderer;
        this.path = path;
    }

    public void generateFilesForCalendarSet(CalendarSet<MonthCalendar> monthCalendars){
        clearPath(path);
        path.mkdir();
        for (int i = 0; i < monthCalendars.size(); i++) {
            String currentMonthString = formatMonthCalendarToHTML(monthCalendars.getPreviousFor(i),
                                                                monthCalendars.get(i),
                                                                monthCalendars.getNextFor(i));
            String currentMonthFilepath = getRelativeFilenameForMonth(monthCalendars.get(i));
            writeMonthToFile(currentMonthFilepath, currentMonthString);
        }
    }

    private void writeMonthToFile(String filepath, String representation){
        try {
            File file = new File(path.getAbsolutePath() + File.separator + filepath);
            file.getParentFile().mkdirs();
            file.createNewFile();
            Writer out = new FileWriter(file);
            out.write(representation);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void clearPath(File path) {
        if (path.isDirectory()){
            for (File subPath : path.listFiles())
                clearPath(subPath);
        }
        path.delete();
    }

    private String generateHRef(MonthCalendar monthCalendar){
        String result = EMPTY;
        result += TAG_OPEN + LINK_TAG + HREF;
        result += BRACE + UPPER_FOLDER + File.separator + getRelativeFilenameForMonth(monthCalendar) + BRACE + TAG_CLOSE;
        result += monthCalendar.getYear() + SPACE + monthCalendar.getMonthTitle();
        result += TAG_END + LINK_TAG + TAG_CLOSE;
        result += NEW_LINE;
        return result;
    }

    private String formatMonthCalendarToHTML(MonthCalendar previousMonth, MonthCalendar currentMonth, MonthCalendar nextMonth){
        String result = "";
        if (previousMonth != null)
            result += generateHRef(previousMonth);
        result += BR;
        if (nextMonth != null)
            result += generateHRef(nextMonth);
        result += BR;
        result += renderer.render(currentMonth);

        return result;
    }

    private String getRelativeFilenameForMonth(MonthCalendar monthCalendar){
        return monthCalendar.getYear() + File.separator + monthCalendar.getMonthNumber()
                + SPACE + monthCalendar.getMonthTitle() + HTML;
    }
}
