package alex.formatter;

import alex.calendar.DayOfWeek;
import alex.calendar.MonthCalendar;
import alex.calendar.NavigableList;

import java.io.File;

public class HTMLFormatter extends AbstractFormatter {
    private static final String BLACK = "BLACK";
    private static final String RED = "RED";
    private static final String TABLE = "table";
    private static final String TR = "tr";
    private static final String TD = "td";
    private static final String TH = "th";
    private static final String QUOTE = "'";
    private static final String TABLE_BORDER = "border = 1";
    private static final String TAG_OPEN = "<";
    private static final String TAG_CLOSE = ">";
    private static final String TAG_END = "</";
    private static final String BR = "<br>";
    private static final String LINK_TAG = "a";
    private static final String HREF = " href = ";
    private static final String UPPER_FOLDER = "..";
    private static final String HTML = ".html";
    private static final String BOLD = "b";


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
                HREF + QUOTE + UPPER_FOLDER + File.separator + getRelativeFilename(monthCalendar) + QUOTE);
        result += NEW_LINE;

        return result;
    }

    @Override
    String getExtension() {
        return HTML;
    }

    @Override
    String openMonthToken(NavigableList<MonthCalendar> monthCalendars, int index) {
        String result = EMPTY;
        result += generateHRef(monthCalendars.getPreviousFor(index));
        result += BR;
        result += generateHRef(monthCalendars.getNextFor(index));
        result += BR;
        result += appendTag(monthCalendars.get(index).getYear() + SPACE + monthCalendars.get(index).getMonthTitle(),
                BOLD, EMPTY);
        result += BR;
        result += TAG_OPEN + TABLE + SPACE + TABLE_BORDER + TAG_CLOSE + NEW_LINE;

        return result;
    }

    @Override
    String closeMonthToken() {
        return TAG_END + TABLE + TAG_CLOSE + NEW_LINE;
    }

    @Override
    String openDayOfWeekToken() {
        return TAG_OPEN + TH + TAG_CLOSE;
    }

    @Override
    String closeDayOfWeekToken() {
        return TAG_END + TH + TAG_CLOSE + NEW_LINE;
    }

    @Override
    String openWeekToken() {
        return TAG_OPEN + TR + TAG_CLOSE + NEW_LINE;
    }

    @Override
    String closeWeekToken() {
        return TAG_END + TR + TAG_CLOSE + NEW_LINE;
    }

    @Override
    String openDayToken(DayOfWeek dayOfWeek) {
        String result = EMPTY;
        result += TAG_OPEN + TD + SPACE + "style = " + QUOTE + "color : ";
        result += dayOfWeek.weekendDay() ? RED : BLACK;
        result += QUOTE + TAG_CLOSE;

        return result;
    }

    @Override
    String closeDayToken() {
        return TAG_END + TD + TAG_CLOSE + NEW_LINE;
    }

}
