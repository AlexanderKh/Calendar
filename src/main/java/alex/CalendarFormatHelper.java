package alex;

import alex.calendar.MonthCalendar;
import alex.calendar.NavigableList;
import alex.renderer.AbstractCalendarRenderer;
import alex.renderer.HTMLCalendarRenderer;

import java.io.File;

public class CalendarFormatHelper {
    private static final String EMPTY = "";
    private static final String HTML = ".html";
    private static final String NEW_LINE = "\n";
    private static final String BRACE = "'";
    private static final String TAG_OPEN = "<";
    private static final String TAG_CLOSE = ">";
    private static final String TAG_END = "</";
    private static final String BR = "<br>";
    private static final String LINK_TAG = "a";
    private static final String HREF = " href = ";
    private static final String SPACE = " ";
    private static final String UPPER_FOLDER = "..";

    private AbstractCalendarRenderer renderer = new HTMLCalendarRenderer();

    private String appendTag(String contents, String tag, String tagParam) {
        String result = EMPTY;
        result += TAG_OPEN + tag + SPACE + tagParam + TAG_CLOSE;
        result += contents;
        result += TAG_END + tag + TAG_CLOSE + NEW_LINE;

        return result;
    }

    private String generateHRef(MonthCalendar monthCalendar){
        if (monthCalendar == null) return EMPTY;
        String result = appendTag(monthCalendar.getYear() + SPACE + monthCalendar.getMonthTitle(),
                LINK_TAG,
                HREF + BRACE + UPPER_FOLDER + File.separator + getRelativeFilenameForMonth(monthCalendar) + BRACE);
        result += NEW_LINE;

        return result;
    }

    public String formatMonthCalendarToHTML(NavigableList<MonthCalendar> monthCalendars, int currentMonth){
        String result = EMPTY;
        result += generateHRef(monthCalendars.getPreviousFor(currentMonth));
        result += BR;
        result += generateHRef(monthCalendars.getNextFor(currentMonth));
        result += BR;
        result += renderer.render(monthCalendars.get(currentMonth));

        return result;
    }

    public String getRelativeFilenameForMonth(MonthCalendar monthCalendar){
        return monthCalendar.getYear() + File.separator + monthCalendar.getMonthNumber()
                + SPACE + monthCalendar.getMonthTitle() + HTML;
    }
}
