package alex;

import alex.renderer.AbstractCalendarRenderer;

import java.io.File;

public class CalendarFileWriterHelper {
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

    CalendarFileWriterHelper(AbstractCalendarRenderer renderer){
        this.renderer = renderer;
    }

    public String generateHRef(MonthCalendar monthCalendar){
        String result = EMPTY;
        result += TAG_OPEN + LINK_TAG + HREF;
        result += BRACE + UPPER_FOLDER + File.separator + getRelativeFilenameForMonth(monthCalendar) + BRACE + TAG_CLOSE;
        result += monthCalendar.getYear() + SPACE + monthCalendar.getMonthTitle();
        result += TAG_END + LINK_TAG + TAG_CLOSE;
        result += NEW_LINE;
        return result;
    }

    public String formatMonthCalendarToHTML(MonthCalendar previousMonth, MonthCalendar currentMonth, MonthCalendar nextMonth){
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

    public String getRelativeFilenameForMonth(MonthCalendar monthCalendar){
        return monthCalendar.getYear() + File.separator + monthCalendar.getMonthNumber()
                + SPACE + monthCalendar.getMonthTitle() + HTML;
    }
}
