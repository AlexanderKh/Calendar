package alex;

public class ConsoleCalendarRender  implements CalendarRender{

    public static final String RED = "\u001B[31m";
    public static final String BLACK = "\u001B[0m";
    public static final String TAB = "\t";
    public static final String NL = "\n";

    public String render(MonthCalendar monthCalendar) {
        return renderMonth(monthCalendar);
    }

    private String renderDay(Day day){
        DayOfWeek type = day.getType();
        String result = type.weekendDay() ? RED : BLACK;
        result += day.getDayInMonth();

        return result;
    }

    private String renderWeek(Week week){
        String result = "";
        for (Day day : week.getDays())
            result += renderDay(day) + TAB;

        return result;
    }

    private String renderMonth(MonthCalendar month){
        String result = "";
        for (DayOfWeek dayOfWeek : DayOfWeek.values())
            result += renderDayOfWeek(dayOfWeek) + TAB;
        for (Week week : month.getWeeks())
            result += NL + renderWeek(week);
        result += BLACK;

        return result;
    }

    private String renderDayOfWeek(DayOfWeek dayOfWeek) {
        String result = dayOfWeek.weekendDay() ? RED : BLACK;
        result += dayOfWeek.title();

        return result;
    }

}
