package alex.formatter;

import alex.CalendarFormatter;
import alex.calendar.*;

import java.io.File;

public abstract class AbstractFormatter implements CalendarFormatter {
    protected static final String EMPTY = "";
    protected static final String NEW_LINE = "\n";
    protected static final String SPACE = " ";
    protected static final String TAB = "\t";


    public String render(NavigableList<MonthCalendar> monthCalendars, int index){
        String result = EMPTY;
        result += openMonthToken(monthCalendars, index);
        result += printHeader();
        result += printWeeks(monthCalendars.get(index));
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


    public String getRelativeFilename(MonthCalendar monthCalendar){
        return monthCalendar.getYear() + File.separator + monthCalendar.getMonthNumber()
                + SPACE + monthCalendar.getMonthTitle() + getExtension();
    }

    abstract String getExtension();
    abstract String openMonthToken(NavigableList<MonthCalendar> monthCalendars, int index);
    abstract String closeMonthToken();
    abstract String openDayOfWeekToken();
    abstract String closeDayOfWeekToken();
    abstract String openWeekToken();
    abstract String closeWeekToken();
    abstract String openDayToken(DayOfWeek dayOfWeek);
    abstract String closeDayToken();
}
