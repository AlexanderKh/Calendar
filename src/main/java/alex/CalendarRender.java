package alex;

public abstract class CalendarRender {
    String render(MonthCalendar monthCalendar){
        String result = openMonthToken();

        result = printHeader(result);

        result = printWeek(monthCalendar, result);

        result += closeMonthToken();

        return result;
    }

    private String printHeader(String result) {
        result += openWeekToken();
        for (DayOfWeek dayOfWeek : DayOfWeek.values()){
            result += openDayOfWeekToken();
            result += dayOfWeek.title();
            result += closeDayOfWeekToken();
        }
        result += closeWeekToken();
        return result;
    }

    private String printWeek(MonthCalendar monthCalendar, String result) {
        for (Week week : monthCalendar.getWeeks()){
            result += openWeekToken();
            result = printDay(result, week);
            result += closeWeekToken();
        }
        return result;
    }

    private String printDay(String result, Week week) {
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
