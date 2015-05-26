package alex;

import alex.renderer.AbstractCalendarRenderer;
import java.io.File;

public class CalendarFileWriterHelper {
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

    private AbstractCalendarRenderer renderer;

    CalendarFileWriterHelper(AbstractCalendarRenderer renderer){
        this.renderer = renderer;
    }

    private String appendTag(String contents, String tag, String tagParam) {
        String result = EMPTY;
        result += TAG_OPEN + tag + SPACE + tagParam + TAG_CLOSE;
        result += contents;
        result += TAG_END + tag + TAG_CLOSE + NEW_LINE;
        return result;
    }

    private String generateHRef(MonthCalendar monthCalendar){
        String result = appendTag(monthCalendar.getYear() + SPACE + monthCalendar.getMonthTitle(),
                LINK_TAG, HREF + BRACE + UPPER_FOLDER + File.separator + getRelativeFilenameForMonth(monthCalendar) + BRACE);
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
