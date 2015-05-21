package alex;

public class WierdClassForText implements WierdInterface{

    public static final String RED = "\u001B[31m";
    public static final String BLACK = "\u001B[0m";

    public String getFormattedDay(Day day){
        DayOfWeek type = day.getType();
        String result = type.weekendDay() ? RED : BLACK;
        result += day.getDayInMonth();
        return result;
    }

    public String getFormattedWeek(Week week){
        String result = "";
        for (Day day : week.getDays())
            result += day.toString() + "\t";
        return result;
    }

    public String getFormattedMonth(MonthCalendar month){
        String result = "";
        for (DayOfWeek dayOfWeek : DayOfWeek.values())
            result += dayOfWeek + "\t";
        for (Week week : month.getWeeks())
            result += "\n" + week.toString();
        result += BLACK;
        return result;
    }

    public String getFormattedDayOfWeek(DayOfWeek dayOfWeek) {
        String result = dayOfWeek.weekendDay() ? RED : BLACK;
        result += dayOfWeek.title();
        return result;
    }
}
