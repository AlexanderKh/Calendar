package alex;

public class ConsoleCalendarRender extends CalendarRender{

    private static final String RED = "\u001B[31m";
    private static final String BLACK = "\u001B[0m";
    private static final String TAB = "\t";
    private static final String NL = "\n";



    @Override
    String openMonthToken() {
        return NL;
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
        return NL;
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

