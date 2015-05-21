package alex;

import java.util.Calendar;

public class Day {
    private DayOfWeek type;
    private Calendar calendar;

    public static final String RED = "\u001B[31m";
    public static final String BLACK = "\u001B[0m";

    Day(Calendar calendar, DayOfWeek type){
        this.calendar = calendar;
        this.type = type;
    }

    public int getDayInMonth(){
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public Calendar getCalendar(){
        return calendar;
    }

    @Override
    public String toString(){
        String result = type.weekendDay() ? RED : BLACK;
        result += getDayInMonth();
        return result;
    }

    public String toHTML(){
        String result = "\t<td style='color:";
        result += type.weekendDay() ? "RED" : "BLACK";
        result += "'>" + getDayInMonth() + "</td>";
        return result;
    }

}
