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

    @Override
    public boolean equals(Object o){
        if (o instanceof Day){
            Calendar otherCalendar = ((Day) o).calendar;
            boolean result = true;
            result = result && calendar.get(Calendar.YEAR) == otherCalendar.get(Calendar.YEAR);
            result = result && calendar.get(Calendar.MONTH) == otherCalendar.get(Calendar.MONTH);
            result = result && calendar.get(Calendar.DAY_OF_MONTH) == otherCalendar.get(Calendar.DAY_OF_MONTH);
            return result;
        } else {
            return false;
        }
    }

}
