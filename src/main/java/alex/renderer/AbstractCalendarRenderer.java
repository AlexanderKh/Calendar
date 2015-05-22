package alex.renderer;

import alex.Day;
import alex.DayOfWeek;
import alex.MonthCalendar;
import alex.Week;

public abstract class AbstractCalendarRenderer {

    protected static final String EMPTY = "";
    protected static final String NEW_LINE = "\n";

    public String render(MonthCalendar monthCalendar){
        String result = EMPTY;
        result += openMonthToken();
        result += printHeader();
        result += printWeeks(monthCalendar);
        result += closeMonthToken();

        return result;
    }

    private String printHeader() {
        String result = EMPTY;
        result += openWeekToken();
        for (DayOfWeek dayOfWeek : DayOfWeek.values()){
            result += openDayOfWeekToken();
            result += dayOfWeek.title();
            result += closeDayOfWeekToken();
        }
        result += closeWeekToken();

        return result;
    }

    private String printWeeks(MonthCalendar monthCalendar) {
        String result = EMPTY;
        for (Week week : monthCalendar.getWeeks()){
            result += openWeekToken();
            result += printDays(week);
            result += closeWeekToken();
        }

        return result;
    }

    private String printDays(Week week) {
        String result = EMPTY;
        for (Day day : week.getDays()){
            result += openDayToken(day.getType());
            result += day.getDayInMonth();
            result += closeDayToken();
        }

        return result;
    }

    abstract String openMonthToken();
    abstract String closeMonthToken();
    abstract String openDayOfWeekToken();
    abstract String closeDayOfWeekToken();
    abstract String openWeekToken();
    abstract String closeWeekToken();
    abstract String openDayToken(DayOfWeek dayOfWeek);
    abstract String closeDayToken();
}
