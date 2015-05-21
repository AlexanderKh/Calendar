package alex;

import java.util.Calendar;

public class Day {
    private DayOfWeek type;
    private Calendar date;

    public static final String RED = "\u001B[31m";
    public static final String BLACK = "\u001B[0m";

    Day(Calendar date, DayOfWeek type){
        this.date = date;
        this.type = type;
    }

    public int getDayInMonth(){
        return date.get(Calendar.DAY_OF_MONTH);
    }

    public Calendar getCalendar(){
        return date;
    }

    @Override
    public String toString(){
        String result;
        if (type.weekendDay()){
            result = RED;
        }else {
            result = BLACK;
        }
        result += getDayInMonth();
        return result;
    }

}
