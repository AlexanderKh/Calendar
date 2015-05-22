package alex.renderer;

import alex.DayOfWeek;

public class HTMLCalendarRenderer extends AbstractCalendarRenderer {

    private static final String TR = "tr";
    private static final String OPEN_TAG = "<";
    private static final String CLOSE_TAG = ">";
    private static final String BLACK = "BLACK";
    private static final String RED = "RED";
    private static final String TABLE = "table";
    private static final String END_TAG = "</";
    private static final String TD = "td";
    private static final String TH = "th";
    private static final String SPACE = " ";
    private static final String QUOTE = "'";
    public static final String TABLE_BORDER = "border = 1";

    @Override
    String openMonthToken() {
        return OPEN_TAG + TABLE + SPACE + TABLE_BORDER + CLOSE_TAG + NEW_LINE;
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
