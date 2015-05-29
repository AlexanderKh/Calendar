package alex.formatter;


import alex.calendar.DayOfWeek;
import alex.calendar.MonthCalendar;
import alex.calendar.NavigableList;

public class TextFormatter extends AbstractFormatter{
    private static final String TEXT = ".txt";

    @Override
    String getExtension() {
        return TEXT;
    }

    @Override
    String openMonthToken(NavigableList<MonthCalendar> monthCalendars, int index) {
        return EMPTY;
    }

    @Override
    String closeMonthToken() {
        return EMPTY;
    }

    @Override
    String openDayOfWeekToken() {
        return EMPTY;
    }

    @Override
    String closeDayOfWeekToken() {
        return TAB;
    }

    @Override
    String openWeekToken() {
        return EMPTY;
    }

    @Override
    String closeWeekToken() {
        return NEW_LINE;
    }

    @Override
    String openDayToken(DayOfWeek dayOfWeek) {
        return EMPTY;
    }

    @Override
    String closeDayToken() {
        return TAB;
    }
}

