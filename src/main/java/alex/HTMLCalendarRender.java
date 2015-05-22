package alex;

public class HTMLCalendarRender extends CalendarRender {

    private static final String TAB = "\t";
    private static final String NL = "\n";
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


    private String appendTag(String contents, String tag) {
        String result = EMPTY;
        result += OPEN_TAG + tag + CLOSE_TAG;
        result += contents;
        result += END_TAG + tag + CLOSE_TAG + NL;
        return result;
    }

    private String appendTag(String contents, String tag, String tagParam) {
        String result = EMPTY;
        result += OPEN_TAG + tag + SPACE + tagParam + CLOSE_TAG;
        result += contents;
        result += END_TAG + tag + CLOSE_TAG + NL;
        return result;
    }

    @Override
    String openMonthToken() {
        return OPEN_TAG + TABLE + SPACE + "border = 1" + CLOSE_TAG + NL;
    }

    @Override
    String closeMonthToken() {
        return END_TAG + TABLE + CLOSE_TAG + NL;
    }

    @Override
    String openDayOfWeekToken() {
        return OPEN_TAG + TH + CLOSE_TAG;
    }

    @Override
    String closeDayOfWeekToken() {
        return END_TAG + TH + CLOSE_TAG + NL;
    }

    @Override
    String openWeekToken() {
        return OPEN_TAG + TR + CLOSE_TAG + NL;
    }

    @Override
    String closeWeekToken() {
        return END_TAG + TR + CLOSE_TAG + NL;
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
        return END_TAG + TD + CLOSE_TAG + NL;
    }
}
