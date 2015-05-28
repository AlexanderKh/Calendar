package alex.renderer;

import alex.calendar.DayOfWeek;

public class ConsoleCalendarRenderer extends AbstractCalendarRenderer {

    private static final String RED = "\u001B[31m";
    private static final String BLACK = "\u001B[0m";
    private static final String TAB = "\t";

    @Override
    String openMonthToken() {
        return NEW_LINE;
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

