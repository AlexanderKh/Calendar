package alex.calendar;

import java.util.Calendar;

public class Day {
    private DayOfWeek type;
    private Calendar calendar;

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

    public DayOfWeek getType() {
        return type;
    }

}
