package alex.formatter;

import alex.calendar.DayOfWeek;
import alex.calendar.MonthCalendar;
import alex.calendar.NavigableList;

public class ConsoleFormatter extends AbstractFormatter {

    private static final String RED = "\u001B[31m";
    private static final String BLACK = "\u001B[0m";
    private static final String TAB = "\t";
    private static final String TEXT = ".txt";


    @Override
    String getExtention() {
        return TEXT;
    }

    @Override
    String openMonthToken(NavigableList<MonthCalendar> monthCalendars, int index) {
        MonthCalendar monthCalendar = monthCalendars.get(index);
        return monthCalendar.getYear() + SPACE + monthCalendar.getMonthTitle() + NEW_LINE;
    }

    @Override
    String closeMonthToken() {
        return BLACK;
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
        return dayOfWeek.weekendDay() ? RED : BLACK;
    }

    @Override
    String closeDayToken() {
        return TAB;
    }
}

