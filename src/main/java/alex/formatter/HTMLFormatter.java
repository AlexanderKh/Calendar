package alex.formatter;

import alex.calendar.DayOfWeek;
import alex.calendar.MonthCalendar;
import alex.calendar.NavigableList;

import java.io.File;

public class HTMLFormatter extends AbstractFormatter {
    private static final String TR = "tr";
    private static final String OPEN_TAG = "<";
    private static final String CLOSE_TAG = ">";
    private static final String BLACK = "BLACK";
    private static final String RED = "RED";
    private static final String TABLE = "table";
    private static final String END_TAG = "</";
    private static final String TD = "td";
    private static final String TH = "th";
    private static final String QUOTE = "'";
    private static final String TABLE_BORDER = "border = 1";
    private static final String EMPTY = "";
    private static final String NEW_LINE = "\n";
    private static final String BRACE = "'";
    private static final String TAG_OPEN = "<";
    private static final String TAG_CLOSE = ">";
    private static final String TAG_END = "</";
    private static final String BR = "<br>";
    private static final String LINK_TAG = "a";
    private static final String HREF = " href = ";
    private static final String UPPER_FOLDER = "..";
    private static final String HTML = ".html";


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
                HREF + BRACE + UPPER_FOLDER + File.separator + getRelativeFilename(monthCalendar) + BRACE);
        result += NEW_LINE;

        return result;
    }

    @Override
    String getExtention() {
        return HTML;
    }

    @Override
    String openMonthToken(NavigableList<MonthCalendar> monthCalendars, int index) {
        String result = EMPTY;
        result += generateHRef(monthCalendars.getPreviousFor(index));
        result += BR;
        result += generateHRef(monthCalendars.getNextFor(index));
        result += BR;
        result += OPEN_TAG + TABLE + SPACE + TABLE_BORDER + CLOSE_TAG + NEW_LINE;
        return result;
    }

    @Override
    String closeMonthToken() {
        return END_TAG + TABLE + CLOSE_TAG + NEW_LINE;
    }

    @Override
    String openDayOfWeekToken() {
        return OPEN_TAG + TH + CLOSE_TAG;
    }

    @Override
    String closeDayOfWeekToken() {
        return END_TAG + TH + CLOSE_TAG + NEW_LINE;
    }

    @Override
    String openWeekToken() {
        return OPEN_TAG + TR + CLOSE_TAG + NEW_LINE;
    }

    @Override
    String closeWeekToken() {
        return END_TAG + TR + CLOSE_TAG + NEW_LINE;
    }

    @Override
    String openDayToken(DayOfWeek dayOfWeek) {
        String result = OPEN_TAG + TD + SPACE + "style = " + QUOTE + "color : ";
        result += dayOfWeek.weekendDay() ? RED : BLACK;
        result += QUOTE;
        result += CLOSE_TAG;

        return result;
    }

    @Override
    String closeDayToken() {
        return END_TAG + TD + CLOSE_TAG + NEW_LINE;
    }

}
