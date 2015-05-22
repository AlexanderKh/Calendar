package alex;

public interface MonthFormatter {
    String getFormattedDay(Day day);
    String getFormattedWeek(Week week);
    String getFormattedMonth(MonthCalendar month);
    String getFormattedDayOfWeek(DayOfWeek dayOfWeek);
}
